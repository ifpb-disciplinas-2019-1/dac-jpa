package br.edu.ifpb.main;

import br.edu.ifpb.domain.single.Animal;
import br.edu.ifpb.domain.table.Carro;
import br.edu.ifpb.domain.table.Celta;
import br.edu.ifpb.domain.table.Fusca;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 16/07/2019, 10:39:29
 */
public class MainTable {

    public static void main(String[] args) {
        EntityManager em = Persistence
            .createEntityManagerFactory("ExemploPostgres")
            .createEntityManager();

        Carro carro = new Carro(
            "Meu carro","carro de mão"
        );

        Celta celta = new Celta(
            "2012","Meu celtinha","life"
        );

        Fusca fusca = new Fusca(
            "123","Meu fusquinha","86"
        );

        em.getTransaction().begin();
        em.persist(celta);
        em.persist(carro);
        em.persist(fusca);
        em.getTransaction().commit();

        em.createQuery("FROM Carro g",Carro.class)
            .getResultList()
            .forEach(
                // EU DISSE. NÃO USAR!!!!!
                //                c->{
                //                    if(c instanceof Fusca){
                //                        Fusca f = (Fusca) c;
                //                        System.out.println(f.getNumetoDoChassi());
                //                    }
                //            
                //              }
                g -> System.out.println(g.getNome())
            );
    }

}
