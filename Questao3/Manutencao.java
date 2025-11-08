package Questao3;

public class Manutencao implements IEstado {

    private Reator reator;

    public Manutencao(Reator reator) {
        this.reator = reator;
        System.out.println("Estado alterado para MANUTENCAO");
    }

    @Override
    public void desligar() {
        this.reator.setEstado(new Desligado(reator));
    }

    @Override
    public void ligar() {
        this.reator.setEstado(new Operacao_Normal(reator));
    }

    @Override
    public void alertaAmarelo() {
        System.out.println("Reator encontra-se em estado MANUTENCAO não é possivel alterar para ALERTA_AMARELO");
    }

    @Override
    public void alertaVermelho() {
        System.out.println("Reator encontra-se em estado MANUTENCAO não é possivel alterar para ALERTA_VERMELHO");
    }

    @Override
    public void emergencia() {
        System.out.println("Reator encontra-se em estado MANUTENCAO não é possivel alterar para EMERGENCIA");
    }

    @Override
    public void manutencao() {
       System.out.println("Reator já se encontra no estado MANUTENCAO não é possivel alterar.");
    }

}
