import java.util.Scanner;

public class testing {
    public static void main(String[] args) {
        Scanner UserInput = new Scanner(System.in);

        while (true) {
            System.out.print("Enter 1: ");
            int userInput = UserInput.nextInt();

            if(userInput == 1){
                System.out.println("Was that so hard?");
                break;
            } else {
                System.out.println("You entered " + userInput + "!");

            }
        }
    }
}
