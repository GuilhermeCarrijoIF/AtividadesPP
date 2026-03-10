package OCP;
interface Desconto {
    double calcular(double valor);
}

class DescontoVIP implements Desconto {

    public double calcular(double valor) {
        return valor * 0.8;
    }

}

class DescontoNormal implements Desconto {

    public double calcular(double valor) {
        return valor * 0.9;
    }

}