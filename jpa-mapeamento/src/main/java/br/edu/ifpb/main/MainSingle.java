package br.edu.ifpb.main;

import br.edu.ifpb.domain.single.Animal;
import br.edu.ifpb.domain.single.Cachorro;
import br.edu.ifpb.domain.single.Gato;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 16/07/2019, 10:39:29
 */
public class MainSingle {

    public static void main(String[] args) {
        EntityManager em = Persistence
            .createEntityManagerFactory("ExemploPostgres")
            .createEntityManager();

        Animal animal = new Animal(
            "Piolho","piolho"
        );

        Cachorro cachorro = new Cachorro(
            "tem?","REx","vira lata"
        );

        Gato gato = new Gato(
            "muita manha","Bichana","siames"
        );

        em.getTransaction().begin();
        em.persist(animal);
        em.persist(cachorro);
        em.persist(gato);
        em.getTransaction().commit();

        em.createQuery("FROM Animal g",Animal.class)
            .getResultList()
            .forEach(
                g -> System.out.println(g.getNome())
            );
    }

}
