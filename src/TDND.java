import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */


/**
 * @author mattirundelin
 */
public class TDND {

    public static int diceRoller(int howMany, int max, int bonus, boolean bonusType) {
        int finalRoll = 0;
        int currentRoll;


        for (int i = 0; i < howMany; i++) {
            currentRoll = ThreadLocalRandom.current().nextInt(1, max + 1);
            finalRoll = finalRoll + currentRoll;
            System.out.println("roll " + (i + 1) + ": " + currentRoll);
        }

        if (bonusType) {
            System.out.println("Bonus: +" + bonus);
            finalRoll = bonus + finalRoll;
        } else {
            System.out.println("Bonus: -" + bonus);
            finalRoll = finalRoll - bonus;
        }


        return finalRoll;
    }

    public static void main(String[] args) {
        Scanner UserInput = new Scanner(System.in);

        System.out.print("Enter dice amount, and dice type (format '1d6+bonus') :");
        String userInput = UserInput.nextLine();

        int diceAmount = 0;
        int diceType = 0;
        int bonusVariable = 0;
        boolean bonusTypePositive = true;


        if (userInput.contains("+")) {
            String[] pieces = userInput.split("[d+]");
            diceAmount = Integer.parseInt(pieces[0]);
            diceType = Integer.parseInt(pieces[1]);
            bonusVariable = Integer.parseInt(pieces[2]);
        } else if (userInput.contains("-")) {
            String[] pieces = userInput.split("[d-]");
            diceAmount = Integer.parseInt(pieces[0]);
            diceType = Integer.parseInt(pieces[1]);
            bonusVariable = Integer.parseInt(pieces[2]);
            bonusTypePositive = false;
        }


        System.out.println(diceAmount + " " + diceType);


        System.out.println("Roll : " + diceRoller(diceAmount, diceType, bonusVariable, bonusTypePositive));


    }
}
