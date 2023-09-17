package Cliente;

import java.util.Scanner;

public class CadastroCliente {
    /**
     * Este método permite cadastrar um novo cliente, solicitando o nome de usuário
     * e a senha do usuário a partir da entrada padrão (console).
     *
     * @return Um objeto Cliente criado com as informações fornecidas pelo usuário.
     */
    public static Cliente cadastrar() {
        Scanner s = new Scanner(System.in);
        System.out.println("Digite o usuario");
        String user = s.nextLine();
        System.out.println("Digite a senha");
        String password = s.nextLine();

        Cliente c = new Cliente(user, password);
        s.close();
        return c;
    }
}
