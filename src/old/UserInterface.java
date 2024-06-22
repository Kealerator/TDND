import java.util.Scanner;

public class UserInterface {

    private Scanner scan;

    public UserInterface(Scanner scan) {
        this.scan = scan;
    }

    public void mainMenu() {

        while (true) {
            clearTerminal();
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
                if (userInput.equalsIgnoreCase("y") || userInput.equalsIgnoreCase("yes")) {
                    System.out.println("\nBye!");
                    break;
                } else {
                    continue;
                }
            } else {
                if (inputProcessor(userInput)) {
                    break;
                }
                continue;
            }
        }
    }

    private boolean inputProcessor(String userInput) {
        if (userInput.equals("1")) {
            DiceRollerMenu diceRollerMenu = new DiceRollerMenu(scan);
            diceRollerMenu.start();
            return true;
        } else {
            return false;
        }
    }

    public void clearTerminal() {
        System.out.print("\033[H\033[2J");
    }
}
