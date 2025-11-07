public class Parametros {
    public double valor;
    public double tempo;
    public double risco;
    
    public Parametros(double valor, double tempo, double risco) {
        this.valor = valor;
        this.tempo = tempo;
        this.risco = risco;
    }

    @Override
    public String toString() {
        return "Valor: R$ " + valor + " - Tempo: " + tempo + " - Risco: " + risco;
    }
}
