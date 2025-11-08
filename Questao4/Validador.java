package Questao4;

import java.util.List;

public abstract class Validador {
    protected Validador proximo;
    protected boolean executarApenasSeAnterioresPassarem;
    protected boolean suportaRollback;

    public Validador(boolean executarApenasSeAnterioresPassarem, boolean suportaRollback) {
        this.executarApenasSeAnterioresPassarem = executarApenasSeAnterioresPassarem;
        this.suportaRollback = suportaRollback;
    }

    public void setProximo(Validador proximo) {
        this.proximo = proximo;
    }

    public final void validar(ContextoValidacao contexto) {
        if (contexto.getFalhasConsecutivas() >= 3) {
            System.out.println("CIRCUIT BREAKER ATIVADO - Interrompendo cadeia");
            return;
        }

        if (executarApenasSeAnterioresPassarem && contexto.getFalhasConsecutivas() > 0) {
            System.out.println("Pulando " + getNome() + " (validacao anterior falhou)");
            if (proximo != null) {
                proximo.validar(contexto);
            }
            return;
        }

        System.out.println("\nExecutando: " + getNome());

        ResultadoValidacao resultado = validarInterno(contexto);
        contexto.adicionarResultado(resultado);

        if (resultado.isSucesso()) {
            System.out.println("OK - " + resultado.getMensagem());
            contexto.resetarFalhas();

            if (suportaRollback) {
                contexto.registrarValidadorComRollback(this);
            }
        } else {
            System.out.println("FALHA - " + resultado.getMensagem());
            contexto.incrementarFalhas();
            executarRollback(contexto);
            return;
        }

        if (proximo != null) {
            proximo.validar(contexto);
        }
    }

    private void executarRollback(ContextoValidacao contexto) {
        List<Validador> validadores = contexto.getValidadoresComRollback();
        if (!validadores.isEmpty()) {
            System.out.println("\nExecutando Rollback de " + validadores.size() + " validador(es)...");
            for (int i = validadores.size() - 1; i >= 0; i--) {
                validadores.get(i).rollback(contexto);
            }
        }
    }

    protected abstract ResultadoValidacao validarInterno(ContextoValidacao contexto);

    protected abstract String getNome();

    protected void rollback(ContextoValidacao contexto) {
    }
}