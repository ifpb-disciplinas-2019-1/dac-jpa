package br.edu.ifpb.main;

import br.edu.ifpb.domain.Departamento;
import br.edu.ifpb.domain.Dependente;
import br.edu.ifpb.domain.Dependentes;
import br.edu.ifpb.domain.Funcionario;
import br.edu.ifpb.domain.Gerencia;
import br.edu.ifpb.domain.Gerente;
import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 16/07/2019, 22:51:20
 */
public class MainConsultasJPQL {

    public static void main(String[] args) {
        EntityManager em = Persistence
            .createEntityManagerFactory("ExemploPU")
            .createEntityManager();
        new IniciadorBancoDeDados(em).dadosIniciais();

//        consultarTodosOsFuncionarios(em);
//        consultarDepartamentoComId(em);
//        consultarDepartamentoComIdParametros(em);
//        consultarDependentesComPaginacao(em);
//        consultarNomeDoDependentes(em);
//        consultarNomeDoDepartamentoEGerente(em);
//        consultarNomeDoDepartamentoEGerenteComTipo(em);
//        consultarNomeDoFuncionarioQuePossuiDependentes(em);
//        consultarNomeDoFuncionarioNomeDoDependente(em);
//        consultarNomeDoFuncionarioQuantidadeDeDependentes(em);
//        consultarDependentesComIdEntre(em);
//        consultarDependentesComIdFora(em);
//        consultarDependentesComIdEntreBETWEEN(em);
//        consultarDependentesComIdForaBETWEEN(em);
//        consultarDepartamentoSemGerente(em);
//        consultarDepartamentoComGerente(em);
//        consultarFuncionarioPossuiDependente(em);
//        consultarFuncionarioDependenteIniciandoComLetra(em);
//        consultarPrimeiraLetraNomesDosDependente(em);
//        consultarNumeroDeTodosOsDependentes(em);
//        consultarNomeDoFuncionarioEQuantidadeDependentes(em);
//        consultarFuncionarComSalarioSuperiorAMedia(em);
//        consultarDependenteSeTodosIdSuperiorADez(em);
//        consultarDependenteSeQualquerIdSuperiorADez(em);
        atualizarNomeTodosDependentes(em);
//        removerDependenteComId(em);
//        consultarTodosOsDependentesNamedQuery(em);
//        consultarOsDependentesComIdNamedQuery(em);
//        consultarTodosOsFuncionariosNativeQuery(em);
//        consultarNomeIdFuncionariosNativeQuery(em);
//        consultarNomeIdEmpregadosNativeQueryComTipo(em);
//        consultarNomeIdFuncionarioNativeQueryComTipoEntidade(em);
    }

    /* Selecionar todos os Funcionarios */
    private static void consultarTodosOsFuncionarios(EntityManager em) {
        // SELECT * FROM Funcionario AS f -> tabela
        String jpql = "SELECT f FROM Funcionario f"; // entidade
//        Query createQuery = em.createQuery(jpql);
        TypedQuery<Funcionario> query = em.createQuery(jpql,Funcionario.class);
        List<Funcionario> lista = query.getResultList();
        lista.forEach(
            f -> System.out.println(f.getNome())
        );
    }

    /* Selecionar o Departamento com id igual 7 */
    private static void consultarDepartamentoComId(EntityManager em) {
        // SELECT * FROM Departamento AS d WHERE d.id=6
        String jpql = "SELECT d FROM Departamento d WHERE d.id=7";
        TypedQuery<Departamento> query = em.createQuery(jpql,Departamento.class);
        Departamento departamento = query.getSingleResult();
        System.out.println(departamento.getAbreviacao());
    }

    /* Selecionar o Departamento com id igual a um determinado parametro */
    private static void consultarDepartamentoComIdParametros(EntityManager em) {
        // SELECT * FROM Departamento AS d WHERE d.id = ?

//        String jpql = "SELECT d FROM Departamento d WHERE d.abreviacao=?2 AND d.id=?1";
        String jpql = "SELECT d FROM Departamento d WHERE d.abreviacao=:abreviacao AND d.id=:codigo";
        TypedQuery<Departamento> query = em.createQuery(
            //            jpql+"7 OR 1=1", //Mailson, by!
            jpql,
            Departamento.class
        );
//        query.setParameter(1,7);
//        query.setParameter(2,"UNINFO");
        query.setParameter("codigo",7);
        query.setParameter("abreviacao","UNINFO");

        query.getResultList()
            .forEach(
                d -> System.out.println(d.getAbreviacao())
            );
    }

