package br.edu.ifpb.web.jsf;

import br.edu.ifpb.application.Carrinho;
import br.edu.ifpb.domain.venda.Item;
import br.edu.ifpb.domain.venda.Venda;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 15/08/2019, 10:24:13
 */
@Named
@SessionScoped
public class Controlador implements Serializable {

    @Inject
    private Carrinho carrinho;

    private Item item = new Item();

    public String novo() {
        this.carrinho.adicionar(item);
        this.item = new Item();
        return null;
    }

    public String finalizar() {
        this.carrinho.finalizar();
        logout();
        
        return "index?faces-redirect=true";
    }

    public String cancelar() {
        this.carrinho.cancelar();
        return null;
    }

    public List<Item> todosOsProdutos() {
        return this.carrinho.todosOsProdutos();
    }
    public List<Venda> todasAsVendas() {
        return this.carrinho.todasAsVendas();
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    private void logout() {
        FacesContext currentInstance = FacesContext.getCurrentInstance().getCurrentInstance();
        HttpSession session = (HttpSession) currentInstance.getExternalContext().getSession(true);
        session.invalidate();
    }

}
