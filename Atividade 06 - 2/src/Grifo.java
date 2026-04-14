public class Grifo implements Transporte {
    @Override public void mover() { System.out.println("Grifo alça voo rasando as nuvens!"); }
    @Override public void parar() { System.out.println("Grifo pousa majestosamente."); }
    @Override public void exibirInfo() { System.out.println("Transporte: Grifo | Tipo: Criatura Mágica"); }
}
