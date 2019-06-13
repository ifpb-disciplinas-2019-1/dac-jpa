package br.edu.ifpb.main;

import br.edu.ifpb.domain.Aluno;
import br.edu.ifpb.domain.CPF;
import br.edu.ifpb.domain.Perfil;
import br.edu.ifpb.domain.Pessoa;
import br.edu.ifpb.domain.Professor;
import br.edu.ifpb.domain.Sexo;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 06/06/2019, 09:55:37
 */
public class Principal {

    public static void main(String[] args) {
        EntityManager em = Persistence
            .createEntityManagerFactory("ExemploPostgres")
            .createEntityManager();

//        salvarProfessor(em);
//        listarPerfil(em);
        salvarAluno(em);
//        salvarPessoa(em);
//        salvarPerfil(em);
    }

    private static void salvarProfessor(EntityManager em) {
        Professor job = new Professor(
            1,"Job"
        );
        job.novoEmail("ricardo.job@ifpb.edu.br");
        job.novoEmail("ricardo.job@ifpb.edu.br");
        job.novoEmail("ricardo.job@ifpb.edu.br");
        job.novoEmail("ricardo.job@ifpb.edu.br");
        job.novoEmail("ricardo.job@ifpb.edu.br");

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(job);
        transaction.commit();

        Professor prof = em.find(Professor.class,1);
        prof.getEmails()
            .forEach(System.out::println);
    }

    private static void listarPerfil(EntityManager em) {
        List<Perfil> list = em.createQuery("FROM Perfil p",Perfil.class)
            .getResultList();
        list.forEach(p -> System.out.println(p.getCodigo()));

    }

    private static void salvarPerfil(EntityManager em) {
        String descricao = "s entidades são convertidas para tabelas no banco..\n"
            + "Os atributos simples desta entidade são convertidos às colunas da respectiva tabela \n."
            + " Nesta seção vamos estudar como configura e utilizar as anotações nos atributos simples. \n"
            + " Nesta seção vamos estudar como configura e utilizar as anotações nos atributos simples. \n"
            + " Nesta seção vamos estudar como configura e utilizar as anotações nos atributos simples. \n"
            + " Nesta seção vamos estudar como configura e utilizar as anotações nos atributos simples. \n"
            + " Nesta seção vamos estudar como configura e utilizar as anotações nos atributos simples. \n"
            + " Nesta seção vamos estudar como configura e utilizar as anotações nos atributos simples. \n"
            + " Nesta seção vamos estudar como configura e utilizar as anotações nos atributos simples. \n"
            + " Nesta seção vamos estudar como configura e utilizar as anotações nos atributos simples. \n"
            + " Nesta seção vamos estudar como configura e utilizar as anotações nos atributos simples. \n"
            + " Nesta seção vamos estudar como configura e utilizar as anotações nos atributos simples. \n"
            + " Nesta seção vamos estudar como configura e utilizar as anotações nos atributos simples. \n"
            + " Nesta seção vamos estudar como configura e utilizar as anotações nos atributos simples. \n"
            + "-Todas as anotações estão presentes no pacote javax.persistence.*";

        Perfil perfil = new Perfil(
            1,
            descricao,
            "src/main/resources/imagens/chaves.jpg"
        );
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(perfil);
        transaction.commit();
    }

    private static void salvarPessoa(EntityManager em) {
        Pessoa pessoa = new Pessoa(
            2,"Kiko",Sexo.MASCULINO
        );
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(pessoa);
        transaction.commit();
//        Pessoa find = em.find(Pessoa.class,2);
//        System.out.println(find.getSexo());
    }

    private static void salvarAluno(EntityManager em) {
        Aluno aluno = new Aluno(
            6,"1231289","Florinda",9
        );

        EntityTransaction transaction = em.getTransaction();
//
        transaction.begin();
        em.persist(aluno);
        transaction.commit();

//        Aluno find = em.find(Aluno.class,6);
//
//        transaction.begin();
//        find.setNome("Mariana");
//        find.setCpf(
//            new CPF("123")
//        );
//        transaction.commit();
    }
}
