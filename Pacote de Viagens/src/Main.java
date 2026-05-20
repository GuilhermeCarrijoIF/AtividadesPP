import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final NumberFormat moeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

    public static void main(String[] args) {
        PacoteViagemFacade facade = new PacoteViagemFacade();

        System.out.println("=== Sistema de Venda de Pacote de Viagens ===");

        try {
            int quantidadePessoas = lerInteiro("Quantidade de pessoas: ", 1, 20);

            List<Pessoa> pessoas = new ArrayList<>();
            for (int i = 1; i <= quantidadePessoas; i++) {
                System.out.println("\nPessoa " + i + ":");
                String nome = lerTexto("Nome: ");
                String cpf = lerTexto("CPF: ");
                pessoas.add(new Pessoa(nome, cpf));
            }

            ClasseVoo classeVoo = escolherClasseVoo();

            List<String> assentos = new ArrayList<>();
            System.out.println("\nInforme os assentos da classe escolhida.");
            System.out.println("1ª Classe: fileiras 1 a 3 | Executiva: fileiras 4 a 8 | Econômica: fileiras 9 a 32");
            System.out.println("Letras disponíveis por fileira: A, B, C, D, E, F");

            for (Pessoa pessoa : pessoas) {
                String assento = lerTexto("Assento para " + pessoa.getNome() + " (ex: 9A): ");
                assentos.add(assento);
            }

            TipoQuarto tipoQuarto = escolherTipoQuarto();
            int diariasHotel = lerInteiro("Quantidade de diárias do hotel: ", 1, 365);

            TipoCarro tipoCarro = escolherTipoCarro();
            int diariasCarro = lerInteiro("Quantidade de diárias do carro: ", 1, 365);

            FormaPagamento formaPagamento = escolherFormaPagamento();
            int parcelas = 1;
            if (formaPagamento == FormaPagamento.CREDITO) {
                parcelas = lerInteiro("Quantidade de parcelas no crédito (1 a 6): ", 1, 6);
            }

            CompraPacote compra = facade.venderPacoteViagem(
                    pessoas,
                    classeVoo,
                    assentos,
                    tipoQuarto,
                    diariasHotel,
                    tipoCarro,
                    diariasCarro,
                    formaPagamento,
                    parcelas
            );

            System.out.println(compra.gerarResumo());
        } catch (IllegalArgumentException e) {
            System.out.println("\nErro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("\nErro inesperado: " + e.getMessage());
        }
    }

    private static ClasseVoo escolherClasseVoo() {
        System.out.println("\nEscolha a classe do voo:");
        System.out.println("1 - 1ª Classe | Fileiras 1 a 3 | " + moeda.format(4375.00));
        System.out.println("2 - Classe Executiva | Fileiras 4 a 8 | " + moeda.format(1750.00));
        System.out.println("3 - Classe Econômica | Fileiras 9 a 32 | " + moeda.format(500.00));

        int opcao = lerInteiro("Opção: ", 1, 3);

        switch (opcao) {
            case 1:
                return ClasseVoo.PRIMEIRA_CLASSE;
            case 2:
                return ClasseVoo.EXECUTIVA;
            case 3:
            default:
                return ClasseVoo.ECONOMICA;
        }
    }

    private static TipoQuarto escolherTipoQuarto() {
        System.out.println("\nEscolha o quarto do hotel:");
        System.out.println("1 - Simples | Diária por pessoa: " + moeda.format(TipoQuarto.SIMPLES.getDiariaPorPessoa()));
        System.out.println("2 - Executivo | Diária por pessoa: " + moeda.format(TipoQuarto.EXECUTIVO.getDiariaPorPessoa()));
        System.out.println("3 - Suíte Presidencial | Diária por pessoa: " + moeda.format(TipoQuarto.SUITE_PRESIDENCIAL.getDiariaPorPessoa()));

        int opcao = lerInteiro("Opção: ", 1, 3);

        switch (opcao) {
            case 1:
                return TipoQuarto.SIMPLES;
            case 2:
                return TipoQuarto.EXECUTIVO;
            case 3:
            default:
                return TipoQuarto.SUITE_PRESIDENCIAL;
        }
    }

    private static TipoCarro escolherTipoCarro() {
        System.out.println("\nEscolha o carro:");
        System.out.println("1 - Econômico | Diária: " + moeda.format(TipoCarro.ECONOMICO.getDiaria()));
        System.out.println("2 - Executivo | Diária: " + moeda.format(TipoCarro.EXECUTIVO.getDiaria()));
        System.out.println("3 - Luxo | Diária: " + moeda.format(TipoCarro.LUXO.getDiaria()));

        int opcao = lerInteiro("Opção: ", 1, 3);

        switch (opcao) {
            case 1:
                return TipoCarro.ECONOMICO;
            case 2:
                return TipoCarro.EXECUTIVO;
            case 3:
            default:
                return TipoCarro.LUXO;
        }
    }

    private static FormaPagamento escolherFormaPagamento() {
        System.out.println("\nEscolha a forma de pagamento:");
        System.out.println("1 - Pix | 10% de desconto");
        System.out.println("2 - Boleto | 5% de desconto");
        System.out.println("3 - Débito | valor normal");
        System.out.println("4 - Crédito | até 6x, juros de 3,99% por parcela a partir da 2ª");

        int opcao = lerInteiro("Opção: ", 1, 4);

        switch (opcao) {
            case 1:
                return FormaPagamento.PIX;
            case 2:
                return FormaPagamento.BOLETO;
            case 3:
                return FormaPagamento.DEBITO;
            case 4:
            default:
                return FormaPagamento.CREDITO;
        }
    }

    private static String lerTexto(String mensagem) {
        String texto;
        do {
            System.out.print(mensagem);
            texto = scanner.nextLine().trim();
        } while (texto.isEmpty());
        return texto;
    }

    private static int lerInteiro(String mensagem, int minimo, int maximo) {
        while (true) {
            System.out.print(mensagem);
            String entrada = scanner.nextLine().trim();

            try {
                int valor = Integer.parseInt(entrada);
                if (valor >= minimo && valor <= maximo) {
                    return valor;
                }
                System.out.println("Digite um número entre " + minimo + " e " + maximo + ".");
            } catch (NumberFormatException e) {
                System.out.println("Digite apenas números inteiros.");
            }
        }
    }
}
