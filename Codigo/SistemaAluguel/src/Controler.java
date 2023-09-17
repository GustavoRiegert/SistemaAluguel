import java.io.IOException;
import java.util.Scanner;

import Cliente.CadastroCliente;
import Cliente.Cliente;
import Cliente.ListaCliente;
import Cliente.LoginCliente;
import Funcionario.Funcionario;
import Funcionario.ListaFuncionario;
import Funcionario.LoginFuncionario;

/**
 * Esta classe Controler é responsável por iniciar o sistema e fornecer uma
 * interface de linha de comando para os usuários.
 * Ela permite que os usuários acessem o sistema como clientes ou funcionários e
 * também oferece a opção de se cadastrar como cliente.
 */
public class Controler {

    private Cliente user;
    private Funcionario session;
    private ListaCliente listCliente;
    private ListaFuncionario listFuncs;

    /**
     * Construtor da classe Controler.
     * Inicializa a lista de clientes e inicia o sistema.
     */
    public Controler() {
        this.listCliente = new ListaCliente(); // Converter para carregamento de usuarios via arquivo
        this.start();
    }

    /**
     * Inicia o sistema e fornece uma interface de linha de comando para os usuários
     * interagirem com o sistema.
     */
    public void start() {
        Scanner s = new Scanner(System.in);
        int option;
        do {

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
