public class NaveEspacial implements Transporte {
    @Override public void mover() { System.out.println("Nave Espacial acelera em velocidade hiperespacial!"); }
    @Override public void parar() { System.out.println("Nave Espacial desacelera e pousa."); }
    @Override public void exibirInfo() { System.out.println("Transporte: Nave Espacial | Tipo: Veículo Espacial"); }
}
