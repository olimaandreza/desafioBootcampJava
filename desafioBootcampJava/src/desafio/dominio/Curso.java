package desafio.dominio;

public class Curso extends Conteudo {
    /* Atributos */ 
    private int cargaHoraria;
    
    /* Construtor */
    public Curso() {
    }

    /* Getters and Setters */
    public int getCargaHoraria() {
        return cargaHoraria;
    }
    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    /* Sobrescrita toString */
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Curso{"+
                "titulo='" + getTitulo() + "\'" +
                ", descricao='" + getDescricao() + "\'" +
                ", cargaHoraria=" + cargaHoraria + '}';

    }

    /* Sobrescrita do método do Conteúdo */
    @Override
    public double calcularXp() {
        // TODO Auto-generated method stub
        return XP_PADRAO *cargaHoraria;
    }
    

    
    
}
