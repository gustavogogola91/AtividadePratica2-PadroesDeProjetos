package Questao4;

public class ResultadoValidacao {
    private boolean sucesso;
    private String mensagem;
    private String nomeValidador;

    public ResultadoValidacao(boolean sucesso, String mensagem, String nomeValidador) {
        this.sucesso = sucesso;
        this.mensagem = mensagem;
        this.nomeValidador = nomeValidador;
    }

    public boolean isSucesso() {
        return this.sucesso;
    }

    public String getMensagem() {
        return this.mensagem;
    }

    public String getNomeValidador() {
        return this.nomeValidador;
    }
}