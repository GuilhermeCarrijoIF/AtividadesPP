import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CaixaAssinatura implements ComponenteCaixa {
    private final String nome;
    private final List<ComponenteCaixa> itens = new ArrayList<>();

    public CaixaAssinatura(String nome) {
        this.nome = nome;
    }

    public void adicionar(ComponenteCaixa item) {
        itens.add(item);
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        double total = 0;

        for (ComponenteCaixa item : itens) {
            total += item.getValor();
        }

        return total;
    }

    public void exibir() {
        NumberFormat moeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

        System.out.println();
        System.out.println("Caixa: " + getNome());
        System.out.println("Itens:");

        for (ComponenteCaixa item : itens) {
            item.exibir();
        }

        System.out.println("Valor total: " + moeda.format(getValor()));
    }
}
