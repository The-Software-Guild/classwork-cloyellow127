import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SimpleCalculator {

    public static class App{
        App(){
            run();
        }

        public void run(){
            Calculator cal = new Calculator();
            Scanner sc = new Scanner(System.in);
            while(true){
                System.out.println("\nWelcome to Simple Calculator!\n\n Please choose operation (hit \"1\" - \"5\"):\n 1: Addition\n 2: Subtraction\n 3: Multiplication" +
                "\n 4: Division\n 5: Exit program");
                int operation = sc.nextInt();

                if(operation >= 1 && operation <= 4){
                    System.out.println("\nEnter first number.");
                    float num1 = sc.nextFloat();
                    System.out.println("\nEnter second number.");
                    float num2 = sc.nextFloat();
                    cal.set(num1, num2);

                    switch(operation){
                        case 1:
                            System.out.println("\nResult of Addition: " + cal.add());
                            break;
                        case 2:
                            System.out.println("\nResult of Subtraction: " + cal.subtract());
                            break;
                        case 3:
                            System.out.println("\nResult of Multiplication: " + cal.multiply());
                            break;
                        case 4:
                            System.out.println("\nResult of Division: " + cal.divide());
                            break;
                    }
                }
                else if(operation == 5) System.exit(0);
                else System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\nError! Wrong input, try again.");
            }
        }
        
    }

    public static class Calculator{
        private float num1, num2;

        Calculator(){ 
        }

        public ArrayList<Float> get(){
            ArrayList<Float> result = new ArrayList<Float>();
            Collections.addAll(result, num1, num2);
            return result;
        }

        public void set(float num1, float num2){
            this.num1 = num1;
            this.num2 = num2;
        }

        public float add(){
        return num1 + num2; 
        }

        public float subtract(){
            return num1 - num2; 
        }

        public float multiply(){
            return num1 * num2; 
        }

        public float divide(){
            return num1 / num2; 
        }
    }
    

    public static void main(String[] args) {
        App app = new App();
    }
}
