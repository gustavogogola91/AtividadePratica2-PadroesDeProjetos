package Questao3;

public class Alerta_Amarelo implements IEstado {

    private Reator reator;

    public Alerta_Amarelo(Reator reator) {
        this.reator = reator;
        System.out.println("Estado alterado para ALERTA_AMARElO");
}


    @Override
    public void desligar() {
        System.out.println("Não é possível alterar de ALERTA_AMARELO para DESLIGADO.");
    }

    @Override
    public void ligar() {
        System.out.println("Reator já encontra-se ligado.");
    }

    @Override
    public void alertaAmarelo() {
        System.out.println("Reator já se encontra no estado ALERTA_AMARELO não é possivel alterar.");
    }

    @Override
    public void alertaVermelho() {
        if(this.reator.temperatura > 400 && this.reator.tempoTemperatura >= 30) {
            this.reator.setEstado(new Alerta_Vermelho(reator));
        } else {
            System.out.println("Não é possível alterar para ALERTA_VERMELHO pois a temperatura não está acima de 400° por mais de 30 segundos");
        }
    }

    @Override
    public void emergencia() {
        System.out.println("Não é possível alterar de ALERTA_AMARELO para EMERGENCIA.");
    }

    @Override
    public void manutencao() {
        this.reator.setEstado(new Manutencao(reator));
    }
    
}
