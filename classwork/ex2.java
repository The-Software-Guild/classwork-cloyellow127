public class ex2 {
    public static void MoreBucketsMoreFun(){
        // Declare ALL THE THINGS
        // (Usually it's a good idea to declare them at the beginning of the program)
        int butterflies, beetles, bugs;

        // Now give a couple of them some values
        butterflies = 5;
        beetles = 9;

        bugs = butterflies + beetles;
        System.out.println("There are only " + butterflies + " butterflies,");
        System.out.println("but there are " + bugs + " bugs in all.");

        System.out.println("Uh oh, my dog ate one.");
        butterflies--;
        System.out.println("Now there are only " + butterflies + " butterflies left.");
        System.out.println("But there are still " + bugs + " bugs left...");
        System.out.println("Wait a minute!");
        System.out.println("... maybe my computer can't do math, after all!");
    }
    public static void TheOrderOfThings(){
        double number;
        String opinion, size, age, shape, color, origin, material, purpose;
        String noun;

        number = 5.0;
        opinion = "AWESOME";
        size = "teensy-weensy";
        age = "new";
        shape = "oblong";
        color = "yellow";
        origin = "Martian";
        material = "platinum";
        purpose = "good";

        noun = "dragons";

        // Using the + with strings doesn't add -- it concatenates! (sticks them together)
        System.out.println(number + " " + opinion + " " + size + " " + age + " " + shape
                 + " " + color + " " + origin + " " + material + " " + purpose + " " + noun);
    }
    public static void AllAboutMe(){
        String result = "My name is Apple pie.\nMy favorite food is apples.\nI have 0 pets.\nI live in a box.\nIt is false I know how to whistle.";
        System.out.println(result);
    }
    public static void MenuOfChampions(){
        String fancyline = ".oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.\n";
        String welcome = "WELCOME TO RESTAURANT NIGHT VALE!\nToday's Menu Is...\n";
        String Food = "$ 1.50 ***** Denver Omelet\n";
        System.out.println(fancyline + welcome + fancyline + Food + Food + Food);
    }
    public static void BestAdderEver(){
        int one = 1;
        int two = 2;
        int three = 3;
        System.out.println(one + two + three);
    }
    public static void main(String[] args) {
        MoreBucketsMoreFun();
        TheOrderOfThings();
        AllAboutMe();
        MenuOfChampions();
        BestAdderEver();
    }
}
