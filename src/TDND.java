import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Pattern;

public class TDND {




   public static int[] diceRollReport = new int[5];
   /*

   diceRollReport syntax:
   0 = dice amount
   1 = dice type
   2 = bonus type & amount
   3 = current roll
   4 = final roll

   */



    public static void main(String[] args) {

        diceInputRequest();
        //printDiceRollReport();

        //allowedDiesInputSpammer();

    }


    //input spammer that just really is spamming all kinds of inputs.
    
    public static void allowedDiesInputSpammer(){

        int[] diceTypesAllowed = {4, 6, 8, 10, 12, 20, 100};


        for (int i = 0; i < 2; i++) {                                   //dice amount
            for (int j = 0; j < diceTypesAllowed.length; j++) {         //dice type
                for (int k = -2; k < 3; k++) {                          //bonus type and amount
                    
                    String spamInput = "";


                    //generate spamInput piece by piece

                    if (i > 1) {
                        spamInput = spamInput + String.valueOf(i);              // 0d6 and 1d6 becomes d6 and d6
                    }

                    spamInput = spamInput + "d" + diceTypesAllowed[j];          // generates 'd' and dicetype i.e. d20

                    if (k > 0) {                                                // bonus related bs
                        spamInput = spamInput + "+" + k;                        // generates '+' and bonus type i.e. +2
                    } else if (k == 0) {
                        spamInput = spamInput;
                    } else {
                        spamInput = spamInput + String.valueOf(k);
                    }

                    System.out.println("Input : " + spamInput);

                    if (inputValidator(spamInput)) {
                        inputDecipher(spamInput);                                            
                    } else {
                        System.out.println("Incorrect input.");
                    }
                    

                }
            }
        }

    }


    //user input request has an own method now
    public static void diceInputRequest(){
        try (Scanner UserInput = new Scanner(System.in)) {
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

    //diceRoller function that actually rolls the dice(s)
    public static void diceRoller(int howMany, int max, int bonus, String bonusType) {
        int finalRoll = 0;
        int currentRoll = 0;

        // initialize dicerollReport

        for (int i = 0; i < diceRollReport.length; i++) {
            diceRollReport[i] = 0;
        }
        


        /*

        diceRollReport syntax:
        0 = dice amount
        1 = dice type
        2 = bonus type & amount
        3 = current roll
        4 = final roll
     
        */

    
        // the loop rolls a random number from given range
        for (int i = 0; i < howMany; i++) {
            currentRoll = ThreadLocalRandom.current().nextInt(1, max + 1);
            finalRoll = finalRoll + currentRoll;
            diceRollReport[3] = currentRoll;

            printDiceRoll(i, howMany);
        }

        // if structure to define the bonus factor (plus, minus, none)
        // and adds it to the final roll
        switch (bonusType) {
            case "+" : {
                finalRoll = bonus + finalRoll;
                diceRollReport[2] = bonus;
                break;
            }
            case "-" : {
                finalRoll = finalRoll - bonus;
                diceRollReport[2] = bonus * -1;
                break;
            }
            case "none" : {
                break;
            }
        }

        if (finalRoll < 1) {
            finalRoll = 1;
        }

        //log the final roll
        diceRollReport[4] = finalRoll;

        printDiceFinalRoll();

    }

    public static void printDiceRoll(int count, int howMany){

        /*

        diceRollReport syntax:
        0 = dice amount
        1 = dice type
        2 = bonus type & amount
        3 = current roll
        4 = final roll
     
        */

        if (howMany > 1) {
            System.out.println("Roll #" + (count + 1) + ":" + diceRollReport[3]);
        } else {
            System.out.println("Roll: " + diceRollReport[3]);
        }


    }

    public static void printDiceFinalRoll(){


        /*

        diceRollReport syntax:
        0 = dice amount
        1 = dice type
        2 = bonus type & amount
        3 = current roll
        4 = final roll
     
        */


        if(diceRollReport[2] > 0){
            System.out.println("Bonus: +" + diceRollReport[2]);
        } else {
            System.out.println("Bonus: " + diceRollReport[2]);
        }  

        System.out.println("Final roll: " + diceRollReport[4]);

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
                if (pieces[0].isEmpty()){
                    pieces[0] = "1";
                }
            diceAmount = Integer.parseInt(pieces[0]);           //0 is the number of dice rolls
            diceType = Integer.parseInt(pieces[1]);             //1 is the type of dice (4,6,8,20,12,20,100)
            bonusVariable = Integer.parseInt(pieces[2]);        //2 is the bonus amount
            bonusType = "+";
        } else if (userInput.contains("-")) {                   // the input has "-" so we will subtract the bonus
            String[] pieces = userInput.split("[d-]");   // split the bonus, and the dice amount & type
                if (pieces[0].isEmpty()){
                    pieces[0] = "1";
                }
            diceAmount = Integer.parseInt(pieces[0]);          // set the input values to int variables so
            diceType = Integer.parseInt(pieces[1]);            // you can just throw the values to function
            bonusVariable = Integer.parseInt(pieces[2]);
            bonusType = "-";
        } else {
            String[] pieces = userInput.split("d");     // the "[]" are removed because we aren't splitting the
                if (pieces[0].isEmpty()){
                    pieces[0] = "1";
                }
            diceAmount = Integer.parseInt(pieces[0]);         // plus or minus.
            diceType = Integer.parseInt(pieces[1]);
            bonusType = "none";
        }

        diceRoller(diceAmount, diceType, bonusVariable, bonusType);
    }

    //validates if the input going to diceRoller function is in correct syntax
    public static boolean inputValidator(String input) {

        /*
                Trail of thought:
                    1. Check if there is a number before and after 'd'
                    2. If there is a number before and after 'd', check how many 'd', '+' and '-' there are
                    3. If there is a number before and after, and there is no extra 'd','+' or '-', check if there
                        is a die type after the 'd'.
                    4. Check if the die type is correct from int Array list of approved die sizes.

         */


        boolean valid = true;
        char dice = 'd';
        char plus = '+';
        char minus = '-';
        int dCount = 0;
        int pCount = 0;
        int mCount = 0;


        // First, scan user input string if there is any numbers before and after 'd'
            if (input.contains("d")) {
                String[] pieces = input.split("d");
                if (Pattern.matches("[a-z A-Z]+", pieces[0])) {
                    valid = false;
                }
                if (pieces.length > 1){
                    if (Pattern.matches("[a-zA-Z]+", pieces[1])) {
                        valid = false;
                    }
            }
        }

        // Second, check if there is too many characters d, +, or -.
        // d searcher
        if (valid) {
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
            if (dCount == 0 && pCount == 0 && mCount == 0) {
                valid = false;
            }
        }

        // Third, we need to check if there even is a die type
        // until now if the valid is false, there is no reason to check this.
        if (valid){

            if(input.contains("+")) {
                String[] pieces = input.split("[d+]");
                if (pieces[1].isEmpty()){
                    valid = false;
                }
            } else if (input.contains("-")) {
                String[] pieces = input.split("[d-]");
                if (pieces[1].isEmpty()){
                    valid = false;
                }
            } else {
                String[] pieces = input.split("d");
                if (pieces[1].isEmpty()){
                    valid = false;
                }
            }

        }


        //Fourth, check if the dice type is correct (d4, d6, d10, d12, d20, d100)
        //until now if the valid is false, there is no reason to check this.

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

}
