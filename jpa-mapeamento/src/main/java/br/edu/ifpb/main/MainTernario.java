package br.edu.ifpb.main;

import br.edu.ifpb.domain.hotel.Hospedagem;
import br.edu.ifpb.domain.hotel.HospedagemChave;
import br.edu.ifpb.domain.hotel.Hospede;
import br.edu.ifpb.domain.hotel.Hotel;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 11/07/2019, 09:53:33
 */
public class MainTernario {

    public static void main(String[] args) {
        EntityManager em = Persistence.
            createEntityManagerFactory("ExemploPostgres")
            .createEntityManager();

        Hotel hotel = new Hotel(
            "Acapuco"
        );
        Hospede chaves = new Hospede(
            "Chaves"
        );
        Hospede kiko = new Hospede(
            "Kiko"
        );

        Hospedagem primeira = new Hospedagem(
            hotel,
            chaves,
            new Date()
        );
        Hospedagem segunda = new Hospedagem(
            hotel,
            kiko,
            new Date()
        );

        em.getTransaction().begin();
        em.persist(kiko);
        em.persist(chaves);
        em.persist(hotel);
        em.persist(primeira);
        em.persist(segunda);
        em.getTransaction().commit();

        HospedagemChave chave = new HospedagemChave(
            hotel.getId(), // 3
            kiko.getId() // 1
        );

        Hospede find = em.find(Hospede.class,1);
        Hotel findHotel = em.find(Hotel.class,3);
        
        Hospedagem hosp = em.find(Hospedagem.class,chave);
        System.out.println(hosp.getHospede().getNome());
        System.out.println(hosp.getHotel().getAbreviacao());
        System.out.println(hosp.getData());

    }

}
