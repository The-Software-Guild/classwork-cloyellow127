import java.text.*;
import java.time.*;
import java.time.format.*;
import java.util.*;


public class Shop {
    // global id
    static long customerId = 1;
    static long productId = 1;

    // decimal formatter
    static NumberFormat formatter = new DecimalFormat("#0.00");

    public static class Customer{
        private long id;
        private String name;
        private ArrayList<Product> shoppingCart;
        private double totalPrice;
        private String checkOutDateTime;

        Customer(){

        }

        Customer(String name){
            id = customerId++;
            this.name = name;
            shoppingCart = new ArrayList<Product>();
            totalPrice = 0;
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

        public int positionInCart(Product product){
            Collections.sort(shoppingCart);
            return Collections.binarySearch(shoppingCart, product);
        }

        public void addToShoppingCart(Product product, int count) {
            int position = positionInCart(product);

            if(position >= 0) shoppingCart.get(position).setCount(shoppingCart.get(position).getCount() + count);
            else {
                product.setCount(count);
                this.shoppingCart.add(product);
            }

            totalPrice += product.getTotalPrice();
        }

        public void removeFromShoppingCart(Product product, int count) {
            int position = positionInCart(product);

            if(position >= 0){
                shoppingCart.get(position).setCount(shoppingCart.get(position).getCount() - count);
                totalPrice -= product.getPrice() * count;
            }
        }

        public double getTotalPrice() {
            return totalPrice;
        }

        public String getCheckOutDateTime() {
            return checkOutDateTime;
        }
        
        public void setCheckOutDateTime() {
            LocalDateTime localDateTime = LocalDateTime.now();
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            checkOutDateTime = dateTimeFormatter.format(localDateTime);
        }
    }

    public static class Product implements Comparable<Product>{
        private long id;
        private String name;
        private double price;
        private int count;
        private double totalPrice;

        Product(String name, double price){
            id = productId++;
            this.name = name;
            this.price = price;
            count = 0;
            totalPrice = 0;
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

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
            setTotalPrice();
        }

        public double getTotalPrice() {
            return totalPrice;
        }

