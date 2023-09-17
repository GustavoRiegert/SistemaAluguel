import java.util.ArrayList;

public class ListaCliente {
    ArrayList<Cliente> clientes = new ArrayList<>();

    // Gerando uma lista com usuario teste cliente/cliente
    public void ListaCLiente() {
        Cliente cli = new Cliente("cliente", "cliente");
        this.add(cli);
    }

    public void add(Cliente c) {
        clientes.add(c);
    }

    public Cliente locateClienteByUser(String user) {
        for (Cliente cliente : clientes) {
            if (cliente.getUser().equals(user))
                return cliente;
        }
        return null;
    }
}
