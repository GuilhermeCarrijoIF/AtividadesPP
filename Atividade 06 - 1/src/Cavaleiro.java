public class Cavaleiro implements Personagem {
    @Override
    public void atacar() {
        System.out.println("Cavaleiro ataca brandindo sua Espada!");
    }

    @Override
    public void defender() {
        System.out.println("Cavaleiro defende com seu escudo!");
    }

    @Override
    public void exibirInfo() {
        System.out.println("Personagem: Cavaleiro | Tema: Medieval");
    }
}
