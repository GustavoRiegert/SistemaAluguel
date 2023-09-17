package Funcionario;

import java.util.ArrayList;

public class Funcionario {

    private String usuario, senha;

    /**
     * Construtor da classe Funcionario, tendo o usuario e senha.
     *
     * @param user     O nome de usuário do funcionário.
     * @param password A senha do funcionário.
     */
    public Funcionario(String user, String password) {
        this.usuario = user;
        this.senha = password;
    }

    /**
     * Obtém o nome de usuário do funcionário.
     *
     * @return O nome de usuário do funcionário.
     */
    public String getUser() {
        return this.usuario;
    }

    /**
     * Verifica se a senha fornecida corresponde à senha do funcionário.
     *
     * @param password A senha a ser verificada.
     * @return true se a senha fornecida corresponde à senha do funcionário, caso
     *         contrário, false.
     */
    public boolean verificarSenha(String password) {
        return password.equals(this.senha);
    }

}
