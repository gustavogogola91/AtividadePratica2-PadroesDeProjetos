package Questao3;

public class Emergencia implements IEstado{

    private Reator reator;

    public Emergencia(Reator reator) {
        this.reator = reator;
        System.out.println("Estado alterado para EMERGENCIA");
    }

    @Override
    public void desligar() {
        System.out.println("Não é possível alterar de EMERGENCIA para DESLIGADO.");
    }

    @Override
    public void ligar() {
        System.out.println("Reator já encontra-se ligado.");
    }

    @Override
    public void alertaAmarelo() {
        System.out.println("Não é possível alterar de EMERGENCIA para ALERTA_AMARELO");
    }

    @Override
    public void alertaVermelho() {
        if(this.reator.sistemaResfriamentoOk) {
            this.reator.setEstado(new Alerta_Vermelho(reator));
        }
    }

    @Override
    public void emergencia() {
        System.out.println("Reator já se encontra no estado EMERGENCIA não é possivel alterar.");
    }

    @Override
    public void manutencao() {
        this.reator.setEstado(new Manutencao(reator));
    }
    
}
