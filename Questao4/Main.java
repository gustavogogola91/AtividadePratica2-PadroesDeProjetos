package Questao4;

public class Main {
    public static void main(String[] args) {
        SistemaValidacaoNFe sistema = new SistemaValidacaoNFe();

        System.out.println("\nTESTE 1: NF-e Valida");
        NFe nfe1 = new NFe(
                "12345",
                "<?xml version=\"1.0\"?><NFe><Numero>12345</Numero></NFe>",
                "CERT-VALID-2025",
                1000.00,
                150.00);
        sistema.validarNFe(nfe1);

        System.out.println("\n\nTESTE 2: Certificado Expirado");
        NFe nfe2 = new NFe(
                "12346",
                "<?xml version=\"1.0\"?><NFe><Numero>12346</Numero></NFe>",
                "CERT-EXPIRED",
                1000.00,
                150.00);
        sistema.validarNFe(nfe2);

        System.out.println("\n\nTESTE 3: Erro no Calculo de Impostos");
        NFe nfe3 = new NFe(
                "12347",
                "<?xml version=\"1.0\"?><NFe><Numero>12347</Numero></NFe>",
                "CERT-VALID-2025",
                1000.00,
                100.00);
        sistema.validarNFe(nfe3);

        System.out.println("\n\nTESTE 4: NF-e Duplicada com Rollback");
        NFe nfe4a = new NFe(
                "12348",
                "<?xml version=\"1.0\"?><NFe><Numero>12348</Numero></NFe>",
                "CERT-VALID-2025",
                1000.00,
                150.00);
        sistema.validarNFe(nfe4a);

        NFe nfe4b = new NFe(
                "12348",
                "<?xml version=\"1.0\"?><NFe><Numero>12348</Numero></NFe>",
                "CERT-VALID-2025",
                1000.00,
                150.00);
        sistema.validarNFe(nfe4b);
    }
}