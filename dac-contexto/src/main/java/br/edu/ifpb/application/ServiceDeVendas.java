package br.edu.ifpb.application;

import br.edu.ifpb.domain.venda.Item;
import br.edu.ifpb.domain.venda.Venda;
import java.util.List;
import javax.ejb.Remove;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 15/08/2019, 16:46:45
 */
@Stateless
public class ServiceDeVendas {

    // Contexto com escopo de transação
    @PersistenceContext
    private EntityManager em;

    public void novo(Item item) {
        em.persist(item);
    }

    public List<Item> todosOsProdutos() {
        return em.createQuery("FROM Item i",Item.class).getResultList();
    }

    @Remove
    public void salvar(Venda venda) {
        em.persist(venda);
    }

    public List<Venda> todasAsVendas() {
        return em.createQuery("FROM Venda v",Venda.class).getResultList();
    }
}
