package br.edu.ifpb.main;

import br.edu.ifpb.domain.Departamento;
import br.edu.ifpb.domain.Dependente;
import br.edu.ifpb.domain.Dependente_;
import br.edu.ifpb.domain.Funcionario;
import br.edu.ifpb.domain.Funcionario_;
import br.edu.ifpb.domain.Gerencia;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CompoundSelection;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.ListJoin;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 23/07/2019, 22:51:20
 */
public class MainConsultasCriteria {

    public static void main(String[] args) {
        EntityManager em = Persistence
            .createEntityManagerFactory("ExemploPU")
            .createEntityManager();
        new IniciadorBancoDeDados(em).dadosIniciais();

//        consultarTodosOsFuncionarios(em);
//        consultarDepartamentoComId(em);
//        consultarNomeDoDependentes(em);
//        consultarDependentesComIdMaior(em);
//        consultarAbreviacaoDoDepartamentoEGerente(em);
//        consultarNomeDoDepartamentoEGerenteComConstrutor(em);
//        consultarAQuantidadeDeDependentes(em);
//        consultarNomeDoFuncionarioQuePossuiDependentes(em);
//        consultarNomeDoFuncionarioNomeDoDependenteJOIN(em);
        consultarDependentesComIdEntreBETWEEN(em);
//        consultarDepartamentoSemGerente(em);
//        consultarFuncionarioPossuiDependente(em);
//        consultarFuncionarioDependenteIniciandoComLetra(em);
//        consultarNomeDoFuncionarioEQuantidadeDependentes(em);
    }

    private static void consultarTodosOsFuncionarios(EntityManager em) {
        //SELECT f FROM Funcionario f
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Funcionario> criteria = builder.createQuery(Funcionario.class);
        Root<Funcionario> root = criteria.from(Funcionario.class);
        criteria.select(root);

        TypedQuery<Funcionario> query = em.createQuery(criteria);

        query.getResultList()
            .forEach(
                f -> System.out.println(
                    f.getNome()
                )
            );

    }

    private static void consultarDepartamentoComId(EntityManager em) {
        // SELECT d FROM Departamento d WHERE d.id= 7 AND d.abreviacao='UNINFO'
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Departamento> criteria = builder.createQuery(Departamento.class);
        Root<Departamento> root = criteria.from(Departamento.class);
        //UNINFO
        Predicate predicate = builder.equal(
            root.get("id"),7
        );
        Predicate abreviacao = builder.like(
            root.get("abreviacao"),"UNINFO"
        );
        Predicate and = builder.and(
            predicate,abreviacao
        );

        criteria.select(root).where(and);

//        criteria.select(root).where(
//            builder.and(
//                builder.equal(
//                    root.get("id"),7
//                ),
//                builder.like(
//                    root.get("abreviacao"),"UNINFO"
//                )
//            )
//        );
        em.createQuery(criteria)
            .getResultList()
            .forEach(d
                -> System.out.println(
                d.getId()
                + " "
                + d.getAbreviacao()
            )
            );
        ;

    }

    private static void consultarNomeDoDependentes(EntityManager em) {
        // SELECT d.nome FROM Dependente d
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<String> criteria = builder.createQuery(String.class);
        Root<Dependente> root = criteria.from(Dependente.class);

        criteria.select(
            root.get("nome")
        );

        em.createQuery(criteria)
            .getResultList()
            .forEach(System.out::println);

    }

    private static void consultarDependentesComIdMaior(EntityManager em) {
        // SELECT d FROM Dependente d WHERE d.codigo >:id
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Dependente> criteria = builder.createQuery(Dependente.class);
        Root<Dependente> root = criteria.from(Dependente.class);
        Predicate maiorQue = builder.greaterThan(
            //            root.get("codigo"),
            root.get(Dependente_.codigo),
            builder.parameter(Integer.class,"id")
        );

        criteria.select(root).where(maiorQue);

        TypedQuery<Dependente> query = em.createQuery(criteria);
        query.setParameter("id",10);

        query.getResultList()
            .forEach(
                d -> System.out.println(
                    d.getNome()
                )
            );

    }

