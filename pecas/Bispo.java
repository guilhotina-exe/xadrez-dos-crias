package pecas;

public class Bispo extends Peca {
    public Bispo(String cor) {
        super(cor);
        this.simbolo = cor.equals("branco") ? "♗" : "♝";
    }
}