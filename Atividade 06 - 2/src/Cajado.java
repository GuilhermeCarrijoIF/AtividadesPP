public class Cajado implements Arma {
    @Override public void usar() { System.out.println("Cajado lança feitiços devastadores no inimigo!"); }
    @Override public void guardar() { System.out.println("Mago guarda Cajado nas costas."); }
    @Override public void exibirInfo() { System.out.println("Arma: Cajado | Tipo: Magia Arcana"); }
}
