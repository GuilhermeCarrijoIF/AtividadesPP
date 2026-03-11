public class Logger {

    private static Logger instance;
    private String logFile;

    private Logger() {
        this.logFile = "app.log";
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String mensagem) {
        System.out.println("Log: " + mensagem);
    }
}