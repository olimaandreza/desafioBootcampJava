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

    /* Método para indicar inscrição do Dev em Bootcamp */
    public void inscreverBootcamp(Bootcamp bootcamp){
        //Adiciona os conteúdos do Bootcamp na lista de Cursos Inscritos do Dev
        this.conteudosInscritos.addAll(bootcamp.getConteudos()); 

        //Adiciona o nome do Dev na lista de Devs inscritos
        bootcamp.getDevsInscritos().add(this);
    };

    /* Método para indicar a conclusão de um curso */
    public void progredir(){
        //Os cursos do bootcamp devem ser concluídos na ordem em que foram incluídos
        conteudo = this.conteudosInscritos.stream().findFirst();

        // Adiciona o curso na lista de Conteúdos Concluídos e retira da lista de conteúdos Inscritos
        if(conteudo.isPresent()){
            this.conteudosConcluidos.add(conteudo.get());
            this.conteudosInscritos.remove(conteudo.get());
        } else {
            // Se não tem nenhum inscrito, erro
            System.err.println("Você não está matriculado em nenhum conteúdo.");
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
