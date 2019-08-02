package br.edu.ifpb.web;

import br.edu.ifpb.domain.Cliente;
import br.edu.ifpb.infra.Clientes;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 06/06/2019, 10:31:43
 */
@Named
@RequestScoped
public class ControladorDeClientes {

    @Inject
    private Clientes clientes;
    private Cliente cliente = new Cliente();

    public String salvar() {
        clientes.novo(cliente);
        cliente = new Cliente();
        return null;
    }

    public List<Cliente> getTodosOsClientes() {
        return clientes.todos();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
