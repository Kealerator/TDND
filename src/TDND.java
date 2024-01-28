import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;


public class TDND {

    //diceRoller function that actually rolls the dice(s)
    public static int diceRoller(int howMany, int max, int bonus, String bonusType) {
        int finalRoll = 0;
        int currentRoll;

        // the loop rolls a random number from given range
        for (int i = 0; i < howMany; i++) {
            currentRoll = ThreadLocalRandom.current().nextInt(1, max + 1);
            finalRoll = finalRoll + currentRoll;
            System.out.println("roll " + (i + 1) + ": " + currentRoll);
        }

        // if structure to define the bonus factor (plus, minus, none)
        // and adds it to the final roll
        switch (bonusType) {
            case "+" -> {
                System.out.println("Bonus: +" + bonus);
                finalRoll = bonus + finalRoll;
            }
            case "-" -> {
                System.out.println("Bonus: -" + bonus);
                finalRoll = finalRoll - bonus;
            }
            case "none" -> System.out.println("Bonus: none");
        }

        //returning the final roll
        return finalRoll;
    }

    //inputDecipher that splits user's input to roll information
    public static void inputDecipher(String userInput){

        int diceAmount;
        int diceType;
        int bonusVariable = 0;
        String bonusType;

        //if structure to find out which bonus type the input has
        // different .split arguments to separate the bonus value from the dice amount and type
        if (userInput.contains("+")) {
            String[] pieces = userInput.split("[d+]");    // it's easier to just read from input what bonus type
            diceAmount = Integer.parseInt(pieces[0]);           //0 is the number of dice rolls
            diceType = Integer.parseInt(pieces[1]);             //1 is the type of dice (4,6,8,20,12,20,100)
            bonusVariable = Integer.parseInt(pieces[2]);        //2 is the bonus amount
            bonusType = "+";
        } else if (userInput.contains("-")) {                   // the input has "-" so we will substract the bonus
            String[] pieces = userInput.split("[d-]");   // split the bonus, and the dice amount & type
            diceAmount = Integer.parseInt(pieces[0]);          // set the input values to int variables so
            diceType = Integer.parseInt(pieces[1]);            // you can just throw the values to function
            bonusVariable = Integer.parseInt(pieces[2]);
            bonusType = "-";
        } else {
            String[] pieces = userInput.split("d");     // the "[]" are removed because we aren't splitting the
            diceAmount = Integer.parseInt(pieces[0]);         // plus or minus.
            diceType = Integer.parseInt(pieces[1]);
            bonusType = "none";
        }
        System.out.println(diceAmount + "d" + diceType);
        System.out.println("Final roll: " + diceRoller(diceAmount, diceType, bonusVariable, bonusType));
    }

    public static boolean inputValidator(String input) {
        boolean valid = true;
        char dice = 'd';
        char plus = '+';
        char minus = '-';
        int dCount = 0;
        int pCount = 0;
        int mCount = 0;


        //First, check if there is too many characters d, +, or -.
        // d searcher
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == dice) {
                dCount++;
            }
        }
        // + searcher
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == plus) {
                pCount++;
            }
        }
        // - searcher
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == minus) {
                mCount++;
            }
        }

        if (dCount > 1 || pCount > 1 || mCount > 1) {
            valid = false;
        }


        //Second, check if the dice type is correct (d4, d6, d10, d12, d20, d100)
        //but if until now the valid is false, there is no reason to check this.

        if(valid){
            int [] diceTypesAllowed = {4, 6, 8, 10, 12, 20, 100};
            int inputDiceType;
            // Split the input to find out the dice type
            // Had to create a huge if structure to define if there is a "+" or "-"
            if(input.contains("+")) {
                String[] pieces = input.split("[d+]");
                inputDiceType = Integer.parseInt(pieces[1]);
            } else if (input.contains("-")) {
                String[] pieces = input.split("[d-]");
                inputDiceType = Integer.parseInt(pieces[1]);
            } else {
                String[] pieces = input.split("d");
                inputDiceType = Integer.parseInt(pieces[1]);
            }

            for (int j : diceTypesAllowed) {
                if (j != inputDiceType) {
                    valid = false;
                } else {
                    valid = true;
                    break;
                }
            }
        }

        return valid;
    }

    public static void main(String[] args) {
        Scanner UserInput = new Scanner(System.in);

        while (true) {
            // request for user input
            System.out.print("Enter dice amount, and dice type (format '1d6+bonus') :");
            String userInput = UserInput.nextLine();

            if (inputValidator(userInput)) {
                inputDecipher(userInput);
                break;
            } else {
                System.out.println("Incorrect input.");
            }
        }







    }
}
