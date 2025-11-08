package Questao3;

public class Main {
    public static void main(String[] args) {
        Reator r1 = new Reator(100, 0);

        System.out.println("Ligando reator");
        r1.ligar();

        r1.alertaAmarelo();

        r1.setTemperatura(301);

        r1.alertaAmarelo();

        r1.desligar();

        r1.emergencia();

        r1.alertaVermelho();

        r1.setTemperatura(450);
        r1.setTempoTemperatura(40);

        r1.alertaVermelho();

        r1.emergencia();

        r1.setSistemaResfriamentoOk(false);

        r1.emergencia();

        r1.manutencao();
    }
}
