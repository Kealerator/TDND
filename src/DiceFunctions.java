import java.util.concurrent.ThreadLocalRandom;

public class DiceFunctions {

    private int diceAmount;
    private int diceType;
    private int bonus;

    private int currentRoll;
    private int finalRoll;

    public DiceFunctions(Dice diceObject) {
        this.diceAmount = diceObject.getDiceAmount();
        this.diceType = diceObject.getDiceType();
        this.bonus = diceObject.getBonus();
    }

    public int generateRoll(int diceType) {
        return ThreadLocalRandom.current().nextInt(1, diceType + 1);
    }

    public void throwDice() {
        this.currentRoll = 0;
        this.finalRoll = 0;
        rollLogger rollLog = new rollLogger();

        for (int i = 0; i < this.diceAmount; i++) {
            this.currentRoll = generateRoll(this.diceType);
            this.finalRoll += this.currentRoll;
            rollLog.addCurrentRoll(this.currentRoll);
        }
        if (this.finalRoll + this.bonus > 1) {
            this.finalRoll += this.bonus;
        } else {
            this.finalRoll = 1;
        }
        
        rollLog.addFinalRoll(this.finalRoll, this.bonus);

        rollLog.printDiceThrown();

    }

}
