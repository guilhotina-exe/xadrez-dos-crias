package pecas;

public class Rei extends Peca {

    public Rei(String cor) {
        super(cor);
        this.simbolo = cor.equals("branco") ? "♔" : "♚";
    }
}