package jogo;

import tabuleiro.Tabuleiro;
import tabuleiro.Casa;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bot extends Jogador {

    private transient Random random = new Random();

    public Bot(String nome, String cor) {
        super(nome, cor);
    }

    public void jogarFacil(Jogo jogo) {
        Tabuleiro tabuleiro = jogo.getTabuleiro();
        List<Casa> minhasPecas = new ArrayList<>();
        List<Casa> destinosValidos = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Casa casa = tabuleiro.getCasa(i, j);
                if (!casa.estaVazia() && casa.getPeca().getCor().equals(getCor())) {
                    minhasPecas.add(casa);
                }
            }
        }

        while (destinosValidos.isEmpty()) {
            Casa origem = minhasPecas.get(random.nextInt(minhasPecas.size()));
            destinosValidos.clear();

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    Casa destino = tabuleiro.getCasa(i, j);
                    if (ValidacaoDeMovimento.movimentoValido(tabuleiro, origem, destino)) {
                        destinosValidos.add(destino);
                    }
                }
            }

            if (!destinosValidos.isEmpty()) {
                jogo.selecionar(origem.getLinha(), origem.getColuna());
                Casa destEscolhido = destinosValidos.get(random.nextInt(destinosValidos.size()));
                jogo.selecionar(destEscolhido.getLinha(), destEscolhido.getColuna());
            }
        }
    }
}
