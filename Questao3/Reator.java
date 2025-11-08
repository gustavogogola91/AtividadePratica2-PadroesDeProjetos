package Questao3;

public class Reator {

    private IEstado estado;

    public float temperatura;
    public int tempoTemperatura;
    public boolean sistemaResfriamentoOk = true;

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }

    public void setTempoTemperatura(int tempoTemperatura) {
        this.tempoTemperatura = tempoTemperatura;
    }

    public void setSistemaResfriamentoOk(boolean sistemaResfriamentoOk) {
        this.sistemaResfriamentoOk = sistemaResfriamentoOk;
    }

    public Reator(float temperatura, int tempoTemperatura) {
        this.estado = new Desligado(this);
        this.temperatura = temperatura;
        this.tempoTemperatura = tempoTemperatura;
    }

    public void setEstado(IEstado estado) {
        this.estado = estado;
    }

    public void desligar() {
        this.estado.desligar();
    }

    public void ligar() {
        this.estado.ligar();
    }

    public void alertaAmarelo() {
        this.estado.alertaAmarelo();
    }

    public void alertaVermelho() {
        this.estado.alertaVermelho();
    }

    public void emergencia() {
        this.estado.emergencia();
    }

    public void manutencao() {
        this.estado.manutencao();
    }

}
