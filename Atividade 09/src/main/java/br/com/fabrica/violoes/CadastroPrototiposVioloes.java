package br.com.fabrica.violoes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CadastroPrototiposVioloes {
    private final Map<TipoViolao, Violao> prototipos = new HashMap<>();

    public CadastroPrototiposVioloes() {
        carregarPrototipos();
    }

    public Violao criarViolaoComCloneSuperficial(TipoViolao tipo) {
        Violao prototipo = buscarPrototipo(tipo);
        return prototipo.cloneSuperficial();
    }

    public Violao criarViolaoComCloneProfundo(TipoViolao tipo) {
        Violao prototipo = buscarPrototipo(tipo);
        return prototipo.cloneProfundo();
    }

    private Violao buscarPrototipo(TipoViolao tipo) {
        Violao prototipo = prototipos.get(tipo);

        if (prototipo == null) {
            throw new IllegalArgumentException("Tipo de violão não cadastrado: " + tipo);
        }

        return prototipo;
    }

    private void carregarPrototipos() {
        prototipos.put(TipoViolao.CLASSICO, new Violao(
                TipoViolao.CLASSICO,
                "Violão Clássico",
                650.00,
                new Especificacao(
                        "Acústico tradicional",
                        "6 cordas de nylon",
                        "Iniciantes",
                        List.of("leve", "macio", "baixo custo", "fácil de encontrar")
                )
        ));

        prototipos.put(TipoViolao.FOLK, new Violao(
                TipoViolao.FOLK,
                "Violão Folk",
                1200.00,
                new Especificacao(
                        "Corpo maior e acinturado",
                        "Geralmente 6 cordas de aço",
                        "Pop e rock",
                        List.of("som encorpado", "timbre diferenciado", "pode ser elétrico ou eletroacústico")
                )
        ));

        prototipos.put(TipoViolao.FLET, new Violao(
                TipoViolao.FLET,
                "Violão Flet",
                1500.00,
                new Especificacao(
                        "Caixa acústica fina",
                        "Geralmente cordas de nylon",
                        "Músicos profissionais",
                        List.of("timbre suave", "modelo geralmente elétrico", "precisa de amplificação")
                )
        ));

        prototipos.put(TipoViolao.JUMBO, new Violao(
                TipoViolao.JUMBO,
                "Violão Jumbo",
                1800.00,
                new Especificacao(
                        "Corpo largo com base arredondada",
                        "Geralmente cordas de aço",
                        "Sons graves e encorpados",
                        List.of("popularizado por Elvis Presley", "modelo comum em versão eletroacústica")
                )
        ));

        prototipos.put(TipoViolao.SETE_CORDAS, new Violao(
                TipoViolao.SETE_CORDAS,
                "Violão 7 Cordas",
                2200.00,
                new Especificacao(
                        "Estrutura semelhante ao clássico",
                        "7 cordas, com a sétima mais grave",
                        "Choro e samba",
                        List.of("conhecido como violão brasileiro", "exige mais conhecimento técnico")
                )
        ));

        prototipos.put(TipoViolao.DOZE_CORDAS, new Violao(
                TipoViolao.DOZE_CORDAS,
                "Violão 12 Cordas",
                2500.00,
                new Especificacao(
                        "Estrutura semelhante ao clássico",
                        "12 cordas agrupadas em duplas",
                        "Ressonância plena",
                        List.of("metade das cordas afinadas uma oitava acima", "exige técnica e prática")
                )
        ));

        prototipos.put(TipoViolao.ZERO, new Violao(
                TipoViolao.ZERO,
                "Violão Zero",
                900.00,
                new Especificacao(
                        "Parlor pequeno",
                        "6 cordas",
                        "Uso casual",
                        List.of("menor entre os modelos zero", "confortável para tocar por bastante tempo")
                )
        ));

        prototipos.put(TipoViolao.DUPLO_ZERO, new Violao(
                TipoViolao.DUPLO_ZERO,
                "Violão Duplo Zero",
                1100.00,
                new Especificacao(
                        "Parlor um pouco maior que o zero",
                        "6 cordas",
                        "Fingerstyle",
                        List.of("boa sonoridade", "estrutura compacta")
                )
        ));

        prototipos.put(TipoViolao.TRIPLO_ZERO, new Violao(
                TipoViolao.TRIPLO_ZERO,
                "Violão Triplo Zero",
                1300.00,
                new Especificacao(
                        "Parlor de tamanho intermediário",
                        "6 cordas",
                        "Uso casual e timbre peculiar",
                        List.of("timbre mais peculiar", "maior que zero e duplo zero")
                )
        ));
    }
}
