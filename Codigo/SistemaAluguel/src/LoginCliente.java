import java.util.Scanner;

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
