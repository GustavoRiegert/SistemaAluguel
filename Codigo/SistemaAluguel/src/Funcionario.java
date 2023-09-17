import java.util.ArrayList;

public class Funcionario {

    private String usuario, senha;

    public Funcionario(String user, String password) {
        this.usuario = user;
        this.senha = password;
    }

    public String getUser() {
        return this.usuario;
    }

    public boolean verificarSenha(String password) {
        return password.equals(this.senha);
    }

}
