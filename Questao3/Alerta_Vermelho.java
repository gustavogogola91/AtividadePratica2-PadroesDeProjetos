package Questao3;

public class Alerta_Vermelho implements IEstado {

    private Reator reator;

    public Alerta_Vermelho(Reator reator) {
        this.reator = reator;
        System.out.println("Estado alterado para ALERTA_VERMELHO.");
    }

    @Override
    public void desligar() {
        System.out.println("Não é possível alterar de ALERTA_VERMELHO para DESLIGADO.");
    }

    @Override
    public void ligar() {
        System.out.println("Reator já encontra-se ligado.");
    }

    @Override
    public void alertaAmarelo() {
        if (this.reator.temperatura < 400) {
            this.reator.setEstado(new Alerta_Amarelo(reator));
        } else {
            System.out
                    .println("Não é possível alterar para ALERTA_AMARELO pois a temperatura ainda está acima de 400°.");
        }
    }

    @Override
    public void alertaVermelho() {
        System.out.println("Reator já se encontra no estado ALERTA_VERMELHO não é possivel alterar.");
    }

    @Override
    public void emergencia() {
        if(!this.reator.sistemaResfriamentoOk) {
            this.reator.setEstado(new Emergencia(reator));
        } else {
            System.out.println("Não é possível alterar para EMERGENCIA pois o sistema de resfriamento está funcionando normalmente.");
        }
    }

    @Override
    public void manutencao() {
        this.reator.setEstado(new Manutencao(reator));
    }

}
