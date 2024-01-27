import java.util.Scanner;

public class testing {

    public static boolean checker(int input){
        boolean access;
        if (input != 0){
            access = false;
        } else{
            access = true;
        }
        return access;
    }
    public static void main(String[] args) {
        Scanner UserInput = new Scanner(System.in);

        while (true) {
            System.out.print("Enter 0: ");
            int userInput = UserInput.nextInt();

            if(checker(userInput)){
                break;
            }
        }

    }
}
