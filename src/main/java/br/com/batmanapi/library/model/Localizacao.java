package br.com.batmanapi.library.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "localizacoes")
public class Localizacao {
    @Id
    private int id;
    
    @Column(length = 50, nullable = false)
    private String nome;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCidade() {
        return nome;
    }

    public void setCidade(String nome) {
        this.nome = nome;
    }
}

