package LSP;
class Passaro {
    public void voar() {
        System.out.println("O pássaro está voando");
    }
}

class Pinguim extends Passaro {

    public void voar() {
        throw new UnsupportedOperationException("Pinguins não voam");
    }

}