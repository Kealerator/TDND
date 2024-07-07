import java.util.ArrayList;

public class UserInterface extends Engine {

    private int frameHeight;
    private int frameWidth;
    private String frameTitle;
    private Menu object;
    private char symbolA;
    private char symbolB;

    public UserInterface(int height, int width, Menu menuObj) {
        this.frameHeight = height;
        this.frameWidth = (width * 3);
        this.frameTitle = menuObj.getMenuTitle();
        this.object = menuObj;
        this.symbolA = '#';
        this.symbolB = '‡';
    }

    public UserInterface(int height, int width, Menu menuObj, char symbolA, char symbolB) {
        this.frameHeight = height;
        this.frameWidth = (width * 3);
        this.frameTitle = menuObj.getMenuTitle();
        this.object = menuObj;
        this.symbolA = symbolA;
        this.symbolB = symbolB;
    }

    public void printInterface() {
        this.printFrameTitleBar(this.symbolA, this.frameTitle);
        this.printMenuItemFrame(this.object.getMenuItems(), this.symbolB);
    }

    public void printFrameTitleBar(char frameSymbol, String frameTitle) {


        this.printTopFrameTitleBar(frameSymbol);

        this.printSidesFrameTitleBar(frameSymbol);

        this.printBottomFrameTitleBar(frameSymbol);

        System.out.print("\n");

    }

    private void printTopFrameTitleBar(char symbol){
        printSymbol(this.frameWidth, symbol);
    }

    private void printSidesFrameTitleBar(char symbol){
        System.out.print("\n" + symbol);

        printSpaces(this.frameTitle.length() - 1);
        System.out.print(this.frameTitle);
        printSpaces(this.frameTitle.length() - 1);

        System.out.println(symbol);

    }

    private void printBottomFrameTitleBar(char symbol){
        this.printTopFrameTitleBar(symbol);
    }

    private void printSpaces(int amount) {
        for (int i = 0; i < amount; i++) {
            System.out.print(" ");
        }
    }

    private void printSymbol(int width, char frameSymbol) {
        for (int j = 0; j < width; j++) {
            System.out.print(frameSymbol);
        }
    }

    private void printMenuItemFrame(ArrayList<MenuItem> menuItems, char symbol) {
        for (int i = 0; i < menuItems.size() + 2; i++) {
            System.out.print(symbol);

            if (i >= 1 && i <= menuItems.size()) {
                System.out.print("  " + menuItems.get(i - 1));
                this.printSpaces(this.frameWidth - (menuItems.get(i - 1).toString().length()) - 4);
                System.out.print(symbol + "\n");
            } else {
                this.printSpaces(this.frameWidth - 2);
                System.out.print(symbol + "\n");

                if (i == menuItems.size() + 1) {
                    this.printSymbol(this.frameWidth, symbolA);
                    System.out.println();
                }
            }

        }
    }
}
