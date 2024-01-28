import java.util.Scanner;
import java.util.regex.Pattern;

public class testing {

    public static void main(String[] args) {
        Scanner UserInput = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String userInput = UserInput.nextLine();

        String text = "abc";
        String number;

        if (!Pattern.matches("[a-zA-Z]+", userInput)) {
            System.out.println("You've entered a number.");
        }

    }
}
