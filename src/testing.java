import java.util.Scanner;

public class testing {

    public static void main(String[] args) {
       
        Scanner scan = new Scanner(System.in);
        //UserInterface TextUI = new UserInterface(scan);
        Tutorial tutorial = new Tutorial(scan);

        tutorial.start();

        
        
    }
}
