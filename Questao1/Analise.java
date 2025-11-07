public class Analise {
    private IAlgoritmo algoritmo;
    private Parametros param;

    public Analise(double valor, double tempo, double risco) {
        this.param = new Parametros(valor, tempo, risco);
    }

    public void setAlgoritmo(IAlgoritmo algoritmo) {
        this.algoritmo = algoritmo;
    }

    public void calcular() {
        System.out.println(this.algoritmo.CalcularRisco(param));
    }
}
