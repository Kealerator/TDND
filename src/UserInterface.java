import java.util.ArrayList;

public class UserInterface extends Engine {

    private int frameHeight;
    private int frameWidth;
    private int longestMenuItemLength;
    private String frameTitle;
    private Menu object;
    private char symbolFrameTitlebar;
    private char symbolMenuFrame;

    // Initialize Menu by custom height and width
    public UserInterface(int height, int width, Menu menuObj) {

        this.object = menuObj;
        this.frameHeight = height;
        this.frameWidth = (width * 3);

        this.frameTitle = menuObj.getMenuTitle();
        this.symbolFrameTitlebar = '#';
        this.symbolMenuFrame = '|';
    }

    // Initialize a menu by custom height, width, custom symbols for frametitle bar
    // and menu frame
    public UserInterface(int height, int width, Menu menuObj, char symbolFrameTitlebar, char symbolMenuFrame) {
        this.frameHeight = height;
        this.frameWidth = (width * 3);
        this.frameTitle = menuObj.getMenuTitle();
        this.object = menuObj;
        this.symbolFrameTitlebar = symbolFrameTitlebar;
        this.symbolMenuFrame = symbolMenuFrame;
    }

    // Print the whole menu
    public void printInterface() {

        if (isAnyMenuItemLongerThanTitle(this.object)) {
            this.frameWidth = this.longestMenuItemLength;

        }

        // The menu is separated to 2 sections, FrameTitlebar, and the Menu Item Frame.

        // Print the frametitle bar
        this.printFrameTitleBar(this.symbolFrameTitlebar, this.frameTitle);

        // Print the menu frame and the menu items inside it
        this.printMenuItemFrame(this.object.getMenuItems(), this.symbolMenuFrame);
    }

    // Here on is just different functions for menu printing.

    // The title bar
    public void printFrameTitleBar(char frameSymbol, String frameTitle) {

        // Top
        this.printTopFrameTitleBar(frameSymbol);

        // Sides and the Title
        this.printSidesFrameTitleBar(frameSymbol);

        // Bottom
        this.printBottomFrameTitleBar(frameSymbol);
        System.out.print("\n");

    }

    private void printTopFrameTitleBar(char symbol) {
        printSymbol(this.frameWidth, symbol);
    }

    private void printSidesFrameTitleBar(char symbol) {
        int nudge;
        System.out.print("\n" + symbol);

        if(this.frameTitle.length() % 2 != 0){
            nudge = 3;
        }else {
            nudge = 0;
        }

        printSpaces((this.frameWidth / 2) - (this.frameTitle.length() / 2));
        System.out.print(this.frameTitle);
        // printSpaces(this.frameWidth - this.frameTitle.length());
        printSpaces((this.frameWidth / 2) - (this.frameTitle.length() / 2) - nudge);

        System.out.println(symbol);

    }

    private void printBottomFrameTitleBar(char symbol) {
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

    // Print Menu Item Frame
    private void printMenuItemFrame(ArrayList<MenuItem> menuItems, char symbol) {

        // Print the sides within every menu item
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
                    this.printSymbol(this.frameWidth, symbolFrameTitlebar);
                    System.out.println();
                }
            }

        }
    }

    private boolean isAnyMenuItemLongerThanTitle(Menu menuObj) {
        ArrayList<MenuItem> itemList = menuObj.getMenuItems();

        int larger = 0;

        for (int i = 0; i < itemList.size(); i++) {
            if (larger < itemList.get(i).toString().length() + 5) {
                larger = itemList.get(i).toString().length() + 5;
            }
        }

        if ((this.frameWidth / 3) < larger) {
            this.longestMenuItemLength = larger;
            return true;
        } else {
            return false;
        }

    }

}
