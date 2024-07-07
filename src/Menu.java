import java.util.ArrayList;

public class Menu extends MenuBuilder {
     private ArrayList<MenuItem> menuItems;
     private String menuType;
     private String menuTitle;
     private UserInterface UI;

     public Menu(String menuType, String menuTitle) {
          this.menuType = menuType;
          this.menuTitle = menuTitle;
          if (MenuBuilder.checkIfMenuValidType(this)) {
               this.initializeMenuItems();
               this.initMenu();
          }

     }

     public void initializeMenuItems() {
          if (this.menuType.equals("main")) {
               generateMainTypeMenu();
          }
     }

     private void generateMainTypeMenu() {
          this.menuItems = new ArrayList<>();
     }

     public void addMainMenuItem(MenuItem item) {
          this.menuItems.add(item);
          item.setChoiceID(this.menuItems.indexOf(item));
     }

     public void initMenu() {
          if (this.getMenuType().equals("main")) {
               this.UI = new UserInterface(10, this.menuTitle.length(), this);
          }
     }

     public void printMenu() {
          this.UI.printInterface();

          String menuItemContent = "";

          for (MenuItem menuItem : menuItems) {
               menuItemContent += menuItem + "\n";
          }

          System.out.println(menuItemContent);

          

     }

     public String getMenuType() {
          return menuType;
     }

     public String getMenuTitle() {
          return menuTitle;
     }

}
