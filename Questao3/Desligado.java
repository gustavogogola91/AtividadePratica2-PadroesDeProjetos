package Questao3;

public class Desligado implements IEstado {

    private Reator reator;

    public Desligado(Reator reator) {
        this.reator = reator;
        System.out.println("Estado alterado para DESLIGADO");
    }

    @Override
    public void desligar() {
        System.out.println("Reator já se encontra no estado DESLIGADO não é possivel alterar.");
    }

    @Override
    public void ligar() {
        this.reator.setEstado(new Operacao_Normal(reator));
    }

    @Override
    public void alertaAmarelo() {
        System.out.println("Reator encontra-se em estado DESLIGADO não é possivel alterar para ALERTA_AMARELO");
    }

    @Override
    public void alertaVermelho() {
        System.out.println("Reator encontra-se em estado DESLIGADO não é possivel alterar para ALERTA_VERMELHO");
    }

    @Override
    public void emergencia() {
        System.out.println("Reator encontra-se em estado DESLIGADO não é possivel alterar para EMERGENCIA");
    }

    @Override
    public void manutencao() {
        this.reator.setEstado(new Manutencao(reator));
    }

}
