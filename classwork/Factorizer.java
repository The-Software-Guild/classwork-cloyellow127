import java.util.Scanner;

public class Factorizer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What number would you like to factor?");
        int number = sc.nextInt();
        int count = 0;
        int total = 0;
        System.out.println("The factors of 6 are:");
        for(int i = 1; i <= number; i++){
            if(number % i == 0) {
                System.out.print(i + " ");
                count ++;
                if(i != number) total += i;
            }
        }
        System.out.println("\n" + number + " has " + count + " factors.");
        if(total == number) System.out.println(number + " is a perfect number.");
        else System.out.println(number + " is not a perfect number.");

        if((count == 2) & (number > 1)) System.out.println(number + " is a prime number.");
        else System.out.println(number + " is not a prime number.");
    }
}
