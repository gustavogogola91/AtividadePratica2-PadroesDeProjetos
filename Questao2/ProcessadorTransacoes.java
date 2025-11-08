package Questao2;

public interface ProcessadorTransacoes {
    public boolean autorizar(String cartao, double valor, String moeda);
}
