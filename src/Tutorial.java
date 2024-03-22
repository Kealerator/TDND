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

        System.out.print("Enter \">\" to proceed: ");
        String userInput = scan.nextLine();
        if (userInput.equals(">")) {
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
                    this.roll.throwDiceNoPrint();

                    System.out.println("Well done! You rolled: " + roll.getFinalRoll());

                    break;
                }
            }
        }

        while (true) {
            System.out.print("\nEnter \">\" to proceed: ");
            String userInput = scan.nextLine();

            if (userInput.equals("X") || userInput.equals("x")) {
                System.out.println("Quit tutorial and go back to main menu? Y/n");
                userInput = scan.nextLine();

                if (userInput.equals("y") || userInput.contains("yes")) {
                    UserInterface MainMenu = new UserInterface(scan);
                    MainMenu.clearTerminal();
                    MainMenu.start();
                    break;
                } else {
                    continue;
                }

            } else if (userInput.equals(">")) {
                diceRollTutorialChallenge1();
                break;
            }
        }

    }

    private void diceRollTutorialChallenge1() {
        ArrayList<Integer> diceRemaining = new ArrayList<>();
        Collections.addAll(diceRemaining, 4, 6, 8, 10, 12, 20, 100);

        String promptMsg = "";

        while (true) {
            TutorialUI.clearTerminal();
            System.out.println("\n\n--- Dice tutorial ---\n");
            System.out.println();
            System.out.println(
                    "So, now that you've thrown your first die. You need to know you can't throw just anything.");
            System.out.println("\nThere are 7 different types of dice.");
            System.out.println("They are:\n");

            for (int diceType : diceRemaining) {
                System.out.println("d" + diceType);
            }

            System.out.println("\nThrow one of each!\n");
            System.out.println();
            System.out.println(promptMsg);

            String userInput = scan.nextLine();

            if (!(inputValidator.diceSyntaxValidator(userInput))) {
                promptMsg = "Invalid input! Try again!";
                continue;
            } else {
                int indexToRemove = diceRemaining.indexOf(inputValidator.getDiceType());
                diceRemaining.remove(indexToRemove);
                inputValidator.diceRollInputDecipher(userInput);
                DiceFunctions newRoll = new DiceFunctions(inputValidator.getDiceAmount(), inputValidator.getDiceType(), inputValidator.getBonusVariable());
                newRoll.throwDiceNoPrint();
                promptMsg = "Good job! Your roll was " + newRoll.getFinalRoll();

                if (diceRemaining.isEmpty()) {
                    promptMsg += "\nThat was all the dice types! Yay!";
                }
            }
        }
    }
}
