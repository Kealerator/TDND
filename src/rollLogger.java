import java.util.ArrayList;

public class rollLogger {
    private ArrayList<DiceFunctions> rollLogObjects = new ArrayList<>();
    private ArrayList<String> rollLogStrings = new ArrayList<>();

    public rollLogger(ArrayList<String> rollLogStrings) {
        this.rollLogStrings = rollLogStrings;
    }

    public void addObjectToList(DiceFunctions importedObj) {
        rollLogObjects.add(importedObj);
    }

    @Override
    public String toString() {

        String print = "";

        for (String lineString : rollLogStrings) {
            print += "\n" + lineString;
        }

        return print;
    }
}
