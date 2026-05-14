package jogo;

import tabuleiro.Casa;
import tabuleiro.Tabuleiro;
import pecas.Peca;

public class ValidacaoDeMovimento {

    public static boolean movimentoValido(Tabuleiro tabuleiro, Casa origem, Casa destino) {

        if (origem.estaVazia()) return false;

        if (!destino.estaVazia()) {
            if (destino.getPeca().getCor().equals(origem.getPeca().getCor())) {
                return false;
            }
        }

        Peca peca = origem.getPeca();
        int linhaOrigem = origem.getLinha();
        int colunaOrigem = origem.getColuna();
        int linhaDestino = destino.getLinha();
        int colunaDestino = destino.getColuna();

        int dl = linhaDestino - linhaOrigem;
        int dc = colunaDestino - colunaOrigem;

        String tipo = peca.getClass().getSimpleName();

        switch (tipo) {
            case "Rei":
                return Math.abs(dl) <= 1 && Math.abs(dc) <= 1;

            case "Rainha":
                return dl == 0 || dc == 0 || Math.abs(dl) == Math.abs(dc);

            case "Torre":
                return dl == 0 || dc == 0;

            case "Bispo":
                return Math.abs(dl) == Math.abs(dc);

            case "Cavalo":
                return (Math.abs(dl) == 2 && Math.abs(dc) == 1) ||
                       (Math.abs(dl) == 1 && Math.abs(dc) == 2);

            case "Peao":
                return validarPeao(peca, dl, dc, destino);

            default:
                return false;
        }
    }

    private static boolean validarPeao(Peca peca, int dl, int dc, Casa destino) {
        int direcao = peca.getCor().equals("branco") ? -1 : 1;

        if (dc == 0 && dl == direcao && destino.estaVazia()) return true;

        if (Math.abs(dc) == 1 && dl == direcao && !destino.estaVazia()) return true;

        return false;
    }
}