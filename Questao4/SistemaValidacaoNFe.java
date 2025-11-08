package Questao4;

public class SistemaValidacaoNFe {
    private Validador primeiroValidador;

    public SistemaValidacaoNFe() {
        construirCadeia();
    }

    private void construirCadeia() {
        ValidadorSchemaXML v1 = new ValidadorSchemaXML();
        ValidadorCertificadoDigital v2 = new ValidadorCertificadoDigital();
        ValidadorRegrasFiscais v3 = new ValidadorRegrasFiscais();
        ValidadorBancoDados v4 = new ValidadorBancoDados();
        ValidadorSEFAZ v5 = new ValidadorSEFAZ();

        v1.setProximo(v2);
        v2.setProximo(v3);
        v3.setProximo(v4);
        v4.setProximo(v5);

        primeiroValidador = v1;
    }

    public boolean validarNFe(NFe nfe) {
        System.out.println("==========================================");
        System.out.println("Iniciando validacao da NF-e: " + nfe.getNumero());
        System.out.println("==========================================");

        ContextoValidacao contexto = new ContextoValidacao(nfe);
        primeiroValidador.validar(contexto);

        System.out.println("\n==========================================");
        System.out.println("RESULTADO FINAL");
        System.out.println("==========================================");

        boolean todasPassaram = true;
        int falhas = 0;

        for (ResultadoValidacao r : contexto.getResultados()) {
            if (!r.isSucesso()) {
                todasPassaram = false;
                falhas++;
            }
        }

        if (todasPassaram) {
            System.out.println("NF-e validada com sucesso!");
        } else {
            System.out.println("NF-e rejeitada!");
            System.out.println("Falhas: " + falhas + " validacao(oes)");
        }

        return todasPassaram;
    }
}
