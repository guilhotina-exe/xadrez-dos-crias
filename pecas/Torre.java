package pecas;

public class Torre extends Peca {
    public Torre(String cor) {
        super(cor);
        this.simbolo = cor.equals("branco") ? "♖" : "♜";
    }
}