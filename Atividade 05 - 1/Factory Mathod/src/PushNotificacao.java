public class PushNotificacao implements Notificacao {
    @Override
    public void enviar(String mensagem) {
        System.out.println("🔔 [PUSH NOTIFICATION] Enviando mensagem: " + mensagem);
    }
}
