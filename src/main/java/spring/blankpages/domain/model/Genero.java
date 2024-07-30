package spring.blankpages.domain.model;

public enum Genero {
    ACAO("ACAO"),
    MISTERIO("MISTERIO"),
    ROMANCE("ROMANCE"),
    FICCAO("FICCAO");

    private String generoPostman;

    Genero(String genero) {
        this.generoPostman = genero;
    }

    public static Genero fromString(String text) {
        for (Genero genero : Genero.values()) {
            if (genero.generoPostman.equalsIgnoreCase(text)) {
                return genero;
            }
        }
        throw new RuntimeException("Nenhuma categoria encontrada para a string fornecida: " + text);
    }
}