    /* Selecionar os Dependentes por página */
    private static void consultarDependentesComPaginacao(EntityManager em) {
        // A B | C D | E 
        // SELECT * FROM Dependente AS d
        String jqpl = "SELECT d FROM Dependente d ORDER BY d.codigo ASC";
        TypedQuery<Dependente> query = em.createQuery(jqpl,Dependente.class);
        Long todos = em.createQuery("SELECT COUNT(d) FROM Dependente d",Long.class)
            .getSingleResult();
        int quantidadePorPagina = 3;
        int quantidadeDePagina = (int) Math.ceil(todos / (double) quantidadePorPagina);

        for (int numeroDaPagina = 1; numeroDaPagina <= quantidadeDePagina; numeroDaPagina++) {
            List<Dependente> resultList = query
                .setFirstResult(quantidadePorPagina * (numeroDaPagina - 1)) //mutável
                .setMaxResults(quantidadePorPagina)
                .getResultList();
            System.out.println(
                String.format("-----Página %d ------",numeroDaPagina)
            );
            for (Dependente dependente : resultList) {
                System.out.println(dependente.getCodigo() + " " + dependente.getNome()); // imutável
            }
        }
//2 Chiquinha
//3 Mariana
//16 Godiles
//17 jose
//18 Tulio

    }

    /* Selecionar o nome de todos os Dependentes*/
    private static void consultarNomeDoDependentes(EntityManager em) {
        // SELECT d.nome FROM Dependente AS d
        String jpql = "SELECT d.nome FROM Dependente d";
        TypedQuery<String> query = em.createQuery(jpql,String.class);
        query.getResultList().forEach(System.out::println);

    }

    /* Selecionar a abreviação do Departamento e o seu Gerente */
    private static void consultarNomeDoDepartamentoEGerente(EntityManager em) {
        //SELECT d.abreviacao, d.gerente_id FROM Departamento d
        String jpql = "SELECT d.abreviacao, d.gerente FROM Departamento d"; // Object[]
        Query query = em.createQuery(jpql);
        List<Object[]> lista = query.getResultList();

        for (Object[] object : lista) {
            System.out.println(object[0]);
            System.out.println(object[1]);
        }

    }

    /* Selecionar a abreviação do Departamento e o seu Gerente usando um Tipo específico*/
    private static void consultarNomeDoDepartamentoEGerenteComTipo(EntityManager em) {
        String jpql = " SELECT NEW br.edu.ifpb.domain.Gerencia(d.abreviacao, d.gerente) FROM Departamento d";
        //String jpql = " SELECT NEW "+Gerencia2.class.getCanonicalName()+"(d.abreviacao, d.gerente) FROM Departamento d";
        TypedQuery<Gerencia> query = em.createQuery(jpql,Gerencia.class);
        List<Gerencia> lista = query.getResultList();
        lista.forEach(
            g -> System.out.println(g.getAbreviacao())
        );
    }

    /* Selecionar o nomes dos Funcionarios que possuem Dependentes */
    private static void consultarNomeDoFuncionarioQuePossuiDependentes(EntityManager em) {
        //SELECT f.nome FROM Funcionario f INNER JOIN Dependente d ON f.id=d.funcionario_id
//        String jpql = "SELECT f.nome FROM Funcionario f, Dependente ";
        String jpql = "SELECT f.nome FROM Funcionario f, IN(f.dependentes) d";
        TypedQuery<String> query = em.createQuery(jpql,String.class);
        query.getResultList().forEach(System.out::println);
    }

    /* Selecionar o nomes dos Funcionarios e dos respectivos Dependentes */
    private static void consultarNomeDoFuncionarioNomeDoDependente(EntityManager em) {
        String jpql = "SELECT NEW br.edu.ifpb.domain.Dependentes(f.nome, d.nome) FROM Funcionario f JOIN f.dependentes d";
        TypedQuery<Dependentes> query = em.createQuery(jpql,Dependentes.class);
        query.getResultList().forEach(
            d -> System.out.println(
                d.getFuncionario() + " " + d.getDependente()
            )
        );

    }

    /* Selecionar o nomes dos Funcionarios e quantidade de seus Dependentes */
    private static void consultarNomeDoFuncionarioQuantidadeDeDependentes(EntityManager em) {
        String jpql = "SELECT f.nome, COUNT(d) FROM Funcionario f LEFT JOIN f.dependentes d GROUP BY f.nome";
        Query createQuery = em.createQuery(jpql);
        List<Object[]> lista = createQuery.getResultList();
        for (Object[] objects : lista) {
            System.out.println(objects[0] + " " + objects[1]);
        }
    }

    /* Selecionar o nome dos Dependentes que possuem id entre 15 e 17*/
    private static void consultarDependentesComIdEntre(EntityManager em) {
        String jpql = "SELECT d FROM Dependente d WHERE d.codigo >= 15 AND d.codigo <= 17";
        TypedQuery<Dependente> query = em.createQuery(jpql,Dependente.class);
        List<Dependente> list = query.getResultList();
        list.forEach(
            d -> System.out.println(d.getCodigo() + " - " + d.getNome())
        );

    }

