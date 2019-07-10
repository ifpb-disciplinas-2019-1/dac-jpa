package br.edu.ifpb.main;

import br.edu.ifpb.domain.Departamento;
import br.edu.ifpb.domain.Dependente;
import br.edu.ifpb.domain.Endereco;
import br.edu.ifpb.domain.Fornecedor;
import br.edu.ifpb.domain.Funcionario;
import br.edu.ifpb.domain.Gerente;
import br.edu.ifpb.domain.Projeto;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 19/06/2019, 10:42:24
 */
public class Principal {

    public static void main(String[] args) {
        EntityManager em = Persistence
            .createEntityManagerFactory("ExemploPostgres")
            .createEntityManager();

        Dependente kiko = new Dependente(
            "Kiko"
        );
        Dependente chaves = new Dependente(
            "Chaves"
        );

        Endereco end = new Endereco(
            "rua","bairro","cidade"
        );
        Departamento uninfo = new Departamento(
            "Vila"
        );

        Funcionario func = new Funcionario(
            "Maria","123",end
        );
        func.novo(chaves);
        func.novo(kiko);
        func.setDepartamento(uninfo);

        Fornecedor job = new Fornecedor(
            "Job","UNINFO"
        );
        Fornecedor samara = new Fornecedor(
            "Samara","UFGP"
        );

        Projeto dac = new Projeto(
            "DAC - A volta"
        );

        Gerente paulo = new Gerente(
            "Paulo",
            "1234",
            new Date(),
            new Date()
        );
        
        dac.novo(job);
        dac.novo(samara);

        // Fazendo a atribuição do relacionamento bidirecional
        uninfo.setGerente(paulo);
        paulo.setDepartamento(uninfo);
        
        // Atribuir gerente aos projetos
        paulo.novo(dac);
        
        em.getTransaction().begin();
        em.persist(func);
        em.persist(uninfo);
        em.persist(paulo);
        em.persist(end);
        em.persist(dac);
        em.persist(job);
        em.persist(samara);
        em.getTransaction().commit();
    }

}
