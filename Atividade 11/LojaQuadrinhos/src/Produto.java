import java.text.NumberFormat;
import java.util.Locale;

public class Produto implements ComponenteCaixa {
    private final String nome;
    private final double valor;

    public Produto(String nome, double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public void exibir() {
        NumberFormat moeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        System.out.println(getNome() + " - " + moeda.format(getValor()));
    }
}
