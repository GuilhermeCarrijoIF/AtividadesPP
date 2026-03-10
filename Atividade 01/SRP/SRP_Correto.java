package SRP;
class CalculadoraSalario {

    public double calcular(double horas, double valorHora) {
        return horas * valorHora;
    }

}

class FuncionarioRepository {

    public void salvar(String nome) {
        System.out.println("Salvando funcionário no banco...");
    }

}