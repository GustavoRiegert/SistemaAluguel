package Funcionario;

import java.util.Scanner;

public class LoginFuncionario {

    /**
     * Classe View para realizar o login de um funcionario.
     *
     * @param lista a lista de funcionarios cujo qual sera localizado as credenciais
     *              de
     *              login
     * @return O funcionario logado com as credenciais confirmadas ou null se nenhum
     *         cliente for logado
     */
    public static Funcionario login(ListaFuncionario lista) {
        Scanner s = new Scanner(System.in);
        System.out.println("Digite o usuario");
        String user = s.nextLine();
        Funcionario func = lista.locateByUser(user);
        System.out.println("Digite a senha");
        String password = s.nextLine();
        if (func.verificarSenha(password))
            return func;
        else
            System.out.println("Usuario ou senha incorretos");
        return null;
    }
}
