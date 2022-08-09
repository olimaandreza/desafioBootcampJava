import java.time.LocalDate;

import desafio.dominio.Bootcamp;
import desafio.dominio.Curso;
import desafio.dominio.Dev;
import desafio.dominio.Mentoria;

public class App {
    public static void main(String[] args) throws Exception {

        /* Cria objetos da classe Curso */
        Curso curso1 = new Curso();
        curso1.setTitulo("Curso java");
        curso1.setDescricao("Curso para iniciantes");
        curso1.setCargaHoraria(62);

        Curso curso2 = new Curso();
        curso2.setTitulo("Curso java 2");
        curso2.setDescricao("Curso intermediário");
        curso2.setCargaHoraria(42);

        /* Cria objeto da classe Mentoria */
        Mentoria mentoria1 = new Mentoria();
        mentoria1.setTitulo("Mentoria java");
        mentoria1.setDescricao("mentoria java");
        mentoria1.setData(LocalDate.now());

        /* Verifica os objetos criados */
        // System.out.println(curso1);
        // System.out.println(curso2);
        // System.out.println(mentoria1);

        /* Cria objeto da classe Bootcamp */
        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java");
        bootcamp.setDescricao("aprenda Java");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria1);

        /* Cria objetos da classe Dev */
        Dev dev1 = new Dev();
        dev1.setNome("João");
        
        Dev dev2 = new Dev();
        dev2.setNome("Maria");
        
        /* Ninguém se inscreveu */
        System.out.println("Antes da inscrição.");
        System.out.println("Conteudos inscritos " + dev1.getNome() + ": " + dev1.getConteudosInscritos());
        System.out.println("Conteudos inscritos " + dev2.getNome() + ": " + dev2.getConteudosInscritos());

        /* Dev2 se inscreve no Bootcamp */
        dev2.inscreverBootcamp(bootcamp);

        System.out.println("Depois da inscrição.");
        System.out.println("Conteudos inscritos " + dev1.getNome() + ": " + dev1.getConteudosInscritos());
        System.out.println("Conteudos inscritos " + dev2.getNome() + ": " + dev2.getConteudosInscritos());

        /* Dev2 não concluiu o Bootcamp */
        System.out.println("Antes da conclusão");
        System.out.println("Conteudos concluídos " + dev1.getNome() + ": " + dev1.getConteudosConcluidos());
        System.out.println("Conteudos concluídos " + dev2.getNome() + ": " + dev2.getConteudosConcluidos());

        /* Devs tentam progredir */
        dev2.progredir();
        dev1.progredir();

        System.out.println("Depois da progressão");
        System.out.println("Conteudos concluídos " + dev1.getNome() + ": " + dev1.getConteudosConcluidos());
        System.out.println("Conteudos concluídos " + dev2.getNome() + ": " + dev2.getConteudosConcluidos());
        System.out.println("XP: " + dev2.getNome() + ": "  + dev2.calcularTotalXp());
        System.out.println("Conteudos inscritos " + dev2.getNome() + ": " + dev2.getConteudosInscritos());
    }
}
