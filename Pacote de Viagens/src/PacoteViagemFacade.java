import java.util.List;

public class PacoteViagemFacade {
    private final SistemaPassagemAerea sistemaPassagemAerea;
    private final SistemaReservaHotel sistemaReservaHotel;
    private final SistemaAluguelCarro sistemaAluguelCarro;
    private final SistemaPagamento sistemaPagamento;

    public PacoteViagemFacade() {
        this.sistemaPassagemAerea = new SistemaPassagemAerea();
        this.sistemaReservaHotel = new SistemaReservaHotel();
        this.sistemaAluguelCarro = new SistemaAluguelCarro();
        this.sistemaPagamento = new SistemaPagamento();
    }

    public CompraPacote venderPacoteViagem(
            List<Pessoa> compradores,
            ClasseVoo classeVoo,
            List<String> codigosAssentos,
            TipoQuarto tipoQuarto,
            int diariasHotel,
            TipoCarro tipoCarro,
            int diariasCarro,
            FormaPagamento formaPagamento,
            int parcelas
    ) {
        ReservaPassagem reservaPassagem = sistemaPassagemAerea.reservarPassagens(
                compradores,
                codigosAssentos,
                classeVoo
        );

        ReservaHotel reservaHotel = sistemaReservaHotel.reservarHotel(
                tipoQuarto,
                compradores.size(),
                diariasHotel
        );

        ReservaCarro reservaCarro = sistemaAluguelCarro.reservarCarro(
                tipoCarro,
                diariasCarro
        );

        double subtotal = reservaPassagem.getValorTotal()
                + reservaHotel.getValorTotal()
                + reservaCarro.getValorTotal();

        ResultadoPagamento resultadoPagamento = sistemaPagamento.processarPagamento(
                subtotal,
                formaPagamento,
                parcelas
        );

        return new CompraPacote(reservaPassagem, reservaHotel, reservaCarro, resultadoPagamento);
    }
}