    /* Selecionar o nome dos Dependentes que possuem id fora do intervalo de 15 a 17*/
    private static void consultarDependentesComIdFora(EntityManager em) {
        String jpql = "SELECT d FROM Dependente d WHERE d.codigo<15 OR d.codigo>17";
//        String jpql = "SELECT d FROM Dependente d WHERE NOT( d.codigo>=15 AND d.codigo<=17 )";
        TypedQuery<Dependente> query = em.createQuery(jpql,Dependente.class);
        query.getResultList()
            .forEach(
                d -> System.out.println(d.getCodigo() + " - " + d.getNome())
            );
    }

    /* Selecionar o nome dos Dependentes que possuem id entre 15 e 17, usando a clausa BETWEEN*/
    private static void consultarDependentesComIdEntreBETWEEN(EntityManager em) {
        String jpql = "SELECT d FROM Dependente d WHERE d.codigo BETWEEN 15 AND 17";
        TypedQuery<Dependente> query = em.createQuery(jpql,Dependente.class);
        query.getResultList()
            .forEach(
                d -> System.out.println(d.getCodigo())
            );
    }

    /* Selecionar o nome dos Dependentes que possuem id fora do intervalo de 15 a 17, usando BETWEEN*/
    private static void consultarDependentesComIdForaBETWEEN(EntityManager em) {
        String jpql = "SELECT d FROM Dependente d WHERE d.codigo NOT BETWEEN 15 AND 17";
        TypedQuery<Dependente> query = em.createQuery(jpql,Dependente.class);
        query.getResultList()
            .forEach(
                d -> System.out.println(d.getCodigo())
            );
    }

    /* Selecionar os Departamentos que não possuem Gerente */
    private static void consultarDepartamentoSemGerente(EntityManager em) {
        String jpql = "SELECT d FROM Departamento d WHERE d.gerente IS NULL";
        TypedQuery<Departamento> query = em.createQuery(jpql,Departamento.class);
        query.getResultList()
            .forEach(
                d -> System.out.println(d.getAbreviacao())
            );

        // Selecionar os Gerentes que não gerenciam Departamentos
//        String jpql = "SELECT g FROM Gerente g LEFT JOIN g.dep d WHERE d.gerente IS NULL";
//        TypedQuery<Gerente> query = em.createQuery(jpql,Gerente.class);
//        query.getResultList()
//            .forEach(
//                d -> System.out.println(d.getNome())
//            );
    }

    /* Selecionar os Departamentos que possuem Gerente */
    private static void consultarDepartamentoComGerente(EntityManager em) {
        String jpql = "SELECT d FROM Departamento d WHERE d.gerente IS NOT NULL";
        TypedQuery<Departamento> createQuery = em.createQuery(jpql,Departamento.class);
        createQuery.getResultList()
            .forEach(
                d -> System.out.println(d.getAbreviacao())
            );

    }

    /* Selecionar o nome dos Funcionarios que possuem Dependentes */
    private static void consultarFuncionarioPossuiDependente(EntityManager em) {
        String jpql = "SELECT f FROM Funcionario f WHERE f.dependentes IS NOT EMPTY";
        TypedQuery<Funcionario> createQuery = em.createQuery(jpql,Funcionario.class);
        createQuery.getResultList()
            .forEach(
                f -> System.out.println(f.getNome())
            );
    }

    /* Selecionar o nome dos Funcionarios que possuem Dependentes e 
     * o nome do Dependente começa com letra M */
    private static void consultarFuncionarioDependenteIniciandoComLetra(EntityManager em) {
        String letra = "m%";
        String jpql = "SELECT UPPER(f.nome) FROM Funcionario f, Dependente d "
            + "WHERE d MEMBER OF f.dependentes AND LOWER(d.nome) LIKE :letra";
        TypedQuery<String> createQuery = em.createQuery(jpql,String.class);
        createQuery.setParameter("letra",letra);
        createQuery.getResultList().forEach(System.out::println);
    }

    /* Selecionar a primeira letra do nome dos Dependentes  */
    private static void consultarPrimeiraLetraNomesDosDependente(EntityManager em) {
        String jpql = "SELECT SUBSTRING(d.nome, 1, 1) FROM Dependente d";
        TypedQuery<String> query = em.createQuery(jpql,String.class);
        query.getResultList()
            .forEach(
                //                nome -> System.out.println(nome.substring(0,1))
                System.out::println
            );
    }

