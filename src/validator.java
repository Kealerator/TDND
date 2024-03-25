import java.util.Scanner;
import java.util.regex.Pattern;

public class validator {
    private int diceAmount;
    private int diceType;
    private int bonusVariable = 0;
    private String bonusType;
    private String input;

    public validator() {

    }

    public boolean diceSyntaxValidator(String input) {

        /*
         * Trail of thought:
         * 1. Check if there is a number before and after 'd'
         * 2. If there is a number before and after 'd', check how many 'd', '+' and '-'
         * there are
         * 3. If there is a number before and after, and there is no extra 'd','+' or
         * '-', check if there
         * is a die type after the 'd'.
         * 4. Check if the die type is correct from int Array list of approved die
         * sizes.
         * 
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
            if (pieces.length > 1) {
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
        if (valid) {

            if (input.contains("+")) {
                String[] pieces = input.split("[d+]");
                if (pieces[1].isEmpty()) {
                    valid = false;
                }
            } else if (input.contains("-")) {
                String[] pieces = input.split("[d-]");
                if (pieces[1].isEmpty()) {
                    valid = false;
                }
            } else {
                String[] pieces = input.split("d");
                if (pieces[1].isEmpty()) {
                    valid = false;
                }
            }

        }

        // Fourth, check if the dice type is correct (d4, d6, d10, d12, d20, d100)
        // until now if the valid is false, there is no reason to check this.

        if (valid) {
            int[] diceTypesAllowed = { 4, 6, 8, 10, 12, 20, 100 };

            // Split the input to find out the dice type
            // Had to create a huge if structure to define if there is a "+" or "-"
            if (input.contains("+")) {
                String[] pieces = input.split("[d+]");
                this.diceType = Integer.parseInt(pieces[1]);
            } else if (input.contains("-")) {
                String[] pieces = input.split("[d-]");
                this.diceType = Integer.parseInt(pieces[1]);
            } else {
                String[] pieces = input.split("d");
                this.diceType = Integer.parseInt(pieces[1]);
            }

            for (int j : diceTypesAllowed) {
                if (j != this.diceType) {
                    valid = false;
                } else {
                    valid = true;
                    break;
                }
            }
        }

        return valid;
    }

    public void diceRollInputDecipher(String input) {

        // if structure to find out which bonus type the input has
        // different .split arguments to separate the bonus value from the dice amount
        // and type
        if (input.contains("+")) {
            String[] pieces = input.split("[d+]"); // it's easier to just read from input what bonus type
            if (pieces[0].isEmpty()) {
                pieces[0] = "1";
            }
            this.diceAmount = Integer.parseInt(pieces[0]); // 0 is the number of dice rolls
            this.diceType = Integer.parseInt(pieces[1]); // 1 is the type of dice (4,6,8,20,12,20,100)
            this.bonusVariable = Integer.parseInt(pieces[2]); // 2 is the bonus amount
            this.bonusType = "+";
        } else if (input.contains("-")) { // the input has "-" so we will subtract the bonus
            String[] pieces = input.split("[d-]"); // split the bonus, and the dice amount & type
            if (pieces[0].isEmpty()) {
                pieces[0] = "1";
            }
            this.diceAmount = Integer.parseInt(pieces[0]); // set the input values to int variables so
            this.diceType = Integer.parseInt(pieces[1]); // you can just throw the values to function
            this.bonusVariable = Integer.parseInt(pieces[2]);
            this.bonusType = "-";
        } else {
            String[] pieces = input.split("d"); // the "[]" are removed because we aren't splitting the plus or minus
            if (pieces[0].isEmpty()) {
                pieces[0] = "1";
            }
            this.diceAmount = Integer.parseInt(pieces[0]);
            this.diceType = Integer.parseInt(pieces[1]);
            this.bonusType = "none";
        }

        if (this.bonusType.equals("-")) {
            this.bonusVariable = this.bonusVariable * -1;
        }
    }

    public boolean isUserQuitting(String input, Scanner scan) {
        this.input = input;

        if (this.input.equalsIgnoreCase("X")) {
            while (true) {
                System.out.print("\n\nQuit to main menu? Y/n: ");
                this.input = scan.nextLine();
                if (this.input.equalsIgnoreCase("y") || this.input.equalsIgnoreCase("yes")) {
                    return true;
                } else if (this.input.equalsIgnoreCase("n") || this.input.equalsIgnoreCase("no")) {
                    return false;
                } else {
                    continue;
                }
            }   
        } else {
            return false;
        }
    }

    public int getDiceAmount() {
        return this.diceAmount;
    }

    public int getDiceType() {
        return this.diceType;
    }

    public int getBonusVariable() {
        return this.bonusVariable;
    }

    public String getBonusType() {
        return this.bonusType;
    }

    public String getUserInput() {
        return input;
    }

    public String toString() {
        return "Validator deciphered: " + this.diceAmount + "d" + this.diceType + this.bonusType + this.bonusVariable;
    }
}
