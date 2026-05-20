import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SistemaPassagemAerea {
    private static final double PRECO_ECONOMICA = 500.00;
    private static final double PRECO_EXECUTIVA = PRECO_ECONOMICA + (PRECO_ECONOMICA * 2.50);
    private static final double PRECO_PRIMEIRA = PRECO_EXECUTIVA + (PRECO_EXECUTIVA * 1.50);

    private final Set<String> assentosOcupados = new HashSet<>();

    public ReservaPassagem reservarPassagens(List<Pessoa> pessoas, List<String> codigosAssentos, ClasseVoo classeEscolhida) {
        if (pessoas == null || pessoas.isEmpty()) {
            throw new IllegalArgumentException("Informe pelo menos uma pessoa para a viagem.");
        }
        if (codigosAssentos == null || codigosAssentos.size() != pessoas.size()) {
            throw new IllegalArgumentException("A quantidade de assentos deve ser igual à quantidade de pessoas.");
        }

        List<Passageiro> passageiros = new ArrayList<>();
        double total = 0;

        for (int i = 0; i < pessoas.size(); i++) {
            Assento assento = criarAssento(codigosAssentos.get(i));

            if (assento.getClasseVoo() != classeEscolhida) {
                throw new IllegalArgumentException(
                        "O assento " + assento.getCodigo() + " pertence à "
                                + assento.getClasseVoo().getDescricao()
                                + ", mas a classe escolhida foi " + classeEscolhida.getDescricao() + "."
                );
            }

            if (assentosOcupados.contains(assento.getCodigo())) {
                throw new IllegalArgumentException("O assento " + assento.getCodigo() + " já está ocupado.");
            }

            assentosOcupados.add(assento.getCodigo());
            passageiros.add(new Passageiro(pessoas.get(i), assento));
            total += assento.getPreco();
        }

        return new ReservaPassagem(classeEscolhida, passageiros, total);
    }

    private Assento criarAssento(String codigoAssento) {
        String codigo = normalizarCodigo(codigoAssento);
        int fileira = Integer.parseInt(codigo.substring(0, codigo.length() - 1));
        char letra = codigo.charAt(codigo.length() - 1);

        validarFileira(fileira);
        validarLetra(letra);

        ClasseVoo classe = identificarClasse(fileira);
        TipoPoltrona tipoPoltrona = identificarTipoPoltrona(letra);
        LadoAeronave lado = identificarLado(letra);
        double preco = calcularPreco(classe);

        return new Assento(fileira, letra, classe, tipoPoltrona, lado, preco);
    }

    private String normalizarCodigo(String codigoAssento) {
        if (codigoAssento == null || codigoAssento.trim().length() < 2) {
            throw new IllegalArgumentException("Código de assento inválido. Exemplo válido: 1A.");
        }

        String codigo = codigoAssento.trim().toUpperCase();
        String numeros = codigo.substring(0, codigo.length() - 1);

        if (!numeros.matches("\\d+")) {
            throw new IllegalArgumentException("A fileira do assento deve ser numérica. Exemplo válido: 12C.");
        }

        return codigo;
    }

    private void validarFileira(int fileira) {
        if (fileira < 1 || fileira > 32) {
            throw new IllegalArgumentException("A fileira deve estar entre 1 e 32.");
        }
    }

    private void validarLetra(char letra) {
        if (letra < 'A' || letra > 'F') {
            throw new IllegalArgumentException("A letra do assento deve estar entre A e F.");
        }
    }

    private ClasseVoo identificarClasse(int fileira) {
        if (fileira >= 1 && fileira <= 3) {
            return ClasseVoo.PRIMEIRA_CLASSE;
        }
        if (fileira >= 4 && fileira <= 8) {
            return ClasseVoo.EXECUTIVA;
        }
        return ClasseVoo.ECONOMICA;
    }

    private TipoPoltrona identificarTipoPoltrona(char letra) {
        if (letra == 'A' || letra == 'F') {
            return TipoPoltrona.JANELA;
        }
        if (letra == 'B' || letra == 'E') {
            return TipoPoltrona.MEIO;
        }
        return TipoPoltrona.CORREDOR;
    }

    private LadoAeronave identificarLado(char letra) {
        if (letra == 'A' || letra == 'B' || letra == 'C') {
            return LadoAeronave.ESQUERDO;
        }
        return LadoAeronave.DIREITO;
    }

    private double calcularPreco(ClasseVoo classe) {
        switch (classe) {
            case PRIMEIRA_CLASSE:
                return PRECO_PRIMEIRA;
            case EXECUTIVA:
                return PRECO_EXECUTIVA;
            case ECONOMICA:
            default:
                return PRECO_ECONOMICA;
        }
    }
}
