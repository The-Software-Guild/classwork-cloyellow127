import java.util.Scanner;

public class A1_Healthy_hearts {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("What is your age?");
        int age = sc.nextInt();
        int max = 220 - age;
        System.out.println("Your maximum heart rate should be " + max + " beats per minute");
        System.out.println("Your target HR Zone is " + (max / 2) + " - "  + (max * 85 / 100) + " beats per minute");
    }
}