        public void setTotalPrice() {
            totalPrice = price * count;
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
        private double totalRevenue;

        App(){
            productsInStock = new ArrayList<Product>();
            customerRecord = new ArrayList<Customer>();
            totalRevenue = 0;
        }

        public ArrayList<Product> getProductsInStock() {
            return productsInStock;
        }

        public void addProductsToStock(String name, double price) {
            Product product = new Product(name, price);
            this.productsInStock.add(product);
        }

        public void addNewProductToStock(Scanner scan){
            // clear scan buffer
            scan.nextLine();

            viewProductInStock();

            System.out.println("\n****** Enter product name:");
            String name = scan.nextLine();

            System.out.println("\n****** Enter product price:");
            
            if(checkNextDouble(scan, "Wrong input error! Please try again")){
                double price = scan.nextDouble();

                scan.nextLine();

                System.out.println("\n****** Please confirm following product information: \nProduct name: " + 
                name + "\nProduct price: $" + formatter.format(price) + "\n\n****** Type \"add\" to confirm adding this item to stock (or anything else to cancel)******");

                String confirm = scan.nextLine();

                if(confirm.equals("add")){
                    this.addProductsToStock(name, price);
                    System.out.println("\n****** Added: \"" + name + "\" -- $" + formatter.format(price) + " ******");
                }
                else errorMessage("Cancelled");
            }
        }

        public void viewProductInStock(){
            if(productsInStock.size() <= 0){
                System.out.println("\n****** No product in stock at this moment. ******");
            }
            else{
                System.out.println("\n****** Product in stock: ******");
                for(int i = 0; i < productsInStock.size(); i++){
                    System.out.println("\n" + (i + 1) + ". Product ID : " + productsInStock.get(i).getId() + " -- Name: " + productsInStock.get(i).getName() + 
                    " -- Price: $" + formatter.format(productsInStock.get(i).getPrice()));
                }
                System.out.println("\n-------------------------");
            }
        }

        public void removeProductsFromStock(Product product) {
            this.productsInStock.remove(product);
        }

        public void removeProduct(Scanner scan){
            // clear scan buffer
            scan.nextLine();

            viewProductInStock();

            System.out.println("\n****** Enter number to remove product from stock (or anything else to cancel)");
            
            if(checkNextInt(scan, "Cancelled")){
                int number = scan.nextInt();

                if(number >= 1 && number <= productsInStock.size()){
                    Product product = productsInStock.get(number - 1);
                    scan.nextLine();

                    System.out.println("\n****** Please confirm, removing " + product.getName() + " -- $" + formatter.format(product.getPrice()) + 
                    " from stock\n\n****** Type \"remove\" to confirm removing this item to stock (or anything else to cancel)******");

                    String confirm = scan.nextLine();

                    if(confirm.equals("remove")){
                        this.removeProductsFromStock(product);
                        System.out.println("\n****** Removed: \"" + product.getName() + "\" -- $" + formatter.format(product.getPrice()) + " ******");
                    }
                    else errorMessage("Cancelled");
                }
                else errorMessage("Wrong input error! Please try again");
            }
        }

        public void errorMessage(String message){
            System.out.println("\n*************************\n" + message + "\n*************************");
        }

        public void goodBye(){
            System.out.println("\nThanks for shopping! Have a nice day, goodbye :)");
        }

        public void welcome(Scanner scan){
            while(true){
                System.out.println("\n-------------------------\nWelcome to XYZ shop!\n" +  
                "Type command to continue:\n \"ok\": Start shopping \n \"exit\": Exit application\n-------------------------");

                String command = scan.nextLine();

                switch(command){
                    default:
                        errorMessage("Wrong input error! Please try again");
                        break;
                    case "ok":
                        this.newCustomer(scan);
                        this.CustomerOptions(scan);
                        break;
                    case "manager":
                        managerMode(scan);
                        break;
                    case "exit":
                        System.exit(0);
                }
            }
        }

        public void viewTotalRevenue(){
            System.out.println("\n*************************\nTotal revenue: $" + formatter.format(totalRevenue) + "\n*************************");
        }

        public void checkCustomerRecord(){
            if(customerRecord.size() <= 0){
                System.out.println("\n****** No Customer record at this moment. ******");
            }
            else{
                System.out.println("\n-------------------------");
                for(int i = 0; i < customerRecord.size(); i++){
                    System.out.println("\nCustomer ID : " + customerRecord.get(i).getId() + "\nCustomer name: " + customerRecord.get(i).getName() + 
                    "\nDate & time: " + customerRecord.get(i).getCheckOutDateTime());
                    printCart(customerRecord.get(i));
                    System.out.println("\n-------------------------");
                }
            }
        }

        public void managerMode(Scanner scan){
            System.out.println("\n****** Manager mode ******\n");
            boolean run = true;
            while(run){
                System.out.println("\nPress number then enter:");
                System.out.println("1. Check customer record");
                System.out.println("2. Add new item to stock");
                System.out.println("3. Remove existing item from stock");
                System.out.println("4. Check total revenue");
                System.out.println("5. Exit manager mode\n-------------------------");

                if(scan.hasNextInt()){
                    int command = scan.nextInt();
                    switch(command){
                        case 1:
                            checkCustomerRecord();
                            break;
                        case 2:
                            addNewProductToStock(scan);
                            break;
                        case 3:
                            removeProduct(scan);
                            break;
                        case 4:
                            viewTotalRevenue();
                            break;
                        case 5:
                            System.out.println("Exiting manager mode, going back to customer menu...");
                            run = false;
                            break;
                        default:
                            errorMessage("Wrong input error! Please try again");
                            break;
                    }
                }
                else errorMessage("Wrong input error! Please try again");

                // clear scan buffer
                // scan.nextLine();
            }
        }

        public void newCustomer(Scanner scan){
            System.out.println("\n-------------------------\nHello Customer!, please enter your name:\n-------------------------");
            String name = "";
            String[] nameParts = scan.nextLine().split(" ");

            for(int part = 0; part < nameParts.length; part++){
                name += nameParts[part].substring(0, 1).toUpperCase() + nameParts[part].substring(1);
                if(part < nameParts.length - 1) name += " ";
            }

            currentCustomers = new Customer(name);
            System.out.println("\n-------------------------\nHello " + name + "! How may I help you today?");
        }

        public boolean checkOut(Scanner scan){
            System.out.println("\n-------------------------\nShopping cart:");
            if(printCart(currentCustomers)){
                System.out.println("\n****** Please confirm payment ******\n(Type \"pay\" to confirm payment or anything else to cancel.)");

                String confirm = scan.next();

                switch(confirm){
                    default:
                        errorMessage("Payment cancelled.");
                        break;
                    case "pay":
                        currentCustomers.setCheckOutDateTime();
                        customerRecord.add(currentCustomers);
                        totalRevenue += currentCustomers.getTotalPrice();
                        currentCustomers = new Customer();
                        goodBye();
                        return false;
                }
            }
            else errorMessage("Cannot checkout at this moment.");
            return true;
        }

        public void CustomerOptions(Scanner scan){
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
                            run = checkOut(scan);
                            break;
                        case 4:
                            currentCustomers = new Customer();
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
                System.out.println(i + ". " + productsInStock.get(i - 1).getName() + " $" + formatter.format(productsInStock.get(i - 1).getPrice()));
            }

            System.out.println("\nType the number then press enter to add item (Or anything else to cancel)");

            if(checkNextInt(scan, "Cancelled")){
                int productNumber = scan.nextInt();

                if(productNumber >= 1 && productNumber <= productsInStock.size()){
                    System.out.println("\nHow many " + productsInStock.get(productNumber - 1).getName() + "(s) would you like to purchase? (Or anything else to cancel)");

                    if(checkNextInt(scan, "Cancelled")){
                        int times = scan.nextInt();

                        if(times >= 1){
                            currentCustomers.addToShoppingCart(productsInStock.get(productNumber - 1), times);

                            System.out.println("\nAdded " + times + " " + productsInStock.get(productNumber - 1).getName() + " to your cart :)\n-------------------------");
                        }
                        else errorMessage("Wrong input error! Please try again");
                    }
                }
                else errorMessage("Wrong input error! Please try again");
            }
        }

