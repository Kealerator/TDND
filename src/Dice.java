public class Dice {
    
    private int diceAmount;
    private int diceType;
    private int bonus;


    
    public Dice(int diceAmount, int diceType) {
        this.diceAmount = diceAmount;
        this.diceType = diceType;
        this.bonus = 0;
    }
    public Dice(int diceAmount, int diceType, int bonus) {
        this.diceAmount = diceAmount;
        this.diceType = diceType;
        this.bonus = bonus;
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
        return diceAmount + "d" + diceType + "+" + bonus;
    }
}
