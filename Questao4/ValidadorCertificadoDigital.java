package Questao4;

public class ValidadorCertificadoDigital extends Validador {
    public ValidadorCertificadoDigital() {
        super(false, false);
    }

    @Override
    protected ResultadoValidacao validarInterno(ContextoValidacao contexto) {
        String certificado = contexto.getNfe().getCertificado();

        if (certificado != null && certificado.startsWith("CERT-") && !certificado.contains("EXPIRED")) {
            return new ResultadoValidacao(true, "Certificado digital valido e nao expirado", getNome());
        }
        return new ResultadoValidacao(false, "Certificado digital invalido ou expirado", getNome());
    }

    @Override
    protected String getNome() {
        return "Validador de Certificado Digital";
    }
}
