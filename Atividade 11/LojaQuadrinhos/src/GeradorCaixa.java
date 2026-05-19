import java.util.Random;

public class GeradorCaixa {
    private static final Random random = new Random();

    private static final Produto[] produtos = {
            new Produto("Quadrinho", 15.00),
            new Produto("Chaveiro", 5.00),
            new Produto("Busto", 10.00),
            new Produto("Adesivo", 1.00),
            new Produto("Poster", 25.00),
            new Produto("Camiseta", 25.00),
            new Produto("Caneta", 3.00),
            new Produto("Miniatura", 20.00)
    };

    public static CaixaAssinatura gerar(NivelCliente nivel) {
        CaixaAssinatura caixa = new CaixaAssinatura(nivel.getNome());

        for (int i = 0; i < nivel.getQuantidadeItens(); i++) {
            Produto produto = produtos[random.nextInt(produtos.length)];
            caixa.adicionar(produto);
        }

        return caixa;
    }
}
