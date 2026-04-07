public class Main {
    public static void main(String[] args) {
        System.out.println("=== Sistema de Notificações - Factory Method ===\n");
        NotificacaoFactory emailFactory = new EmailFactory();
        emailFactory.notificar("teste email!");
        NotificacaoFactory smsFactory = new SmsFactory();
        smsFactory.notificar("teste sms!");
        NotificacaoFactory pushFactory = new PushFactory();
        pushFactory.notificar("teste push!");
        System.out.println("\n=== Notificações enviadas com sucesso! ===");
    }
}
