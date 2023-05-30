package br.com.batmanapi.library.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "personagens")
public class Personagem {
    @Id
    private int id;
    
    @Column(length = 50, nullable = false)
    private String nome;
    
    @Column(nullable = false)
    private double altura;
    
    @Column(nullable = false)
    private double peso;
    
    @Column(length = 50, nullable = false)
    private String statusAtual;
    
    @Column(length = 100, nullable = false)
    private String primeiraAparicao;
    
    @Column(length = 500, nullable = false)
    private String resumoPersonagem;
    
    @ManyToOne
    private Localizacao localizacao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getStatusAtual() {
        return statusAtual;
    }

    public void setStatusAtual(String statusAtual) {
        this.statusAtual = statusAtual;
    }

    public String getPrimeiraAparicao() {
        return primeiraAparicao;
    }

    public void setPrimeiraAparicao(String primeiraAparicao) {
        this.primeiraAparicao = primeiraAparicao;
    }

    public String getResumoPersonagem() {
        return resumoPersonagem;
    }

    public void setResumoPersonagem(String resumoPersonagem) {
        this.resumoPersonagem = resumoPersonagem;
    }
    
    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }
}
