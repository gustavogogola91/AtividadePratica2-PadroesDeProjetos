package Questao4;

public class ValidadorSEFAZ extends Validador {
    public ValidadorSEFAZ() {
        super(true, false);
    }

    @Override
    protected ResultadoValidacao validarInterno(ContextoValidacao contexto) {
        String numero = contexto.getNfe().getNumero();

        if (numero.length() >= 5) {
            return new ResultadoValidacao(true,
                    "NF-e autorizada pela SEFAZ",
                    getNome());
        }
        return new ResultadoValidacao(false,
                "NF-e rejeitada pela SEFAZ",
                getNome());
    }

    @Override
    protected String getNome() {
        return "Validador SEFAZ";
    }
}