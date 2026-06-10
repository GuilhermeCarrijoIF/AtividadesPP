public interface Subject {
    void addObserver(Genero genero, Observer observer);
    void removeObserver(Genero genero, Observer observer);
    void notifyObservers(Filme novoConteudo);
}
