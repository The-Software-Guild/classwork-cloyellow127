import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Shop {
    // global id
    static long customerId = 1;
    static long productId = 1;

    public static class Customer{
        private long id;
        private String name;
        private ArrayList<Product> shoppingCart;

        Customer(){

        }

        Customer(String name){
            id = customerId++;
            this.name = name;
            shoppingCart = new ArrayList<Product>();
        }

        public long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public ArrayList<Product> getShoppingCart() {
            return shoppingCart;
        }

        public void addToShoppingCart(Product product) {
            this.shoppingCart.add(product);
        }

        public void removeFromShoppingCart(Product product) {
            this.shoppingCart.remove(product);
        }

        public int count(Product product){
            int count = 0;
            for(int i = 0; i < shoppingCart.size(); i++) {
                if(product == shoppingCart.get(i)) count++;
            }
            return count;
        }
    }

    public static class Product implements Comparable<Product>{
        private long id;
        private String name;
        private double price;

        Product(String name, double price){
            id = productId++;
            this.name = name;
            this.price = price;
        }

        public long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        @Override
        public int compareTo(Product product) {
            if(this.getId() == product.getId()) return 0;
            else if(this.getId() > product.getId()) return 1;
            else return -1;
        }
    }

    public static class App{
        private ArrayList<Product> productsInStock;
        private ArrayList<Customer> customerRecord;
        private Customer currentCustomers;

        App(){
            productsInStock = new ArrayList<Product>();
            customerRecord = new ArrayList<Customer>();
        }

        public ArrayList<Product> getProductsInStock() {
            return productsInStock;
        }

        public void addProductsToStock(String name, double price) {
            Product product = new Product(name, price);
            this.productsInStock.add(product);
        }

        public void removeProductsFromStock(Product product) {
            this.productsInStock.remove(product);
        }

        public void errorMessage(String message){
            System.out.println("\n*************************\n" + message + "\n*************************");
        }

        public void goodBye(){
            System.out.println("\nThank you, goodbye :)");
        }

        public void Welcome(Scanner scan){
            while(true){
                System.out.println("\n-------------------------\nWelcome to XYZ shop!\n" +  
                "Type command to continue:\n \"go\": Start shopping \n \"exit\": Exit application\n-------------------------");

                String command = scan.nextLine();

                switch(command){
                    default:
                        errorMessage("Wrong input error! Please try again");
                        break;
                    case "go":
                        this.newCustomer(scan);
                        this.seeOptions(scan);
                        break;
                    case "exit":
                        System.exit(0);
                }
            }
        }

        public void newCustomer(Scanner scan){
            System.out.println("\n-------------------------\nHello Customer!, please enter your name:\n-------------------------");
            String name = scan.nextLine();
            name = name.substring(0, 1).toUpperCase() + name.substring(1);
            currentCustomers = new Customer(name);
            System.out.println("\n-------------------------\nHello " + name + "! How may I help you today?");
        }

        public void seeOptions(Scanner scan){
            boolean run = true;
            while(run){
                System.out.println("\nPress number then enter:");
                System.out.println("1. Add item");
                System.out.println("2. remove item");
                System.out.println("3. Check out");
                System.out.println("4. Discard\n-------------------------");

                if(scan.hasNextInt()){
                    int command = scan.nextInt();
                    switch(command){
                        case 1:
                            addItem(scan);
                            break;
                        case 2:
                            removeItem(scan);
                            break;
                        case 3:
                            break;
                        case 4:
                            run = false;
                            goodBye();
                            break;
                        default:
                            errorMessage("Wrong input error! Please try again");
                            break;

                    }
                }
                else{
                    errorMessage("Wrong input error! Please try again"); 
                }
                // clear scan buffer
                scan.nextLine();
            }
        }

        public void addItem(Scanner scan){
            System.out.println("\n-------------------------\nProducts:");
            for(int i = 1; i <= productsInStock.size(); i++){
                System.out.println(i + ". " + productsInStock.get(i - 1).getName() + " $" + productsInStock.get(i - 1).getPrice());
            }

            System.out.println("\nType the number then press enter to add item (Or anything else to cancel)");
            if(checkNextInt(scan, "Cancelled")){
                int productNumber = scan.nextInt();
                if(productNumber >= 1 && productNumber <= productsInStock.size()){
                    System.out.println("\nHow many " + productsInStock.get(productNumber - 1).getName() + "(s) would you like to purchase? (Or anything else to cancel)");
                    if(checkNextInt(scan, "Cancelled")){
                        int times = scan.nextInt();
                        if(times >= 1){
                            for(int i = 0; i < times; i++){
                                currentCustomers.addToShoppingCart(productsInStock.get(productNumber - 1));
                            }
                            System.out.println("\nAdded " + times + " " + productsInStock.get(productNumber - 1).getName() + " to your cart :)\n-------------------------");
                        }
                        else errorMessage("Wrong input error! Please try again");
                    }
                }
                else errorMessage("Wrong input error! Please try again");
            }
        }

        public void removeItem(Scanner scan){
            System.out.println("\n-------------------------\nIn cart:");
            int index = 0;

            if(currentCustomers.getShoppingCart().size() == 0) System.out.println("Cart Empty! Keep shopping!");
            else{
                Collections.sort(currentCustomers.getShoppingCart());
                index = 1;
                for(int i = 0; i < currentCustomers.getShoppingCart().size(); i += 0){
                    Product product = currentCustomers.getShoppingCart().get(i);
                    System.out.println(index + ". " + product.getName() + " -- Count: " + currentCustomers.count(product));
                    index ++;
                    i += currentCustomers.count(product);
                }
                System.out.println("\nType the number then press enter to remove item (Or anything else to cancel)");
                if(checkNextInt(scan, "Cancelled")){
                    int productNumber = scan.nextInt();
                    if(productNumber >= 1 && productNumber <= index - 1){
                        Product product = productsInStock.get(productNumber - 1);
                        System.out.println("\nHow many " + product.getName() + "(s) would you like to remove? Please enter 1 - " + currentCustomers.count(product) + " (Or anything else to cancel)");
                        if(checkNextInt(scan, "Cancelled")){
                            int times = scan.nextInt();
                            if(times > 0 && times <= currentCustomers.count(product)){
                                for(int i = 0; i < times; i++){
                                    currentCustomers.removeFromShoppingCart(product);
                                }
                                System.out.println("\nRemoved " + times + " " + product.getName() + " from your cart :)\n-------------------------");
                            }
                            else errorMessage("Cancelled");
                        }
                    }
                    else errorMessage("Cancelled");
                }
            }
        }

        public boolean checkNextInt(Scanner scan, String Message){
            if(scan.hasNextInt()) return true;
            else{
                errorMessage(Message);
                scan.nextLine();
                return false;
            }
        }
    }

    public static void main(String args[]){
        // create app and add products
        App app = new App();
        app.addProductsToStock("Macbook Pro", 1699);
        app.addProductsToStock("Lenovo thinkpad", 1099);
        app.addProductsToStock("Playstation 5", 800);
        app.addProductsToStock("Jellyfish", 69);

        // run app
        Scanner scan = new Scanner(System.in);
        app.Welcome(scan);
    }
}
