import java.io.IOException;
import java.util.Scanner;

public class Controler {

    private Cliente user;
    private Funcionario session;
    private ListaCliente listCliente;
    private ListaFuncionario listFuncs;

    public void Controler() throws InterruptedException, IOException {
        this.listCliente = new ListaCliente(); // Converter para carregamento de usuarios via arquivo
        this.start();
    }

    public void start() throws InterruptedException, IOException {
        Scanner s = new Scanner(System.in);
        int option;
        do {
            // limpeza de cmd
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");

            System.out.println("Qual sistema deseja acessar?");
            System.out.println("1 - Sou um cliente");
            System.out.println("2 - Sou um funcionario");
            System.out.println("3 - Quero me cadastrar como cliente");
            System.out.println("0 - Sair do sistema");
            option = s.nextInt();
            switch (option) {
                case 0:
                case 1:
                    user = LoginCliente.login(this.listCliente);
                case 2:
                    session = LoginFuncionario.login(this.listFuncs);
                case 3:
                    listCliente.add(CadastroCliente.cadastrar());
                default:
                    System.out.println("Opcao nao disponivel");
            }
        } while (option != 0);
        s.close();
    }
}
