package Questao4;

import java.util.ArrayList;
import java.util.List;

public class ContextoValidacao {
    private NFe nfe;
    private int falhasConsecutivas = 0;
    private List<ResultadoValidacao> resultados = new ArrayList<>();
    private List<Validador> validadoresComRollback = new ArrayList<>();

    public ContextoValidacao(NFe nfe) {
        this.nfe = nfe;
    }

    public NFe getNfe() {
        return this.nfe;
    }

    public int getFalhasConsecutivas() {
        return this.falhasConsecutivas;
    }

    public void incrementarFalhas() {
        this.falhasConsecutivas++;
    }

    public void resetarFalhas() {
        this.falhasConsecutivas = 0;
    }

    public List<ResultadoValidacao> getResultados() {
        return this.resultados;
    }

    public void adicionarResultado(ResultadoValidacao resultado) {
        this.resultados.add(resultado);
    }

    public void registrarValidadorComRollback(Validador validador) {
        this.validadoresComRollback.add(validador);
    }

    public List<Validador> getValidadoresComRollback() {
        return this.validadoresComRollback;
    }
}
