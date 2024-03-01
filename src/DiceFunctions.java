import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;


public class DiceFunctions {
    private int currentRoll;
    private int finalRoll;
    private ArrayList<String> rollLog = new ArrayList<>();
    private ArrayList<DiceFunctions> rollLogObj = new ArrayList<>();

    private int diceAmount;
    private int diceType;
    private int bonus;

    private int rollA = 0;
    private int rollB = 0;
    


    public DiceFunctions(Dice diceObject) {
        this.diceAmount = diceObject.getDiceAmount();
        this.diceType = diceObject.getDiceType();
        this.bonus = diceObject.getBonus();
    }



    public void rollDice() {

        if (this.diceAmount > 1) {
            for (int i = 0; i < diceAmount; i++) {
                currentRoll = ThreadLocalRandom.current().nextInt(1, diceType + 1);
                rollLog.add("Roll #" + (i+1) + ": " + currentRoll);
                rollLogObj.add(this);            
                finalRoll = finalRoll + currentRoll;                                
            }
        }else {
            currentRoll = ThreadLocalRandom.current().nextInt(1, diceType + 1);
            rollLog.add("Roll: " + currentRoll);
            finalRoll = currentRoll; 
        }

        if (this.bonus > 0) { rollLog.add("Bonus: +" + bonus); }
        if (this.bonus < 0) { rollLog.add("Bonus: " + bonus); }

        finalRoll = finalRoll + bonus;

        if (finalRoll < 1) {
            finalRoll = 1;
        }

        rollLog.add("Final roll: " + finalRoll);
    }

    public void rollDicePrint() {
        rollDice();
        rollLogger newRollEntry = new rollLogger(rollLog);
        newRollEntry.addObjectToList(this);

        System.out.println(newRollEntry.toString());

        this.initialize();
    }

    public void rollAdvantage(){
        this.bonus = 0;
        this.diceAmount = 1;
        this.diceType = 20;
        int advantage;

        

        rollDice();
        int rollA = this.finalRoll;
        rollLog.remove(1);

        rollDice();
        int rollB = this.finalRoll;
        rollLog.remove(1);
        

        if (rollA >= rollB) {
            advantage = rollA;            
        } else{
            advantage = rollB;
        }
            
        this.finalRoll = advantage;
        rollLog.add("Final advantage roll: " + finalRoll);
        
    }

    public void rollAdvantagePrint(){
        rollAdvantage();

        rollLogger newRollEntry = new rollLogger(rollLog);
        newRollEntry.addObjectToList(this);

        System.out.println(newRollEntry.toString());

        this.initialize();
    }

    private void initialize() {
        this.finalRoll = 0;
        this.currentRoll = 0;
        this.rollLog.clear();
        this.rollLogObj.clear();
    }

    public int getCurrentRoll() {
        return currentRoll;
    }



    public void setCurrentRoll(int currentRoll) {
        this.currentRoll = currentRoll;
    }



    public int getFinalRoll() {
        return finalRoll;
    }



    public void setFinalRoll(int finalRoll) {
        this.finalRoll = finalRoll;
    }



    public int getDiceAmount() {
        return diceAmount;
    }



    public void setDiceAmount(int diceAmount) {
        this.diceAmount = diceAmount;
    }



    public int getDiceType() {
        return diceType;
    }



    public void setDiceType(int diceType) {
        this.diceType = diceType;
    }



    public int getBonus() {
        return bonus;
    }



    public void setBonus(int bonus) {
        this.bonus = bonus;
    }



    @Override
    public String toString() {
        return "DiceFunctions [currentRoll=" + currentRoll + ", finalRoll=" + finalRoll + ", rollLog=" + rollLog
                + ", diceAmount=" + diceAmount + ", diceType=" + diceType + ", bonus=" + bonus + "]";
    }
}
