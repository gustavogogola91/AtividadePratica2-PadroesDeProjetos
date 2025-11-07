public class StressTesting  implements IAlgoritmo{

    @Override
    public String CalcularRisco(Parametros param) {
        return "Realizando cálculos para Stress Testing com parametros: " + param.toString();
    }
    
}
