import java.util.Scanner;

public class CadastroCliente {
    public static Cliente cadastrar() {
        Scanner s = new Scanner(System.in);
        System.out.println("Digite o usuario");
        String user = s.nextLine();
        System.out.println("Digite a senha");
        String password = s.nextLine();

        Cliente c = new Cliente(user, password);
        return c;
    }
}
