package Eggercise1;

public class Egg {
//         Exercise 1: Consider user has N eggs. Then display the no of eggs in gross (144 eggs make one gross) and no of eggs in dozen 
//          (12 eggs make one dozen) and the no of eggs that is left out remaining. 
//          The total no of eggs can be got as input from user. The program should display
//           how many gross, how many dozen, and how many left over eggs the user has.
    private int number;
    private int dozen;
    private int dozenRemainder;
    private int gross;
    private int grossRemainder;

    Egg(int number){
        this.number = number;
        setAll();
    }

    public void setNumber(int number) {
        this.number = number;
        setAll();
    }

    protected void setAll(){
        dozen = number / 12;
        dozenRemainder = number % 12;
        gross = number / 144;
        grossRemainder = number % 144;
    }

    public int[] getAll(){
        int[] result = {number, dozen, dozenRemainder, gross, grossRemainder};
        return result;
    }
}
