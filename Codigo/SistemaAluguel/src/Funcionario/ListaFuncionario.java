package Funcionario;

import java.util.ArrayList;

public class ListaFuncionario {
    ArrayList<Funcionario> funcionarios = new ArrayList<>();

    /**
     * Cria uma lista de funcionários com um funcionário de exemplo (usuário "admin"
     * e senha "admin").
     * Este método é usado para fins de teste.
     */
    public void ListaFuncionario() {
        Funcionario admin = new Funcionario("admin", "admin");
        this.add(admin);
    }

    /**
     * Adiciona um funcionário à lista de funcionários.
     *
     * @param c O funcionário a ser adicionado.
     */
    public void add(Funcionario c) {
        funcionarios.add(c);
    }

    /**
     * Localiza um funcionário na lista pelo nome de usuário.
     *
     * @param user O nome de usuário a ser procurado.
     * @return O funcionário encontrado ou null se nenhum funcionário com o nome de
     *         usuário especificado for encontrado.
     */
    public Funcionario locateByUser(String user) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getUser().equals(user))
                return funcionario;
        }
        return null;
    }
}
