import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserInterface TextUI = new UserInterface(scanner);

        TextUI.mainMenu();
    }
}