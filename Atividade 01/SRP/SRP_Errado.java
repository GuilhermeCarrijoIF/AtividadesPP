package SRP;
class FuncionarioService {

    public double calcularSalario(double horas, double valorHora) {
        return horas * valorHora;
    }

    public void salvarFuncionario(String nome) {
        System.out.println("Salvando funcionário no banco...");
    }

}