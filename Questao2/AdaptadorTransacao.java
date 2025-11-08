package Questao2;

import java.util.HashMap;
import java.util.Map;

public class AdaptadorTransacao implements ProcessadorTransacoes {

    private SistemaBancarioLegado legado;

    private static final Map<String, Integer> MOEDA = Map.of(
            "USD", 1,
            "EUR", 2,
            "BRL", 3);

    private static final String CAMPO_OBRIGATORIO_LEGADO = "1234";

    public AdaptadorTransacao(SistemaBancarioLegado legado) {
        this.legado = legado;
    }

    @Override
    public boolean autorizar(String cartao, double valor, String moeda) {
        
        HashMap<String, Object> parametrosLegado = new HashMap<>();

        parametrosLegado.put("VALOR_CENTAVOS", (int) (valor * 100));

        parametrosLegado.put("NUMERO_CARTAO", cartao);
        
        Integer codMoeda = MOEDA.getOrDefault(moeda.toUpperCase(), 0);
        if (codMoeda == 0) {
            throw new IllegalArgumentException("Erro, moeda n'ao suportada pelo sistema legado");
        }
        parametrosLegado.put("cod_moeda", codMoeda);

        parametrosLegado.put("ID_AGENCIA", CAMPO_OBRIGATORIO_LEGADO);

        HashMap<String, Object> respostaLegado = legado.processarTransacao(parametrosLegado);

        String statusLegado = (String) respostaLegado.get("status_legado");
        String codigoRetorno = (String) respostaLegado.get("cod_retorno");

        if ("00".equals(codigoRetorno) && "OK".equals(statusLegado)) {
            System.out.println("Transação autorizada");
            return true;
        } else {
            System.out.println("Transação recusada");
            return false;
        }
    }
}
