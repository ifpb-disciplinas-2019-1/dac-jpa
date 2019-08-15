package br.edu.ifpb.application;

import br.edu.ifpb.domain.venda.Item;
import br.edu.ifpb.domain.venda.Venda;
import java.util.List;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.SynchronizationType;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 15/08/2019, 10:18:40
 */

@Stateful
public class Carrinho {

    // Contexto estendido e não-sincronizado
//    @PersistenceContext
    @PersistenceContext(unitName = "ContextoPU",
                        type = PersistenceContextType.EXTENDED,
                        synchronization = SynchronizationType.UNSYNCHRONIZED
    )
    private EntityManager em;

    private Venda venda = new Venda();

    public void adicionar(Item item) {
        venda.add(item);
        em.persist(item);
    }

    public List<Item> todosOsProdutos() {
        return em.createQuery("FROM Item i",Item.class).getResultList();
    }

    @Remove
    public void cancelar() {
        venda = new Venda();
    }

    @Remove
    public void finalizar() {
        em.persist(venda);
        em.joinTransaction();
    }

    public List<Venda> todasAsVendas() {
        return em.createQuery("FROM Venda v",Venda.class).getResultList();
    }
}
