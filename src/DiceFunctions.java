import java.util.concurrent.ThreadLocalRandom;

public class DiceFunctions {

    private int diceAmount;
    private int diceType;
    private int bonus;

    private int currentRoll;
    private int finalRoll;

    public DiceFunctions(int diceAmount, int diceType, int bonusVariable) {
        this.diceAmount = diceAmount;
        this.diceType = diceType;
        this.bonus = bonusVariable;
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

        rollLog.printdiceRolled();

    }

    public void throwDiceNoPrint() {
        this.currentRoll = 0;
        this.finalRoll = 0;

        for (int i = 0; i < this.diceAmount; i++) {
            this.currentRoll = generateRoll(this.diceType);
            this.finalRoll += this.currentRoll;
        }
        if (this.finalRoll + this.bonus > 1) {
            this.finalRoll += this.bonus;
        } else {
            this.finalRoll = 1;
        }
    }

    public int getDiceAmount() {
        return diceAmount;
    }

    public int getDiceType() {
        return diceType;
    }

    public int getBonus() {
        return bonus;
    }

    public int getCurrentRoll() {
        return currentRoll;
    }

    public int getFinalRoll() {
        return finalRoll;
    }
}
