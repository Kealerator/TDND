import java.util.ArrayList;

public class Menu extends Engine {
     //List for Items in the menu
     private ArrayList<MenuItem> menuItems;

     // Menu design depends on menutype variable
     private String menuType;

     // This is the String that's going to be on top of the menu
     private String menuTitle;

     // Menu drawer which creates frames for the menu
     private UserInterface UI;

     public Menu(String menuType, String menuTitle) {
          this.menuType = menuType;
          this.menuTitle = menuTitle;
          if (MenuBuilder.checkIfMenuValidType(this)) {
               this.initMenuItems();
               this.initMenu();
          }

     }
     
     // Initialize memory for Menu Items
     public void initMenuItems() {

          // Menu Items can only be added when Menu Type is 'main'.
          if (this.menuType.equals("main")) {
               this.menuItems = new ArrayList<>();
          }else{
               // If user tries to add Menu Item to other than 'main', log this error to engine log

               engLog.add("You can add Menu Items only to Menu Type 'main'!", true);
          }
     }

     // Add Menu Item
     public void addMainMenuItem(MenuItem item) {

          // Add Menu Item object to ArrayList
          this.menuItems.add(item);

          // Sets the Menu Item objects ChoiceID by how many there already are
          // Empty list = 0, *add* menu item ChoiceID = 1
          item.setChoiceID(this.menuItems.indexOf(item));
     }

     // Initialize memory for Menu
     public void initMenu() {
          if (this.getMenuType().equals("main")) {

               // Creates an draw object for main Menu -object
               this.UI = new UserInterface(10, this.menuTitle.length(), this);
          }
     }

     // Draw Menu
     public void printMenu() {
          this.UI.printInterface();
     }

     public ArrayList<MenuItem> getMenuItems() {
          return this.menuItems;
     }

     public String getMenuType() {
          return menuType;
     }

     public String getMenuTitle() {
          return menuTitle;
     }

}
