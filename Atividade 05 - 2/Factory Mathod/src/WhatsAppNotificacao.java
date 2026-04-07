public class WhatsAppNotificacao implements Notificacao {
    @Override 
    public void enviar(String mensagem) {
        System.out.println("💬 [WHATSAPP] Enviando mensagem: "+ mensagem);
    }
}