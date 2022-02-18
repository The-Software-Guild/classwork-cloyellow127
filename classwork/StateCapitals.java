import java.util.Collection;
import java.util.HashMap;

public class StateCapitals {
    public static void printState(HashMap<String, String> stateCap){
        String result = "\nSTATES:\n=========";
        for(String state : stateCap.keySet()){
            result += "\n" + state;
        }
        result += "\n...\n...";
        System.out.println(result);
    }

    public static void printCapital(HashMap<String, String> stateCap){
        String result = "\nCapital:\n=========";
        for(String capital : stateCap.values()){
            result += "\n" + capital;
        }
        result += "\n...\n...";
        System.out.println(result);
    }

    public static void printStateCapital(HashMap<String, String> stateCap){
        String result = "\nSTATE/CAPITAL PAIRS:\n====================";
        for(String state : stateCap.keySet()){
            result += "\n" + state + " - " + stateCap.get(state);
        }
        System.out.println(result);
    }
    public static void main(String[] args) {
        String[] states = {"Alabama", "Alaska", "Arizona", "Arkansas"};
        String[] capitals = {"Montgomery", "Juneau", "Phoenix", "Little Rock"};
        HashMap<String, String> stateCap = new HashMap<String, String>();
        for(int i = 0; i < states.length; i++){
            stateCap.put(states[i], capitals[i]);
        }
        printState(stateCap);
        printCapital(stateCap);
        printStateCapital(stateCap);
    }
}
