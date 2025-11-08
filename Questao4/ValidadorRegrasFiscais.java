package Questao4;

public class ValidadorRegrasFiscais extends Validador {
    public ValidadorRegrasFiscais() {
        super(true, false);
    }

    @Override
    protected ResultadoValidacao validarInterno(ContextoValidacao contexto) {
        NFe nfe = contexto.getNfe();

        double impostoEsperado = nfe.getValorTotal() * 0.15;
        double diferenca = Math.abs(nfe.getValorImpostos() - impostoEsperado);

        if (diferenca < 0.01) {
            return new ResultadoValidacao(true,
                    String.format("Calculo de impostos correto (R$ %.2f)", nfe.getValorImpostos()),
                    getNome());
        }
        return new ResultadoValidacao(false,
                String.format("Erro no calculo de impostos. Esperado: R$ %.2f, Recebido: R$ %.2f",
                        impostoEsperado, nfe.getValorImpostos()),
                getNome());
    }

    @Override
    protected String getNome() {
        return "Validador de Regras Fiscais";
    }
}
