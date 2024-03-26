import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Tutorial {

    private UserInterface TutorialUI;
    private Scanner scan;
    private validator inputValidator;
    private DiceFunctions roll;

    public Tutorial(Scanner scan) {
        this.scan = scan;
        this.TutorialUI = new UserInterface(scan);
        this.inputValidator = new validator();
    }

    public void start() {
        this.TutorialUI.clearTerminal();

        TutorialMenu();
    }

    private void TutorialMenu() {
        TutorialUI.clearTerminal();
        System.out.println("\n\n--- Welcome to dice tutorial! ---\n");
        System.out.println("The format to throw, is simply put [dice amount] d <dice type>.");
        System.out.println("i.e. entering '2d6' would throw 2 pieces of 6 sided dice!\n\n");
        System.out.println(
                "Psst! \"Dice\" is the plural form of \"die.\" \"Dice\" is sometimes used to refer to a singular die. "
                        +
                        "\n\nIf you want to play it safe: Use \"dice\" if you are rolling two or more game pieces.\nUse \"die\", if you are only using one piece.");

        if (permissionToProceed()) {
            diceRollTutorialChallenges();
        }
    }

    private void diceRollTutorialChallenges() {
        diceRollTutorialChallenge0();
    }

    private void diceRollTutorialChallenge0() {
        TutorialUI.clearTerminal();
        System.out.println("\n\n--- Dice tutorial ---\n");

        System.out.println("Well, shall we start by throwing a die.");
        System.out.println("Simply enter 'd6'.\n");

        while (true) {
            String userInput = scan.nextLine();

            if (!(inputValidator.diceSyntaxValidator(userInput))) {
                System.out.println("Invalid roll input! Try again.");
                continue;
            } else {

                inputValidator.diceRollInputDecipher(userInput);

                if (inputValidator.getDiceType() != 6) {
                    System.out.println("Hmm... Doesn't seem like a d6 to me! Try again.");
                    continue;
                } else if (inputValidator.getDiceAmount() > 1) {
                    System.out.println("I mean.. It's the right die, you just wanted to throw more than one!");
                } else if (inputValidator.getBonusType().equals("+") || inputValidator.getBonusType().equals("-")) {
                    System.out.println("Errrmm... No need for that yet!");
                } else {

                    this.roll = new DiceFunctions(1, 6, 0);
                    this.roll.throwDiceNoLog();

                    System.out.println("Well done! You rolled: " + roll.getFinalRoll());

                    break;
                }
            }
        }

        if (permissionToProceed()) {
            diceRollTutorialChallenge1();
        }
    }

    private void diceRollTutorialChallenge1() {
        ArrayList<String> diceRemaining = new ArrayList<>();
        Collections.addAll(diceRemaining, "d4", "d6", "d8", "d10", "d12", "d20", "d100");

        String promptMsg = "";
        boolean exit = false;

        while (true) {
            TutorialUI.clearTerminal();
            System.out.println("\n\n--- Dice tutorial ---\n");
            System.out.println();
            System.out.println(
                    "So, now that you've thrown your first die. You need to know that you can't throw just anything.");
            System.out.println("\nThere are 7 different types of dice.");
            System.out.println("They are:\n");

            for (String diceType : diceRemaining) {
                System.out.println(diceType);
            }

            System.out.println("\nThrow atleast one of each die type!\n");

            if (exit) {
                System.out.println(promptMsg);
                break;
            }
            System.out.println(promptMsg);

            String userInput = scan.nextLine();

            if (!(inputValidator.diceSyntaxValidator(userInput))) {
                promptMsg = "Invalid input! Try again!";
                continue;
            } else if (!(diceRemaining.contains("d" + inputValidator.getDiceType()))) {
                promptMsg = "You've already thrown that dice type!";
                continue;
            } else {
                int indexToRemove = diceRemaining.indexOf("d" + String.valueOf(inputValidator.getDiceType()));
                diceRemaining.set(indexToRemove, " ");

                inputValidator.diceRollInputDecipher(userInput);
                DiceFunctions newRoll = new DiceFunctions(userInput, inputValidator);
                newRoll.throwDiceNoLog();
                promptMsg = "Good job! Your roll was " + newRoll.getFinalRoll();

                if (checkDiceRemainingListIsFilledWithSpaces(diceRemaining)) {
                    promptMsg += "\nThat was all the dice types! Yay!";
                    exit = true;
                }
                continue;
            }
        }

        if (permissionToProceed()) {
            diceRollTutorialMultipleDiceInfo();
        }

    }

    public void diceRollTutorialMultipleDiceInfo() {
        TutorialUI.clearTerminal();
        System.out.println("\n\n--- Dice tutorial ---\n");
        System.out.println("Throwing dice is fun, specially if you throw more than one!");
        System.out.println("You can actually more than one die, but only one type!");
        System.out.println("\nFor an example, you can throw three pieces of 6 sided dices in a single roll.");
        System.out.println("But you cannot roll one 6 sided, and one 8 sided die in one roll.");

        System.out.println("\n\"2d6\" = allowed");
        System.out.println("\"1d6&1d8\" = NOT allowed");

        if (permissionToProceed()) {
            diceRollTutorialChallenge2();
        }
    }

    private boolean permissionToProceed() {
        while (true) {
            System.out.print("\n\nEnter \">\" to proceed: ");
            String userInput = scan.nextLine();

            if (inputValidator.isUserQuitting(userInput, scan)) {
                TutorialUI.clearTerminal();
                TutorialMenu();
                break;
            }

            if (userInput.equals(">")) {
                return true;
            } else if (userInput.equalsIgnoreCase("X")) {
                System.out.print("Quit to main menu? Y/n: ");
                userInput = scan.nextLine();

                if (userInput.equalsIgnoreCase("y") || userInput.equalsIgnoreCase("yes")) {
                    TutorialUI.clearTerminal();
                    TutorialUI.mainMenu();
                    return false;
                } else {
                    continue;
                }
            }
        }
    }

    private void diceRollTutorialChallenge2() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'diceRollTutorialChallenge2'");
    }

    private boolean checkDiceRemainingListIsFilledWithSpaces(ArrayList<String> list) {
        int match = 0;
        for (String listElement : list) {
            if (listElement.equals(" ")) {
                match++;
            }
        }

        if (match == list.size()) {
            return true;
        } else {
            return false;
        }
    }
}
