public class EmailNotificacao implements Notificacao {

    @Override
    public void enviar(String mensagem) {
        System.out.println("📧 [E-MAIL] Enviando mensagem: " + mensagem);
    }
}
