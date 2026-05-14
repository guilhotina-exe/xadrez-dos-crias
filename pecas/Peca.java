package pecas;

import java.io.Serializable;

public abstract class Peca implements Serializable {
    protected String cor;
    protected String simbolo;

    public Peca(String cor) {
        this.cor = cor;
    }

    public String getCor() { return cor; }
    public String getSimbolo() { return simbolo; }
}