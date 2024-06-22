public class Main extends Engine{

     public static void main(String[] args) {        
        Menu mainMenu = new Menu("main", "Main menu");
        Menu meinMenu = new Menu("mein", "Mein menu");
        engLog.print();

        mainMenu.addMainMenuItem(new MenuItem("Start"));
        mainMenu.addMainMenuItem(new MenuItem("Settings"));
        mainMenu.addMainMenuItem(new MenuItem("Quit"));


        

        mainMenu.printMenu();
        
     }
}