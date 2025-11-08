package Questao4;

public class ValidadorSchemaXML extends Validador {
    public ValidadorSchemaXML() {
        super(false, false);
    }

    @Override
    protected ResultadoValidacao validarInterno(ContextoValidacao contexto) {
        String xml = contexto.getNfe().getXml();

        if (xml != null && xml.startsWith("<?xml") && xml.contains("<NFe>")) {
            return new ResultadoValidacao(true, "Schema XML valido", getNome());
        }
        return new ResultadoValidacao(false, "Schema XML invalido ou malformado", getNome());
    }

    @Override
    protected String getNome() {
        return "Validador de Schema XML";
    }
}