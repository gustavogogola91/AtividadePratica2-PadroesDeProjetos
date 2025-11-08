package Questao2;

public class Main {
    public static void main(String[] args) {
        SistemaBancarioLegado sistemaLegado = new SistemaBancarioLegado();

        ProcessadorTransacoes processador = new AdaptadorTransacao(sistemaLegado);

        System.out.println("--- Transação 1 ---");
        boolean resultado1 = processador.autorizar("1234-5678", 45.99, "BRL");
        System.out.println("Resultado: " + resultado1);

        System.out.println("\n--- Transação 2 ---");
        boolean resultado2 = processador.autorizar("9876-5432", 5001.00, "USD");
        System.out.println("Resultado: " + resultado2);
    }
}
