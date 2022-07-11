import java.util.Scanner;

public class LostBracket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String formula = sc.next();
        String[] commands = formula.replaceAll("[0-9]","").split("");
        String[] numbers = formula.split("[-+]");

    }
}
