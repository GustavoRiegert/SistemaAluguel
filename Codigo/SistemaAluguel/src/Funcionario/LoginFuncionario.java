package Funcionario;

import java.util.Scanner;

public class LoginFuncionario {
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
