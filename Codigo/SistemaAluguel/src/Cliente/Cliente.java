package Cliente;

public class Cliente {
    private String senha, usuario;

    public boolean verificarSenha(String s) {
        return senha.equals(s);
    }

    public Cliente(String user, String password) {
        this.usuario = user;
        this.senha = password;
    }

    public String getUser() {
        return this.usuario;
    }
}
