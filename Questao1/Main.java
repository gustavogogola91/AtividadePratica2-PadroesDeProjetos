public class Main {
    public static void main(String[] args) {
        Analise a1 = new Analise(24, 25, 12);

        a1.setAlgoritmo(new ExpectedShortfall());

        a1.calcular();
        
        a1.setAlgoritmo(new StressTesting());

        a1.calcular();

        a1.setAlgoritmo(new ValueAtRiskAlgoritmo());

        a1.calcular();
    }
}
