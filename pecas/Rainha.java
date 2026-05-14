package pecas;

public class Rainha extends Peca {
    public Rainha(String cor) {
        super(cor);
        this.simbolo = cor.equals("branco") ? "♕" : "♛";
    }
}