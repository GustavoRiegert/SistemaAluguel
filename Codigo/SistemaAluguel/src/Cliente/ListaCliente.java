package Cliente;

import java.util.ArrayList;

public class ListaCliente {
    ArrayList<Cliente> clientes = new ArrayList<>();

    /**
     * Cria uma lista de clientes com um cliente de exemplo (usuário "cliente" e
     * senha "cliente").
     * Este método é usado para fins de teste.
     */
    public void ListaCLiente() {
        Cliente cli = new Cliente("cliente", "cliente");
        this.add(cli);
    }

    /**
     * Adiciona um cliente à lista de clientes.
     *
     * @param c O cliente a ser adicionado.
     */
    public void add(Cliente c) {
        clientes.add(c);
    }

    /**
     * Localiza um cliente na lista pelo nome de usuário.
     *
     * @param user O nome de usuário a ser procurado.
     * @return O cliente encontrado ou null se nenhum cliente com o nome de usuário
     *         especificado for encontrado.
     */
    public Cliente locateClienteByUser(String user) {
        for (Cliente cliente : clientes) {
            if (cliente.getUser().equals(user))
                return cliente;
        }
        return null;
    }
}
