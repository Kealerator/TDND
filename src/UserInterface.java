public class UserInterface extends Engine {

    private int frameHeight;
    private int frameWidth;
    private String frameTitle;
    private Object object;

    public UserInterface(int height, int width, Menu menuObj) {
        this.frameHeight = height;
        this.frameWidth = (width * 3);
        this.frameTitle = menuObj.getMenuTitle();
        this.object = menuObj;
    }

    public void printInterface(){
       this.printFrameTitleBar('&', this.frameTitle);

    }


    public void printFrameTitleBar(char frameSymbol, String frameTitle) {

        frameTitleBarTop(this.frameWidth, frameSymbol);

        System.out.print("\n" + frameSymbol);
        printSpaces(frameTitle.length() - 1);
        System.out.print(frameTitle);
        printSpaces(frameTitle.length() - 1);
        System.out.println("&");

        frameTitleBarTop(this.frameWidth, frameSymbol);

        System.out.println("\n");

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
}
