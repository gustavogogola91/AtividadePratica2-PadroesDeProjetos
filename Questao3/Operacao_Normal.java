package Questao3;

public class Operacao_Normal implements IEstado {

    private Reator reator;

    public Operacao_Normal(Reator reator) {
        this.reator = reator;
        System.out.println("Estado alterado para OPERACAO_NORMAL");
    }

    @Override
    public void desligar() {
        reator.setEstado(new Desligado(reator));
    }

    @Override
    public void ligar() {
        System.out
                .println("Reator já se encontra no estado OPERACAO_NORMAL não é possivel alterar.");
    }

    @Override
    public void alertaAmarelo() {
        if (this.reator.temperatura > 300) {
            this.reator.setEstado(new Alerta_Amarelo(reator));
        } else {
            System.out.println("Temperatura não está acima de 300° não é possível alterar para ALERTA_AMARELO.");
        }
    }

    @Override
    public void alertaVermelho() {
        System.out.println("Não é possível alterar de OPERACAO_NORMAL para ALERTA_VERMELHO.");
    }

    @Override
    public void emergencia() {
        System.out.println("Não é possível alterar de OPERACAO_NORMAL para EMERGENCIA.");
    }

    @Override
    public void manutencao() {
        this.reator.setEstado(new Manutencao(reator));
    }

}
