public class ValueAtRiskAlgoritmo implements IAlgoritmo {

    @Override
    public String CalcularRisco(Parametros param) {
        return "Realizando cálculos para Value at Risk com parametros: " + param.toString();
    }

}
