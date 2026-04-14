public class Mago implements Personagem {
    @Override public void atacar() { System.out.println("Mago ataca conjurando magias com seu Cajado!"); }
    @Override public void defender() { System.out.println("Mago defende com uma barreira mágica!"); }
    @Override public void exibirInfo() { System.out.println("Personagem: Mago | Tema: Fantasia"); }
}
