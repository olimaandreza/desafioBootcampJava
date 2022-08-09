import java.time.LocalDate;

import desafio.dominio.Curso;
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

        System.out.println(curso1);
        System.out.println(curso2);
        System.out.println(mentoria1);

    }
}
