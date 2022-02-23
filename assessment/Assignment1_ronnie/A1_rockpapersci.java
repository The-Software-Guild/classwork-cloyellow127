import java.util.Scanner;

public class A1_rockpapersci{
    public static void main(String args[]){
        // scanner class
        Scanner sc = new Scanner(System.in);

        while(true){
            // play? yes or no
            System.out.println("\nDo you want to play \"ROCK PAPER SCISSORS\"??????????? (yes / no)");
            String response = sc.next();
            if(response.equals("yes")){
                // ask for number of rounds
                System.out.println("\nHow many rounds? (1 - 10)");
                int rounds = sc.nextInt();

                // if out of range, exit
                if((rounds < 1) || (rounds > 10)){
                    System.out.println("Must choose between 1-10, exiting program bye.");
                    System.exit(0);
                }
                // else play game for X rounds.
                else{
                    int win = 0;
                    int lose = 0;
                    int draw = 0;

                    for(int i = 0; i < rounds; i++){
                        System.out.println("\nRound " + (i + 1) + " -------------------------------------------------------------------------");
                        // get rock paper scissors from user, limit input 1 - 3
                        int user_move;
                        do {
                            System.out.println("Choose : 1 = Rock, 2 = Paper, 3 = Scissors");
                            user_move = sc.nextInt();
                        }
                        while((user_move < 1) || (user_move > 3));

                        // random computer move
                        int comp_move = 1 + (int)(Math.random() * ((3 - 1) + 1));

                        // print computer move
                        switch(comp_move){
                            case 1:
                                System.out.println("Computer used Rock.");
                                break;
                            case 2:
                                System.out.println("Computer used Paper.");
                                break;
                            case 3:
                                System.out.println("Computer used Scissors.");
                                break;
                        }
                        
                        // print round result
                        if(user_move == comp_move) {
                            draw++;
                            System.out.println("Result: draw!");
                        }
                        else{
                            if((user_move == 1 && comp_move == 2) || (user_move == 2 && comp_move == 3) || (user_move == 3 && comp_move == 1)){
                                lose++;
                                System.out.println("Result: you lost!");
                            }
                            else{
                                win++;
                                System.out.println("Result: you won!");
                            }
                        }
                    }
                    // print final result
                    System.out.println("\nFinal result");
                    System.out.println("You won " + win + " rounds.");
                    System.out.println("You lost " + lose + " rounds.");
                    System.out.println("You drew " + draw + " rounds.");
                    if(win > lose) System.out.println("You won overall!!!");
                    else if(win == lose) System.out.println("You drew overall!!!");
                    else System.out.println("You lost overall!!!");
                }
            }
            else if(response.equals("no")){
                System.out.println("\nBye.");
                System.exit(0);
            }
            else{
                System.out.println("\nError! Please try again use \"yes\" or \"no\".");
            }   
        }
        
    }
}