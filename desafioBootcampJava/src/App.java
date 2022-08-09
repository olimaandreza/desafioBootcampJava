import java.time.LocalDate;

import desafio.dominio.Bootcamp;
import desafio.dominio.Curso;
import desafio.dominio.Dev;
import desafio.dominio.Mentoria;

public class App {
    public static void main(String[] args) throws Exception {
        Curso curso1 = new Curso();
        curso1.setTitulo("Curso java");
        curso1.setDescricao("Curso para iniciantes");
        curso1.setCargaHoraria(62);

        Curso curso2 = new Curso();
        curso2.setTitulo("Curso java 2");
        curso2.setDescricao("Curso intermediário");
        curso2.setCargaHoraria(42);

        Mentoria mentoria1 = new Mentoria();
        mentoria1.setTitulo("Mentoria java");
        mentoria1.setDescricao("mentoria java");
        mentoria1.setData(LocalDate.now());

        // System.out.println(curso1);
        // System.out.println(curso2);
        // System.out.println(mentoria1);

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java");
        bootcamp.setDescricao("aprenda Java");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria1);

        Dev dev1 = new Dev();
        dev1.setNome("João");
        
        Dev dev2 = new Dev();
        dev2.setNome("Maria");
        
        System.out.println("Antes da inscrição.");
        System.out.println("Conteudos inscritos " + dev1.getNome() + ": " + dev1.getConteudosInscritos());
        System.out.println("Conteudos inscritos " + dev2.getNome() + ": " + dev2.getConteudosInscritos());

        dev2.inscreverBootcamp(bootcamp);

        System.out.println("Depois da inscrição.");
        System.out.println("Conteudos inscritos " + dev1.getNome() + ": " + dev1.getConteudosInscritos());
        System.out.println("Conteudos inscritos " + dev2.getNome() + ": " + dev2.getConteudosInscritos());

        System.out.println("Antes da conclusão");
        System.out.println("Conteudos concluídos " + dev1.getNome() + ": " + dev1.getConteudosConcluidos());
        System.out.println("Conteudos concluídos " + dev2.getNome() + ": " + dev2.getConteudosConcluidos());

        dev2.progredir();
        dev1.progredir();

        System.out.println("Depois da progressão");
        System.out.println("Conteudos concluídos " + dev1.getNome() + ": " + dev1.getConteudosConcluidos());
        System.out.println("Conteudos concluídos " + dev2.getNome() + ": " + dev2.getConteudosConcluidos());
        System.out.println("XP: " + dev2.getNome() + ": "  + dev2.calcularTotalXp());
        System.out.println("Conteudos inscritos " + dev2.getNome() + ": " + dev2.getConteudosInscritos());


    }
}
