import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class PlataformaStreaming implements Subject {
    private final Map<Genero, List<Observer>> observadoresPorGenero;
    private final List<Filme> catalogo;

    public PlataformaStreaming() {
        observadoresPorGenero = new EnumMap<>(Genero.class);
        catalogo = new ArrayList<>();

        for (Genero genero : Genero.values()) {
            observadoresPorGenero.put(genero, new ArrayList<>());
        }
    }

    @Override
    public void addObserver(Genero genero, Observer observer) {
        List<Observer> observadores = observadoresPorGenero.get(genero);

        if (!observadores.contains(observer)) {
            observadores.add(observer);
        }
    }

    @Override
    public void removeObserver(Genero genero, Observer observer) {
        observadoresPorGenero.get(genero).remove(observer);
    }

    public void adicionarConteudo(Filme novoConteudo) {
        catalogo.add(novoConteudo);
        System.out.println("\nNovo conteúdo adicionado na plataforma: " + novoConteudo);
        notifyObservers(novoConteudo);
    }

    @Override
    public void notifyObservers(Filme novoConteudo) {
        List<Observer> observadores = observadoresPorGenero.get(novoConteudo.getGenero());

        if (observadores.isEmpty()) {
            System.out.println("Nenhum cliente inscrito no gênero " + novoConteudo.getGenero().getDescricao() + ".");
            return;
        }

        for (Observer observer : observadores) {
            observer.update(novoConteudo);
        }
    }
}
