package br.com.dio.desafio.dominio;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Data {
    private String nome;
    private static final AtomicInteger ID = new AtomicInteger();
    private final int id;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Data(){
        this.id = ID.incrementAndGet();
    }
    public String getId() {
        return idPrefix() + id;
    }
    protected abstract String idPrefix();
}
