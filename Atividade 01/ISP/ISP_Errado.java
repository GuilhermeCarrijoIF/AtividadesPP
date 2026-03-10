package ISP;
interface Trabalhador {

    void trabalhar();
    void comer();
}

class Robo implements Trabalhador {

    public void trabalhar() {
        System.out.println("Robô trabalhando");
    }

    public void comer() {
        throw new UnsupportedOperationException();
    }

}