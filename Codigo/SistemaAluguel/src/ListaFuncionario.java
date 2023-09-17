import java.util.ArrayList;

public class ListaFuncionario {
    ArrayList<Funcionario> funcionarios = new ArrayList<>();

    // Gerando uma lista com usuario teste admin/admin
    public void ListaFuncionario() {
        Funcionario admin = new Funcionario("admin", "admin");
        this.add(admin);
    }

    public void add(Funcionario c) {
        funcionarios.add(c);
    }

    public Funcionario locateByUser(String user) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getUser().equals(user))
                return funcionario;
        }
        return null;
    }
}
