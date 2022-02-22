import java.util.Scanner;

public class Interest_Calulator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How much do you want to invest?");
        float amount = sc.nextFloat();
        System.out.println("How many years are investing?");
        int years = sc.nextInt();
        System.out.println("What is the annual interest rate % growth?");
        float interest = sc.nextFloat();

        for(int i = 1; i <= years; i++){
            System.out.println("Year " + i + ":");
            System.out.println("Began with $" + String.format("%.02f", amount));
            System.out.println("Earned $" + String.format("%.02f", amount * interest/100));
            amount += amount * interest/100;
            System.out.println("Ended with $" + String.format("%.02f", amount));
        }
    }
}
