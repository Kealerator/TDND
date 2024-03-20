import java.util.ArrayList;

public class rollLogger {

    private ArrayList<String> rollLog;

    public rollLogger() {
        this.rollLog = new ArrayList<>();
    }

    public void addCurrentRoll(int currentRoll){
        this.rollLog.add(("Roll #" + (this.rollLog.size() + 1)) + ": " + String.valueOf(currentRoll));
    }

    public void addFinalRoll(int finalRoll, int bonus){
    
        if (bonus > 0) {
            String bonusString;
            bonusString = "+" + String.valueOf(bonus);
            rollLog.add("Bonus: " + bonusString);
        } else {
            rollLog.add("Bonus: " + bonus);
        }

        rollLog.add("Final roll: " + finalRoll + "\n");
    }

    public void printdiceRolled(){
        for (String stringIndex : rollLog) {
            System.out.println(stringIndex);
        }
    }

}
