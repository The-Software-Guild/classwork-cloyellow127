import java.util.Scanner;

public class luckyseven {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("How much $$ do you want to bet?");

        int total_bet = scan.nextInt();
        int highest_bet = total_bet;
        int counter = 0;
        int highest_round = 0;

        while(total_bet > 0){
            int dice1 = 1 + (int)(Math.random() * ((6 - 1) + 1));
            int dice2 = 1 + (int)(Math.random() * ((6 - 1) + 1));
            int total_dice = dice1 + dice2;

            if(total_dice == 7) total_bet += 4;
            else total_bet--;

            if(total_bet >= highest_bet) {
                highest_bet = total_bet;
                highest_round = counter;
            }
            counter ++;
        }

        System.out.println("You are broke after " + counter + " rolls.");
        System.out.println("You should have quit after " + highest_round + " rolls when you had " + highest_bet + ".");

    }
}
