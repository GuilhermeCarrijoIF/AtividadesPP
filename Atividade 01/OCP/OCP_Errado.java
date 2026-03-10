package OCP;
class Desconto {

    public double calcular(String tipoCliente, double valor) {

        if(tipoCliente.equals("VIP")) {
            return valor * 0.8;
        }

        if(tipoCliente.equals("NORMAL")) {
            return valor * 0.9;
        }

        return valor;
    }
}