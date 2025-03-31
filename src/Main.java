
public class Main extends Engine {

   public static void main(String[] args) {

      Menu test1 = new Menu("TERE!", Menu.menuType.MAIN);
      Menu test2 = new Menu("Main Menu", Menu.menuType.MAIN);




      engLog.print();

      test2.addMainMenuItem(new MenuItem("Start"));
      test1.addMainMenuItem(new MenuItem("Settings"));
      test1.addMainMenuItem(new MenuItem("Quit"));
      //This Menu Item goes over the frame
      test1.addMainMenuItem(new MenuItem("1234567890123456789123456789"));


      test2.addMainMenuItem(new MenuItem("Starter"));
      test2.addMainMenuItem(new MenuItem("Settings"));
      test2.addMainMenuItem(new MenuItem("Quit"));
      test2.addMainMenuItem(new MenuItem("Help"));

      test1.printMenu();
      test2.printMenu();





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