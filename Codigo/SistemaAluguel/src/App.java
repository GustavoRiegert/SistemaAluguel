import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("iniciando...");
        Scanner s = new Scanner(System.in);
        System.out.println(s.nextLine());
        s.close();
        Controler c = new Controler();
        c.start();

    }
}