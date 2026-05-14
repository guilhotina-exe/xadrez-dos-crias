package jogo;

import tabuleiro.Tabuleiro;
import tabuleiro.Casa;
import java.io.Serializable;

public class Jogo implements Serializable {
    private Tabuleiro tabuleiro;
    private Jogador jogador1;
    private Jogador jogador2;
    private Jogador jogadorAtual;
    private Casa casaSelecionada;

    public Jogo() {
        this.tabuleiro = new Tabuleiro();
        this.jogador1 = new Jogador("Player 1", "branco");
        this.jogador2 = new Jogador("Player 2", "preto");
        this.jogadorAtual = jogador1;
        this.casaSelecionada = null;
    }

    public boolean selecionar(int linha, int coluna) {
        Casa casa = tabuleiro.getCasa(linha, coluna);

        if (casaSelecionada == null) {
            if (!casa.estaVazia() && casa.getPeca().getCor().equals(jogadorAtual.getCor())) {
                casaSelecionada = casa;
                return false;
            }
            return false;
        }

        if (ValidacaoDeMovimento.movimentoValido(tabuleiro, casaSelecionada, casa)) {
            mover(casaSelecionada, casa);
            casaSelecionada = null;
            trocarTurno();
            return true;
        }

        casaSelecionada = null;
        return false;
    }

    private void mover(Casa origem, Casa destino) {
        destino.setPeca(origem.getPeca());
        origem.setPeca(null);
    }

    private void trocarTurno() {
        jogadorAtual = jogadorAtual == jogador1 ? jogador2 : jogador1;
    }

    public Tabuleiro getTabuleiro() { return tabuleiro; }
    public Jogador getJogadorAtual() { return jogadorAtual; }
    public Casa getCasaSelecionada() { return casaSelecionada; }
}