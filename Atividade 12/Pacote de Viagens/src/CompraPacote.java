import java.text.NumberFormat;
import java.util.Locale;

public class CompraPacote {
    private final ReservaPassagem reservaPassagem;
    private final ReservaHotel reservaHotel;
    private final ReservaCarro reservaCarro;
    private final ResultadoPagamento resultadoPagamento;

    public CompraPacote(ReservaPassagem reservaPassagem, ReservaHotel reservaHotel,
                        ReservaCarro reservaCarro, ResultadoPagamento resultadoPagamento) {
        this.reservaPassagem = reservaPassagem;
        this.reservaHotel = reservaHotel;
        this.reservaCarro = reservaCarro;
        this.resultadoPagamento = resultadoPagamento;
    }

    public ReservaPassagem getReservaPassagem() {
        return reservaPassagem;
    }

    public ReservaHotel getReservaHotel() {
        return reservaHotel;
    }

    public ReservaCarro getReservaCarro() {
        return reservaCarro;
    }

    public ResultadoPagamento getResultadoPagamento() {
        return resultadoPagamento;
    }

    public String gerarResumo() {
        NumberFormat moeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        StringBuilder sb = new StringBuilder();

        sb.append("\n========== RESUMO DO PACOTE DE VIAGEM ==========\n");
        sb.append("\nDADOS DOS COMPRADORES / PASSAGEIROS:\n");

        int contador = 1;
        for (Passageiro passageiro : reservaPassagem.getPassageiros()) {
            Assento assento = passageiro.getAssento();
            Pessoa pessoa = passageiro.getPessoa();

            sb.append(contador++).append(") ")
                    .append("Nome: ").append(pessoa.getNome()).append(" | ")
                    .append("CPF: ").append(pessoa.getCpf()).append(" | ")
                    .append("Poltrona: ").append(assento.getCodigo()).append(" | ")
                    .append(assento.getClasseVoo().getDescricao()).append(" | ")
                    .append(assento.getTipoPoltrona().getDescricao()).append(" | Lado ")
                    .append(assento.getLadoAeronave().getDescricao()).append(" | ")
                    .append(moeda.format(assento.getPreco()))
                    .append("\n");
        }

        sb.append("\nDADOS DA COMPRA:\n");
        sb.append("Passagem aérea: ").append(reservaPassagem.getClasseEscolhida().getDescricao())
                .append(" - Total: ").append(moeda.format(reservaPassagem.getValorTotal())).append("\n");

        sb.append("Hotel: ").append(reservaHotel.getTipoQuarto().getDescricao())
                .append(" | Pessoas: ").append(reservaHotel.getQuantidadePessoas())
                .append(" | Diárias: ").append(reservaHotel.getQuantidadeDiarias())
                .append(" | Total: ").append(moeda.format(reservaHotel.getValorTotal())).append("\n");

        sb.append("Carro: ").append(reservaCarro.getTipoCarro().getDescricao())
                .append(" | Diárias: ").append(reservaCarro.getQuantidadeDiarias())
                .append(" | Total: ").append(moeda.format(reservaCarro.getValorTotal())).append("\n");

        sb.append("\nPAGAMENTO:\n");
        sb.append("Subtotal do pacote: ").append(moeda.format(resultadoPagamento.getSubtotal())).append("\n");
        sb.append("Forma de pagamento: ").append(resultadoPagamento.getFormaPagamento().getDescricao()).append("\n");

        if (resultadoPagamento.getDesconto() > 0) {
            sb.append("Desconto: ").append(moeda.format(resultadoPagamento.getDesconto())).append("\n");
        } else if (resultadoPagamento.getAcrescimo() > 0) {
            sb.append("Acréscimo/Juros: ").append(moeda.format(resultadoPagamento.getAcrescimo())).append("\n");
        } else {
            sb.append("Desconto/Acréscimo: ").append(moeda.format(0)).append("\n");
        }

        sb.append("Valor final do pacote: ").append(moeda.format(resultadoPagamento.getValorFinal())).append("\n");

        if (resultadoPagamento.getFormaPagamento() == FormaPagamento.CREDITO) {
            sb.append("Parcelamento: ").append(resultadoPagamento.getParcelas())
                    .append("x de ").append(moeda.format(resultadoPagamento.getValorParcela())).append("\n");
        }

        sb.append("================================================\n");
        return sb.toString();
    }
}
