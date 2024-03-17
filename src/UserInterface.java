import java.util.Scanner;

public class UserInterface {

    private Scanner scan;
    private validator inputValidator = new validator();

    public UserInterface(Scanner scan){
        this.scan = scan;
    }

    public void start(){

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
                }else {
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
            diceThrowMenu();
        }
    }

    public void diceThrowMenu() {
        while (true) {
            System.out.println("=== Throw a dice ===\n");
            System.out.println("Here, you can simply throw a dice!");
            System.out.println("Enter '--help' for instructions if you need!");
            System.out.println("Enter 'X' to go back to the main menu.\n");
            
            String userInput = scan.nextLine();

            if (userInput.equals("X") || userInput.equals("x")) {
                System.out.println("Back to menu!");
                break;
            } else if(userInput.equals("--help") || userInput.equals("-help")){
                diceThrowTutorialMenu();
            } else if (inputValidator.diceSyntaxValidator(userInput)){
                inputValidator.diceThrowInputDecipher(userInput);
                int diceAmount = inputValidator.getDiceAmount();
                int diceType = inputValidator.getDiceType();
                int bonusVariable = inputValidator.getBonusVariable();

                Dice userInputDice = new Dice(diceAmount, diceType, bonusVariable);
                DiceFunctions userDiceFunc = new DiceFunctions(userInputDice);
                
                userDiceFunc.throwDice();

                continue;
            }
        }
    }

    public void diceThrowTutorialMenu() {
        System.out.println("\n\n--- Welcome to dice tutorial! ---\n");
        System.out.println("The format to throw, is simply put [dice amount] d <dice type>.");
        System.out.println("i.e. entering '2d6' would throw 2 pieces of 6 sided dice!\n\n");
        System.out.println("Psst! \"Dice\" is the plural form of \"die.\" \"Dice\" is sometimes used to refer to a singular die. " + 
        "\n\nIf you want to play it safe: Use \"dice\" if you are rolling two or more game pieces.\nUse \"die\", if you are only using one piece.");

        System.out.print("Enter \">\" to proceed: ");
        String userInput = scan.nextLine();
        if (userInput.equals(">")) {
            diceThrowTutorialTests();
        }
    }

    private void diceThrowTutorialTests() {
        System.out.println("\n\n--- Dice tutorial ---\n");

    }
}
