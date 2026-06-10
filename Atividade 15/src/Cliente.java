public class Cliente implements Observer {
    private final String nome;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void inscrever(PlataformaStreaming plataforma, Genero genero) {
        plataforma.addObserver(genero, this);
        System.out.println(nome + " se inscreveu para receber notificações de " + genero.getDescricao() + ".");
    }

    public void cancelarInscricao(PlataformaStreaming plataforma, Genero genero) {
        plataforma.removeObserver(genero, this);
        System.out.println(nome + " cancelou as notificações de " + genero.getDescricao() + ".");
    }

    @Override
    public void update(Filme novoConteudo) {
        System.out.println("Notificação para " + nome + ": novo conteúdo disponível -> " + novoConteudo);
    }
}
