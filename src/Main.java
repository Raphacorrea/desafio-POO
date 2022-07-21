import br.com.dio.desafio.dominio.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Curso curso1 = new Curso();
        curso1.setTitulo("Curso JAVA");
        curso1.setDescricao("descrição curso JAVA");
        curso1.setCargaHoraria(8);


        Curso curso2 = new Curso();
        curso2.setTitulo("Curso JavaScript");
        curso2.setDescricao("descrição curso JavaScript");
        curso2.setCargaHoraria(4);

        Conteudo conteudo = new Curso();
        //polimorfismo

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("mentoria de java");
        mentoria.setDescricao("descricao mentoria java");
        mentoria.setData(LocalDate.now());

/*
        System.out.println(curso1);
        System.out.println(curso2);
        System.out.println(mentoria);
*/
        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        Dev devRapha = new Dev();
        devRapha.setNome("Rapha");
        devRapha.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos: "+devRapha.getConteudosInscritos());
        devRapha.progredir();
        System.out.println(" ------ ");
        System.out.println("Conteúdos Concluídos: "+devRapha.getConteudosConcluidos());
        System.out.println("Conteúdos Inscritos: "+devRapha.getConteudosInscritos());
        System.out.println("XP: "+ devRapha.calcularTotalXp());

        Dev devLucca = new Dev();
        devLucca.setNome("Lucca");
        devLucca.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos: "+devLucca.getConteudosInscritos());
        devLucca.progredir();
        System.out.println(" ------ ");
        System.out.println("Conteúdos Concluídos: "+devLucca.getConteudosConcluidos());
        System.out.println("Conteúdos Inscritos: "+devLucca.getConteudosInscritos());
        System.out.println("XP: "+ devLucca.calcularTotalXp());

    }

}
