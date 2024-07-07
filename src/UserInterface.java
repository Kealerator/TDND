import java.util.ArrayList;

public class UserInterface extends Engine {

    private int frameHeight;
    private int frameWidth;
    private String frameTitle;
    private Menu object;
    private ArrayList<MenuItem> menuItems;

    public UserInterface(int height, int width, Menu menuObj) {
        this.frameHeight = height;
        this.frameWidth = (width * 3);
        this.frameTitle = menuObj.getMenuTitle();
        this.object = menuObj;
    }

    public void printInterface() {
        this.printFrameTitleBar('&', this.frameTitle);
        this.printMenuItemFrame(this.object.getMenuItems());
    }

    public void printFrameTitleBar(char frameSymbol, String frameTitle) {

        frameTitleBarTop(this.frameWidth, frameSymbol);

        System.out.print("\n" + frameSymbol);
        printSpaces(frameTitle.length() - 1);
        System.out.print(frameTitle);
        printSpaces(frameTitle.length() - 1);
        System.out.println("&");

        frameTitleBarTop(this.frameWidth, frameSymbol);

        System.out.print("\n");

    }

    private void printSpaces(int amount) {
        for (int i = 0; i < amount; i++) {
            System.out.print(" ");
        }
    }

    private void frameTitleBarTop(int width, char frameSymbol) {
        for (int j = 0; j < width; j++) {
            System.out.print(frameSymbol);
        }
    }

    private void printMenuItemFrame(ArrayList<MenuItem> menuItems) {
        for (int i = 0; i < menuItems.size() + 2; i++) {
            System.out.print("&");

            if (i >= 1 && i <= menuItems.size()) {
                System.out.print("  " + menuItems.get(i - 1));
                this.printSpaces(this.frameWidth - (menuItems.get(i - 1).toString().length()) - 4);
                System.out.print("&\n");
            } else {
                this.printSpaces(this.frameWidth - 2);
                System.out.print("&\n");

                if (i == menuItems.size() + 1) {
                    for (int j = 0; j < this.frameWidth; j++) {
                        System.out.print("&");
                        if (j == this.frameWidth - 1) {
                            System.out.print("\n");
                        }
                    }
                }
            }

        }
    }
}
