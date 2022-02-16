import java.util.Scanner;

public class A1_Dog_genetics {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("What is your dog's name?");
        String name = sc.nextLine();

        System.out.println("\nWell then, I have this highly reliable report on " + name + "'s prestigious background right here.");

        System.out.println("\n" + name + " is:");
        String[] breeds = {"St.Bernard" , "Chihuahua", "Dramatic RedNosed Asian Pug", "Common Cur", "King Doberman"};

        int max = 100;
        for(int i = 0; i < breeds.length; i++){
            if(max > 0){
                int percent = (int)(Math.random() * ((max) + 1));
                System.out.println(percent + "% " + breeds[i]);
                max -= percent;
            }
            else{
                System.out.println(0 + "% " + breeds[i]);
            }
        }

        System.out.println("\nWow, that's QUITE the dog!");
    }
}
