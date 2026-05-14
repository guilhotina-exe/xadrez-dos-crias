package jogo;

import java.io.Serializable;

public class Jogador implements Serializable {
    private String nome;
    private String cor;

    public Jogador(String nome, String cor) {
        this.nome = nome;
        this.cor = cor;
    }

    public String getNome() { return nome; }
    public String getCor() { return cor; }
}