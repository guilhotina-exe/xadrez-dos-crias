package pecas;

public class Cavalo extends Peca {
    public Cavalo(String cor) {
        super(cor);
        this.simbolo = cor.equals("branco") ? "♘" : "♞";
    }
}