package Eggercise1;

public class Main{
    public static void main(String args[]){
        try{
            Egg egg = new Egg(Integer.parseInt(args[0]));
            int[] result = egg.getAll();
            System.out.println("Number of eggs: " + result[0] + 
                                "\nNumber of dozens: " + result[1] +
                                "\nDozen remainder: " + result[2] +
                                "\nNumber of gross: " + result[3] +
                                "\nGross remainder: " + result[4]);
        }
        catch(Exception e){
            System.out.println("Error");
        }
    }
}