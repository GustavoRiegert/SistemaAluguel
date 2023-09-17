import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Controler c = new Controler();
        System.out.println("iniciando...");
        Scanner s = new Scanner(System.in);
        System.out.println(s.nextLine());
        c.start();
    }
}
