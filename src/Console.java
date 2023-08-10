import java.util.Scanner;

public class Console {
    private static final Scanner scanner = new Scanner(System.in);

    public static String readString(String prompt) {
        String str;

        do {
            System.out.print(prompt);
            str = scanner.next();
        } while (str.isEmpty());

        return str;
    }
}
