public class Main {
    public static void main(String[] args) {

        System.out.println("=== Sistema de Notificações - Factory Method ===\n");

        // Usando a fábrica de E-mail
        NotificacaoFactory emailFactory = new EmailFactory();
        emailFactory.notificar("teste email!");

        // Usando a fábrica de SMS
        NotificacaoFactory smsFactory = new SmsFactory();
        smsFactory.notificar("teste sms!");

        // Usando a fábrica de Push Notification
        NotificacaoFactory pushFactory = new PushFactory();
        pushFactory.notificar("teste push!");

        System.out.println("\n=== Notificações enviadas com sucesso! ===");
    }
}
