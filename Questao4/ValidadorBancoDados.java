package Questao4;

import java.util.HashSet;
import java.util.Set;

public class ValidadorBancoDados extends Validador {
    private Set<String> numerosNFe = new HashSet<>();

    public ValidadorBancoDados() {
        super(false, true);
    }

    @Override
    protected ResultadoValidacao validarInterno(ContextoValidacao contexto) {
        String numero = contexto.getNfe().getNumero();

        if (numerosNFe.contains(numero)) {
            return new ResultadoValidacao(false,
                    "NF-e com numero " + numero + " ja existe no banco de dados",
                    getNome());
        }

        numerosNFe.add(numero);
        contexto.getNfe().setInseridoNoBanco(true);

        return new ResultadoValidacao(true,
                "NF-e inserida no banco de dados com sucesso",
                getNome());
    }

    @Override
    protected void rollback(ContextoValidacao contexto) {
        String numero = contexto.getNfe().getNumero();
        if (contexto.getNfe().isInseridoNoBanco()) {
            numerosNFe.remove(numero);
            contexto.getNfe().setInseridoNoBanco(false);
            System.out.println("Rollback: NF-e " + numero + " removida do banco de dados");
        }
    }

    @Override
    protected String getNome() {
        return "Validador de Banco de Dados";
    }
}
