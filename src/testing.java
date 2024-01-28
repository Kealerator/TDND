import java.util.Scanner;

public class testing {

    public static boolean checker(String input){
        boolean valid = true;

        int [] diceTypesAllowed = {4, 6, 8, 10, 12, 20, 100};

        String[] pieces = input.split("d");
        var inputDiceType = Integer.parseInt(pieces[1]);

        for (int i = 0; i < diceTypesAllowed.length; i++) {
            if (diceTypesAllowed[i] != inputDiceType) {
                valid = false;
            } else {
                valid = true;
                break;
            }
        }

        if(valid){
            System.out.println("Correct input.");
        } else {
            System.out.println("Incorrect input.");
        }

        return valid;


    }
    public static void main(String[] args) {
        Scanner UserInput = new Scanner(System.in);

        System.out.print("Enter dice type: ");
        String userInput = UserInput.nextLine();

        checker(userInput);

    }
}
