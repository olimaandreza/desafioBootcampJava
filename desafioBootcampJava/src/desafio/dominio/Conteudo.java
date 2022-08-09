package desafio.dominio;

public abstract class Conteudo {
    /* Atributos */
    protected static final double XP_PADRAO = 10d;
    private String titulo;
    private String descricao;

    /* Getters and Setters */
    
    public String getTitulo() {
        return titulo;
    }


    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public String getDescricao() {
        return descricao;
    }


    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /* Estabelece método */
    public abstract double calcularXp();
}
