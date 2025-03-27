
public class Main extends Engine {

   public static void main(String[] args) {

      Menu test1 = new Menu("TERE!", Menu.menuType.MAIN);
      Menu test2 = new Menu("TORE!", Menu.menuType.PROMPT);




      engLog.print();

      test1.addMainMenuItem(new MenuItem("Start"));
      test1.addMainMenuItem(new MenuItem("Settings"));
      test1.addMainMenuItem(new MenuItem("Quit"));

      //This Menu Item goes over the frame
      test1.addMainMenuItem(new MenuItem("1234567890123456789123456789"));

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


      test1.printMenu();

   }
}