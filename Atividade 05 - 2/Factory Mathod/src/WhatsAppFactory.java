public class WhatsAppFactory extends NotificacaoFactory {
    @Override
    public Notificacao criarNotificacao() {
        return new WhatsAppNotificacao();
    }
}
