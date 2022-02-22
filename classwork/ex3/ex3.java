import java.util.*;
public class ex3 {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            String string_input = scan.nextLine();
            int int_input = scan.nextInt();

            System.out.println(string_input + int_input);
        }
    }
}