        public boolean printCart(Customer customer){
            if(customer.getShoppingCart().size() == 0){
                System.out.println("Cart Empty! Keep shopping!");

                return false;
            }
            else{
                Collections.sort(customer.getShoppingCart());

                for(int i = 0; i < customer.getShoppingCart().size(); i++){
                    Product product = customer.getShoppingCart().get(i);

                    System.out.println((i + 1) + ". " + product.getName() + "($" + product.getPrice() + ") -- Count: " + product.getCount() + 
                    " -- Total: $" + formatter.format(product.getPrice() * product.getCount()));
                }

                System.out.println("\nGrand Total: $" + formatter.format(customer.getTotalPrice()));

                return true;
            }
        }

        public void removeItem(Scanner scan){
            System.out.println("\n-------------------------\nShopping cart:");
            if(printCart(currentCustomers)){
                System.out.println("\nType the number then press enter to remove item (Or anything else to cancel)");

                if(checkNextInt(scan, "Cancelled")){
                    int productNumber = scan.nextInt();

                    if(productNumber >= 1 && productNumber <= currentCustomers.getShoppingCart().size()){
                        Product product = currentCustomers.getShoppingCart().get(productNumber - 1);

                        System.out.println("\nHow many " + product.getName() + "(s) would you like to remove? Please enter 1 - " + product.getCount() + " (Or anything else to cancel)");

                        if(checkNextInt(scan, "Cancelled")){
                            int times = scan.nextInt();

                            if(times > 0 && times <= product.getCount()){
                                currentCustomers.removeFromShoppingCart(product, times);
                                
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

        public boolean checkNextDouble(Scanner scan, String Message){
            if(scan.hasNextDouble()) return true;
            else{
                errorMessage(Message);
                scan.nextLine();
                return false;
            }
        }

        public double getTotalRevenue() {
            return totalRevenue;
        }
    }

    public static void main(String args[]){
        // create app and add default products
        App app = new App();
        app.addProductsToStock("MacBook Pro", 1699.99);
        app.addProductsToStock("Lenovo ThinkPad", 1099);
        app.addProductsToStock("PlayStation 5", 799.99);
        app.addProductsToStock("Jellyfish", 69.69);
        // run app
        Scanner scan = new Scanner(System.in);
        app.welcome(scan);
    }
}
