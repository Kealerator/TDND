import java.util.Scanner;

public class DiceRollerMenu {

    private Scanner scan;
    private UserInterface TextUI;
    private validator inputValidator;

    public DiceRollerMenu(Scanner scan) {
        this.scan = scan;
        this.TextUI = new UserInterface(scan);
        this.inputValidator = new validator();

    }

    public void start() {

        boolean printRoll = false;

        while (true) {
            TextUI.clearTerminal();
            printDiceRollerMenu();

 

            String userInput = scan.nextLine();

            if (inputValidator.isUserQuitting(userInput, scan)) {
                break;
            } else if (userInput.equals("--help") || userInput.equals("-help")) {

                Tutorial tutorial = new Tutorial(scan);
                tutorial.start();
                break;

            } else if (inputValidator.diceSyntaxValidator(userInput)) {

                System.out.println("\n=== Rolling " + userInput + " ===");
                DiceFunctions userInputRoll = new DiceFunctions(userInput, inputValidator);
                userInputRoll.throwDice();
                continue;
            } else {

                System.out.println("Invalid dice parameters.");
                System.out.println("Type '--help' for more information.\n");
                continue;

            }
        }

    }

    private void printDiceRollerMenu() {
        System.out.println("=== Throw a dice ===\n");
        System.out.println("Here, you can simply throw a dice!");
        System.out.println("Enter '--help' for instructions if you need!");
        System.out.println("Enter 'X' to go back to the main menu.\n");
    }
}