import java.util.HashMap;
import java.util.Map;

public class RegistroFabricas {
    private static final Map<String, FabricaTema> fabricas = new HashMap<>();

    static {
        fabricas.put("medieval", new FabricaMedieval());
        fabricas.put("futurista", new FabricaFuturista());
        fabricas.put("fantasia", new FabricaFantasia());
    }

    public static FabricaTema obterFabrica(String tema) {
        FabricaTema fabrica = fabricas.get(tema.toLowerCase());
        if (fabrica == null) {
            throw new IllegalArgumentException("Tema desconhecido: " + tema +
                ". Temas disponíveis: " + fabricas.keySet());
        }
        return fabrica;
    }

    public static void listarTemas() {
        System.out.println("Temas disponíveis: " + fabricas.keySet());
    }
}
