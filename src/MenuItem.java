public class MenuItem {

    private String itemName;
    private int choiceID;

    public MenuItem(String item) {
        this.itemName = item;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getChoiceID() {
        return choiceID;
    }

    public void setChoiceID(int choiceID) {
        this.choiceID = choiceID;
    }

    @Override
    public String toString() {
        return this.choiceID + ": " + this.itemName;
    }

    

}
