package Questao4;

public class NFe {
    private String numero;
    private String xml;
    private String certificado;
    private double valorTotal;
    private double valorImpostos;
    private boolean inseridoNoBanco = false;

    public NFe(String numero, String xml, String certificado, double valorTotal, double valorImpostos) {
        this.numero = numero;
        this.xml = xml;
        this.certificado = certificado;
        this.valorTotal = valorTotal;
        this.valorImpostos = valorImpostos;
    }

    public String getNumero() {
        return this.numero;
    }

    public String getXml() {
        return this.xml;
    }

    public String getCertificado() {
        return this.certificado;
    }

    public double getValorTotal() {
        return this.valorTotal;
    }

    public double getValorImpostos() {
        return this.valorImpostos;
    }

    public boolean isInseridoNoBanco() {
        return this.inseridoNoBanco;
    }

    public void setInseridoNoBanco(boolean inserido) {
        this.inseridoNoBanco = inserido;
    }
}
