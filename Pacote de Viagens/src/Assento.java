public class Assento {
    private final int fileira;
    private final char letra;
    private final ClasseVoo classeVoo;
    private final TipoPoltrona tipoPoltrona;
    private final LadoAeronave ladoAeronave;
    private final double preco;

    public Assento(int fileira, char letra, ClasseVoo classeVoo, TipoPoltrona tipoPoltrona,
                   LadoAeronave ladoAeronave, double preco) {
        this.fileira = fileira;
        this.letra = letra;
        this.classeVoo = classeVoo;
        this.tipoPoltrona = tipoPoltrona;
        this.ladoAeronave = ladoAeronave;
        this.preco = preco;
    }

    public int getFileira() {
        return fileira;
    }

    public char getLetra() {
        return letra;
    }

    public ClasseVoo getClasseVoo() {
        return classeVoo;
    }

    public TipoPoltrona getTipoPoltrona() {
        return tipoPoltrona;
    }

    public LadoAeronave getLadoAeronave() {
        return ladoAeronave;
    }

    public double getPreco() {
        return preco;
    }

    public String getCodigo() {
        return fileira + String.valueOf(letra);
    }
}
