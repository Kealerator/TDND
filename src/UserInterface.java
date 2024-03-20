import java.util.Scanner;

public class UserInterface {

    private Scanner scan;
    private validator inputValidator = new validator();

    public UserInterface(Scanner scan) {
        this.scan = scan;
    }

    public void start() {

        while (true) {
            System.out.println("=== Main menu ===");
            System.out.println("1. Throw a dice");
            System.out.println("X. Quit");
            System.out.println();
            System.out.print("Select: ");
            String userInput = scan.nextLine();

            if (userInput.equals("X") || userInput.equals("x")) {
                System.out.println("\n\n=== Quit? ===");
                System.out.print("y/n : ");
                userInput = scan.nextLine();
                if (userInput.contains("y") || userInput.contains("yes")) {
                    System.out.println("\nBye!");
                    break;
                } else {
                    continue;
                }
            } else {
                inputProcessor(userInput);
                continue;
            }
        }
    }

    private void inputProcessor(String userInput) {
        if (userInput.equals("1")) {
            diceRollMenu();
        }
    }

    public void diceRollMenu() {
        clearTerminal();
        System.out.println("=== Throw a dice ===\n");
        System.out.println("Here, you can simply throw a dice!");
        System.out.println("Enter '--help' for instructions if you need!");
        System.out.println("Enter 'X' to go back to the main menu.\n");

        while (true) {
            String userInput = scan.nextLine();

            if (userInput.equals("X") || userInput.equals("x")) {

                System.out.println("Back to menu!\n");

                break;

            } else if (userInput.equals("--help") || userInput.equals("-help")) {

                Tutorial tutorial = new Tutorial(scan);
                tutorial.start();

            } else if (inputValidator.diceSyntaxValidator(userInput)) {

                System.out.println("\n=== Rolling " + userInput + " ===");
                diceRoll(userInput, inputValidator);

                System.out.println("=== Throw a dice ===\n");

                continue;
            } else {

                System.out.println("Invalid dice parameters.");
                System.out.println("Type '--help' for more information.\n");
                continue;

            }
        }
    }

    public void diceRoll(String userInput, validator input) {

        input.diceRollInputDecipher(userInput);
        int diceAmount = input.getDiceAmount();
        int diceType = input.getDiceType();
        int bonusVariable = input.getBonusVariable();

        Dice userInputDice = new Dice(diceAmount, diceType, bonusVariable);
        DiceFunctions userDiceFunc = new DiceFunctions(userInputDice);

        userDiceFunc.throwDice();
    }

    public void clearTerminal() {
        System.out.print("\033[H\033[2J");
    }
}