    private static void consultarAbreviacaoDoDepartamentoEGerente(EntityManager em) {
        // SELECT d.abreviacao, d.gerente FROM Departamento d
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Gerencia> criteria = builder.createQuery(Gerencia.class);
        Root<Departamento> root = criteria.from(Departamento.class);

        criteria.multiselect(
            root.get("abreviacao"),root.get("gerente")
        );

        em.createQuery(criteria).getResultList()
            .forEach(
                g -> System.out.println(
                    g.getAbreviacao() + " " + g.getGerente().getNome()
                )
            );
    }

    private static void consultarNomeDoDepartamentoEGerenteComConstrutor(EntityManager em) {
        // SELECT NEW Gerencia(d.abreviacao, d.gerente) FROM Departamento d
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Gerencia> criteria = builder.createQuery(Gerencia.class);
        Root<Departamento> root = criteria.from(Departamento.class);

        CompoundSelection<Gerencia> construct = builder.construct( // NEW
            Gerencia.class,
            root.get("abreviacao"),
            root.get("gerente")
        );
        criteria.select(construct);
//        criteria.select(
//            builder.construct( // NEW
//                Gerencia.class,
//                root.get("abreviacao"),
//                root.get("gerente")
//            )
//        );

        em.createQuery(criteria)
            .getResultList()
            .forEach(
                g -> System.out.println(
                    g.getAbreviacao() + " " + g.getGerente().getNome()
                )
            );

    }

    private static void consultarAQuantidadeDeDependentes(EntityManager em) {
        // SELECT COUNT(d) FROM Dependente d
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
        Root<Dependente> root = criteria.from(Dependente.class);

        Expression<Long> count = builder.count(root);
//        criteria.select(count); //retorno?????
//        Long total = em.createQuery(criteria).getSingleResult();
        CriteriaQuery<Long> consulta = criteria.select(count); //mutavel
        Long total = em.createQuery(consulta).getSingleResult();
        System.out.println("total: " + total);

    }

    private static void consultarNomeDoFuncionarioQuePossuiDependentes(EntityManager em) {
        // SELECT f.nome FROM Funcionario f WHERE f.dependentes IS NOT EMPTY
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<String> criteria = builder.createQuery(String.class);
        Root<Funcionario> root = criteria.from(Funcionario.class);
        Predicate notEmpty = builder.isNotEmpty(
            root.get(Funcionario_.dependentes)
        );

        criteria.select(root.get(Funcionario_.nome)).where(notEmpty);

        em.createQuery(criteria).getResultList().forEach(System.out::println);

    }

    private static void consultarNomeDoFuncionarioNomeDoDependenteJOIN(EntityManager em) {
        // SELECT f.nome, d.nome FROM Funcionario f JOIN (f.dependentes) d
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Tuple> criteria = builder.createTupleQuery();
        Root<Funcionario> root = criteria.from(Funcionario.class); //func
        Join<Funcionario,Dependente> join = root.join(
            Funcionario_.dependentes,
            JoinType.LEFT
        ); // dep

        CompoundSelection<Tuple> tuple = builder.tuple(
            join.get("nome").alias("nome"),
            //            root.get("nome").alias("nomeDoFuncionario")
            join.getParent().get("nome").alias("nomeDoFuncionario")
        );
        criteria.select(tuple);
        List<Tuple> resultList = em.createQuery(criteria).getResultList();

        resultList.forEach((tupla) -> {
            String nomeFunc = tupla.get("nomeDoFuncionario",String.class);
            String nomeDep = tupla.get("nome",String.class);
            System.out.println(nomeFunc + " " + nomeDep);
        });

    }

    private static void consultarDependentesComIdEntreBETWEEN(EntityManager em) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Dependente> criteria = builder.createQuery(Dependente.class);
        Root<Dependente> root = criteria.from(Dependente.class);
        Predicate between = builder.between(
            root.get("codigo"),
            10,
            18
        );
        criteria.select(root).where(between);

        em.createQuery(criteria)
            .getResultList()
            .forEach(
                d -> System.out.println(d.getNome())
            );

    }
}
