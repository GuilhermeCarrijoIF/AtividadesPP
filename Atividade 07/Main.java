public class Main {

    public static void main(String[] args) {
        Notebook notebook = new Notebook.Builder("Intel Core i7", "16GB DDR5", "512GB SSD")
                .comPlacaDeVideo("NVIDIA RTX 4060")
                .comSistemaOperacional("Windows 11")
                .build();

        System.out.println(notebook);
    }
}