public class ReverseExercise{
    public static void main(String args[]){
        try{
            Reverse reverse = new Reverse(Integer.parseInt(args[0]));
            System.out.println(reverse.getReversedNumber());
        }
        catch(Exception e){
            System.out.println("Example usage: java -jar ReverseExercise.jar 1234");
        }
    }
}