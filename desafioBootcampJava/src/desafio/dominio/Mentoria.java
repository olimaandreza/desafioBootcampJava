package desafio.dominio;

import java.time.LocalDate;

public class Mentoria extends Conteudo {
    /* Atributos */
    private LocalDate data;

    /* Construtor */
    public Mentoria() {
    }

    /* Getters and Setters */
    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }

    /* Sobrescrita toString */
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Mentoria{"+
                "titulo='" + getTitulo() + "\'" +
                ", descricao='" + getDescricao() + "\'" +
                ", data=" + data + '}';
    }

    /* Sobrescrita método do Conteúdo */
    @Override
    public double calcularXp() {
        // TODO Auto-generated method stub
        return XP_PADRAO + 20d;
    }
}
