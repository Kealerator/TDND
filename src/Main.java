public class Main extends Engine {

   public static void main(String[] args) {
      Menu mainMenu = new Menu("main", "Main menu");
      Menu meinMenu = new Menu("mein", "Mein menu");
      engLog.print();

      mainMenu.addMainMenuItem(new MenuItem("Start"));
      mainMenu.addMainMenuItem(new MenuItem("Settings"));
      mainMenu.addMainMenuItem(new MenuItem("Quit"));

      //This Menu Item goes over the frame
      mainMenu.addMainMenuItem(new MenuItem("123456789abcdefg18192021222324252628"));

/*
 * TODO:
 * 
 * The Userface -class should have a function that scans every
 * Menu Item, checks which one is the longest one and thus increase the whole menu
 * width related by it.
 * 
 * 
 * The MenuBuilder -class seems unnecessary, merge it's code to Menu -class and
 * change Menu Type to enum.
 */


      mainMenu.printMenu();

   }
}