package ISP;
interface Trabalhador {
    void trabalhar();
}

interface SerHumano {
    void comer();
}

class Robo implements Trabalhador {

    public void trabalhar() {
        System.out.println("Robô trabalhando");
    }

}

class Pessoa implements Trabalhador, SerHumano {

    public void trabalhar() {
        System.out.println("Pessoa trabalhando");
    }

    public void comer() {
        System.out.println("Pessoa comendo");
    }

}