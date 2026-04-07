public abstract class NotificacaoFactory {
    public abstract Notificacao criarNotificacao();
    public void notificar(String mensagem) {
        Notificacao notificacao = criarNotificacao();
        notificacao.enviar(mensagem);
    }
}
