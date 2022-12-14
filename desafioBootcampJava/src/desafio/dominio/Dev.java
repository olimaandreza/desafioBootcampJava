package desafio.dominio;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

public class Dev {
    /* Atributos */
    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();
    private Optional<Conteudo> conteudo;

    
    /* Getters and Setters */
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos = conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }

    
    /* Sobrescrita de hashCode e Equals */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((conteudosConcluidos == null) ? 0 : conteudosConcluidos.hashCode());
        result = prime * result + ((conteudosInscritos == null) ? 0 : conteudosInscritos.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Dev other = (Dev) obj;
        if (conteudosConcluidos == null) {
            if (other.conteudosConcluidos != null)
                return false;
        } else if (!conteudosConcluidos.equals(other.conteudosConcluidos))
            return false;
        if (conteudosInscritos == null) {
            if (other.conteudosInscritos != null)
                return false;
        } else if (!conteudosInscritos.equals(other.conteudosInscritos))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }

    /* M??todo para indicar inscri????o do Dev em Bootcamp */
    public void inscreverBootcamp(Bootcamp bootcamp){
        //Adiciona os conte??dos do Bootcamp na lista de Cursos Inscritos do Dev
        this.conteudosInscritos.addAll(bootcamp.getConteudos()); 

        //Adiciona o nome do Dev na lista de Devs inscritos
        bootcamp.getDevsInscritos().add(this);
    };

    /* M??todo para indicar a conclus??o de um curso */
    public void progredir(){
        //Os cursos do bootcamp devem ser conclu??dos na ordem em que foram inclu??dos
        conteudo = this.conteudosInscritos.stream().findFirst();

        // Adiciona o curso na lista de Conte??dos Conclu??dos e retira da lista de conte??dos Inscritos
        if(conteudo.isPresent()){
            this.conteudosConcluidos.add(conteudo.get());
            this.conteudosInscritos.remove(conteudo.get());
        } else {
            // Se n??o tem nenhum inscrito, erro
            System.err.println("Voc?? n??o est?? matriculado em nenhum conte??do.");
        }
    };

    /* Calcula o total de XP no Bootcamp */
    public double calcularTotalXp(){
        return this.conteudosConcluidos
                .stream()
                .mapToDouble(conteudo -> conteudo.calcularXp())
                .sum();
    };

}
