package Questao2;

import java.util.HashMap;

public class SistemaBancarioLegado {

    public HashMap<String, Object> processarTransacao(HashMap<String, Object> parametros) {
        System.out.println("Processando transacao no sistema legado");

        if(!parametros.containsKey("ID_AGENCIA")) {
            throw new IllegalArgumentException("Erro: campo obrigatório 'ID_AGENCIA' não foi recebido");
        }

        System.out.println("Realizando transação de R$ " + (int) parametros.get("VALOR_CENTAVOS") / 100 );

        String status = "OK";

        HashMap<String, Object> resposta = new HashMap<>();
        resposta.put("STATUS", status);
        resposta.put("COD_RETORNO", "0");

        return resposta;
    };
}
