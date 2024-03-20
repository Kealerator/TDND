import java.util.Scanner;

public class Tutorial {

    private UserInterface TutorialUI;
    private Scanner scan;
    private validator inputValidator;

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
                } else {

                    System.out.println("Well done! You rolled:\n");
                    TutorialUI.diceRoll(userInput, inputValidator);
                    continue;
                }
            }
        }
    }
}