    /* Selecionar o total de Dependentes  */
    private static void consultarNumeroDeTodosOsDependentes(EntityManager em) {
        String jpql = "SELECT COUNT(d) FROM Dependente d";
        TypedQuery<Long> createQuery = em.createQuery(jpql,Long.class);
        Long result = createQuery.getSingleResult();
        System.out.println("result = " + result);
    }

    /* Selecionar o nomes dos Funcionarios e quantidade de seus Dependentes, 
     * se a quantidade for superior ou igual a 2*/
    private static void consultarNomeDoFuncionarioEQuantidadeDependentes(EntityManager em) {
//        String jpql = "SELECT f.nome, COUNT(d) FROM Funcionario f JOIN Dependente d "
//            + "WHERE d MEMBER OF f.dependentes GROUP BY f.nome HAVING COUNT(d) >=2 ";
        String jpql = "SELECT f.nome, COUNT(d) FROM Funcionario f JOIN f.dependentes d "
            + "GROUP BY f.nome HAVING COUNT(d) >=2 ";
        Query createQuery = em.createQuery(jpql);
        List<Object[]> resultList = createQuery.getResultList();
        resultList.forEach(
            d -> System.out.println(
                Arrays.toString(d)
            )
        );
    }

    /* Selecionar o nome do Funcionario que possui o salário superior a média */
    private static void consultarFuncionarComSalarioSuperiorAMedia(EntityManager em) {
        //avg=1825.0
        String jpql = "SELECT f.nome, f.salario FROM Funcionario f WHERE f.salario < "
            + "(SELECT AVG(funcionario.salario) FROM Funcionario funcionario)";
        Query createQuery = em.createQuery(jpql);
        List<Object[]> resultList = createQuery.getResultList();
        resultList.forEach(
            (a) -> System.out.println(
                Arrays.toString(a)
            )
        );
    }

    /* Selecionar o nome dos Dependentes SE TODOS os códigos forem superior a dez */
    private static void consultarDependenteSeTodosIdSuperiorADez(EntityManager em) {
//        String jpql = "SELECT d.nome, d.codigo FROM Dependente d WHERE NOT EXISTS "
//            + "(SELECT d FROM Dependente d WHERE 10 >= d.codigo)";
        String jpql = "SELECT d.nome, d.codigo FROM Dependente d WHERE 10 < ALL"
            + "(SELECT d.codigo FROM Dependente d)";
        Query query = em.createQuery(jpql);
        List<Object[]> resultList = query.getResultList();
        resultList.forEach(a -> System.out.println(Arrays.toString(a)));
    }

    /* Selecionar o nome dos Dependentes SE ALGUM dos códigos for superior a dez */
    private static void consultarDependenteSeQualquerIdSuperiorADez(EntityManager em) {
        String jpql = "SELECT d.nome, d.codigo FROM Dependente d WHERE 10 < SOME "
            + "(SELECT dep.codigo FROM Dependente dep)";
        Query createQuery = em.createQuery(jpql);
        List<Object[]> resultList = createQuery.getResultList();
        resultList.forEach(
            a -> System.out.println(
                Arrays.toString(a)
            )
        );
    }

    /* Atualizar o nome de todos os Dependentes para Maisculo*/
    private static void atualizarNomeTodosDependentes(EntityManager em) {
        String jpql = "UPDATE Dependente d SET d.nome=LOWER(d.nome)";
        em.getTransaction().begin();
        int executeUpdate = em.createQuery(jpql).executeUpdate();
        em.getTransaction().commit();
        System.out.println("Quantidade de entidades atualizadas: " + executeUpdate);

    }

    /* Remover o Dependente com código igual a 2 */
    private static void removerDependenteComId(EntityManager em) {

    }

    /* Selecionar todos os Dependentes  */
    private static void consultarTodosOsDependentesNamedQuery(EntityManager em) {

    }

    /* Selecionar todos os Dependentes com id superior a 5 */
    private static void consultarOsDependentesComIdNamedQuery(EntityManager em) {

    }

    private static void consultarTodosOsFuncionariosNativeQuery(EntityManager em) {

    }

    private static void consultarNomeIdFuncionariosNativeQuery(EntityManager em) {

    }

    private static void consultarNomeIdEmpregadosNativeQueryComTipo(EntityManager em) {

    }

    private static void consultarNomeIdFuncionarioNativeQueryComTipoEntidade(EntityManager em) {

    }
}
//class Gerencia2{
//    
//    private String abreviacao;
//    private Gerente gerente;
//
//    public Gerencia2(String abreviacao,Gerente gerente) {
//        this.abreviacao = abreviacao;
//        this.gerente = gerente;
//    }
//
//    public String getAbreviacao() {
//        return abreviacao;
//    }
//
//    public Gerente getGerente() {
//        return gerente;
//    }
//    
//}
