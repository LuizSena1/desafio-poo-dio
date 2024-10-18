package br.com.dio.desafio.dominio;

import java.util.*;

public class Dev extends Data{
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    public void inscreverBootcamp(Bootcamp bootcamp){
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.getDevsInscritos().add(this);
    }

    public void progredir() {
        Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
        if(conteudo.isPresent()) {
            this.conteudosConcluidos.add(conteudo.get());
            this.conteudosInscritos.remove(conteudo.get());
        } else {
            System.err.println("Você não está matriculado em nenhum conteúdo!");
        }
    }

    public double calcularTotalXp() {
        Iterator<Conteudo> iterator = this.conteudosConcluidos.iterator();
        double soma = 0;
        while(iterator.hasNext()){
            double next = iterator.next().calcularXp();
            soma += next;
        }
        return soma;
    }

    @Override
    protected String idPrefix() {
        return "Dev-";
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos = conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }
    public void ListarConteudoInscrito(){
        List<Conteudo> conteudoList = new ArrayList<>(conteudosInscritos);
        System.out.println("Conteudos Inscritos Dev " + this.getNome() +":");
        for(int i=0 ; i < conteudosInscritos.size(); i++){
            System.out.println(conteudoList.get(i));
        }
        System.out.println("-------------------");
    }

    public void ListarConcluidos(){
        List<Conteudo> conteudoList = new ArrayList<>(conteudosConcluidos);
        System.out.println("Conteudos Concluidos Dev " + this.getNome() +":");
        for(int i=0;i < conteudosConcluidos.size(); i++){
            System.out.println(conteudoList.get(i));
        }
        System.out.println("-------------------");
    }

    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }

}
