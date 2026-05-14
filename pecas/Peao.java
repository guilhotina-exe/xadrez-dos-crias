package pecas;

public class Peao extends Peca {
    public Peao(String cor) {
        super(cor);
        this.simbolo = cor.equals("branco") ? "♙" : "♟";
    }
}