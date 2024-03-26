import java.util.concurrent.ThreadLocalRandom;

public class DiceFunctions {

    private int diceAmount;
    private int diceType;
    private int bonus;

    private int currentRoll;
    private int finalRoll;

    private rollLogger rollLog;

    public DiceFunctions(String userInput, validator inputValidator) {
        inputValidator.diceRollInputDecipher(userInput);
        this.diceAmount = inputValidator.getDiceAmount();
        this.diceType = inputValidator.getDiceType();
        this.bonus = inputValidator.getBonusVariable();
    }

    public DiceFunctions(int diceAmount, int diceType, int bonusVariable) {
        this.diceAmount = diceAmount;
        this.diceType = diceType;
        this.bonus = bonusVariable;
    }

    public DiceFunctions() {
        this.diceAmount = 0;
        this.diceType = 0;
        this.bonus = 0;
    }

    public int generateRoll(int diceType) {
        return ThreadLocalRandom.current().nextInt(1, diceType + 1);
    }

    public void throwDice() {
        this.currentRoll = 0;
        this.finalRoll = 0;
        this.rollLog = new rollLogger();

        for (int i = 0; i < this.diceAmount; i++) {
            this.currentRoll = generateRoll(this.diceType);
            this.finalRoll += this.currentRoll;
            this.rollLog.addCurrentRoll(this.currentRoll);
        }
        if (this.finalRoll + this.bonus > 1) {
            this.finalRoll += this.bonus;
        } else {
            this.finalRoll = 1;
        }

        this.rollLog.addFinalRoll(this.finalRoll, this.bonus);
        

    }

    public void throwDiceNoLog() {
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
        return this.diceAmount;
    }

    public int getDiceType() {
        return this.diceType;
    }

    public int getBonus() {
        return this.bonus;
    }

    public int getCurrentRoll() {
        return this.currentRoll;
    }

    public int getFinalRoll() {
        return this.finalRoll;
    }

    public rollLogger getRollLog() {
        return this.rollLog;
    }
}
