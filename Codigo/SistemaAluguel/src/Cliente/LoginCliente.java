package Cliente;

import java.util.Scanner;

/**
 * Classe View para realizar o login de um cliente.
 *
 * @param lista a lista de clientes cujo qual sera localizado as credenciais de
 *              login
 * @return O cliente logado com as credenciais confirmadas ou null se nenhum
 *         cliente for logado
 */
public class LoginCliente {
    public static Cliente login(ListaCliente lista) {
        Scanner s = new Scanner(System.in);
        System.out.println("Digite o usuario");
        String user = s.nextLine();
        Cliente cliente = lista.locateClienteByUser(user);
        System.out.println("Digite a senha");
        String password = s.nextLine();
        if (cliente.verificarSenha(password))
            return cliente;
        else
            System.out.println("Usuario ou senha incorretos");
        return null;
    }
}
