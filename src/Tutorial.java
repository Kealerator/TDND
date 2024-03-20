import java.util.Scanner;

public class Tutorial {

    private UserInterface TutorialUI;
    private Scanner scan;

    public Tutorial(Scanner scan){
        this.scan = scan;
        this.TutorialUI = new UserInterface(scan);
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

        String userInput = scan.nextLine();

        if (!(TutorialUI.validateRollInput(userInput))) {
            System.out.println("Invalid roll input! Try again.");
        }
    }
}
