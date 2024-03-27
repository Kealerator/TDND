import java.util.Scanner;

public class DiceRollerMenu {

    private Scanner scan;
    private UserInterface TextUI;
    private validator inputValidator;

    public DiceRollerMenu(Scanner scan) {
        this.scan = scan;
        this.TextUI = new UserInterface(scan);


    }

    public void start() {
        DiceFunctions userInputRoll = new DiceFunctions();
        boolean diceRolled = false;
        boolean errorPrompt = false;
        String previousUserInput = "";

        while (true) {
            this.inputValidator = new validator();
            TextUI.clearTerminal();
            printDiceRollerMenu();

            if (diceRolled) {
                printRollLog(previousUserInput, userInputRoll);
            }
            if (errorPrompt) {
                errorMsg();
            }

            String userInput = scan.nextLine();

            if (userInput.equals("--help") || userInput.equals("-help")) {

                Tutorial tutorial = new Tutorial(scan);
                tutorial.start();
                break;

            } else if (inputValidator.diceSyntaxValidator(userInput)) {
                errorPrompt = false;
                diceRolled = true;
                previousUserInput = userInput;

                userInputRoll = new DiceFunctions(userInput, inputValidator);
                userInputRoll.throwDice();
                continue;
            } else {

                if (inputValidator.isUserQuitting(userInput, scan)) {
                    break;
                } else {
                    if (inputValidator.isCancelled()) {
                        diceRolled = false;
                        errorPrompt = false;
                    } else {
                        diceRolled = false;
                        errorPrompt = true;
                    }

                }

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

    private void printRollLog(String userInput, DiceFunctions diceFunctions) {

        System.out.println(diceFunctions.getRollLog());
    }

    private void errorMsg() {
        System.out.println("Invalid dice parameters.");
        System.out.println("Type '--help' for more information.\n");
    }

}