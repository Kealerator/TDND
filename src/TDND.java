import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */



/**
 *
 * @author mattirundelin
 */
public class TDND {

    public static int diceRoller(int howMany, int max){
        int finalRoll = 0;
        int currentRoll;
        
        
        for (int i = 0; i < howMany; i++) {
            currentRoll = ThreadLocalRandom.current().nextInt(1, max + 1);
            finalRoll = finalRoll + currentRoll;
            System.out.println("roll " + (i + 1) + ": "+ currentRoll);
        }
    
        
        return finalRoll;
    }
    
    public static void main(String[] args) {
        Scanner UserInput = new Scanner(System.in);

        System.out.print("Enter dice amount, and dice type (format '1d6') :");
        String userInput = UserInput.nextLine();
        
        
        String[] pieces = userInput.split("d");
        int diceAmount = Integer.parseInt(pieces[0]);
        int diceType = Integer.parseInt(pieces[1]);
        
        System.out.println(diceAmount + " " + diceType);
        
             
        System.out.println("Roll : " + diceRoller(diceAmount, diceType));
        

        
       
    }
}
