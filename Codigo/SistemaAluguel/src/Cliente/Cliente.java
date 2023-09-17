package Cliente;

public class Cliente {
    private String senha, usuario;

    /**
     * Construtor da classe Cliente contendo usuario e senha.
     *
     * @param user     O nome de usuário do cliente.
     * @param password A senha do cliente.
     */
    public Cliente(String user, String password) {
        this.usuario = user;
        this.senha = password;
    }

    /**
     * Verifica se a senha fornecida corresponde à senha do cliente.
     *
     * @param s A senha a ser verificada.
     * @return true se a senha fornecida corresponde à senha do cliente, caso
     *         contrário, false.
     */
    public boolean verificarSenha(String s) {
        return senha.equals(s);
    }

    /**
     * Obtém o nome de usuário do cliente.
     *
     * @return O nome de usuário do cliente.
     */
    public String getUser() {
        return this.usuario;
    }
}
