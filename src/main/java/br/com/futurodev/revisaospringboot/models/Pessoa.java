package br.com.futurodev.revisaospringboot.models;

public class Pessoa {

    private static Long sequence = 1L;

    private Long id;
    private String nome;
    private String numeroDocumento;

    public Pessoa(String nome, String numeroDocumento) {
        this.id = generateId();
        this.nome = nome;
        this.numeroDocumento = numeroDocumento;
    }

    private Long generateId() {
        return sequence++;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

}

