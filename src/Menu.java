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
               this.initMenuItems();
               this.initMenu();
          }

     }

     public void initMenuItems() {
          if (this.menuType.equals("main")) {
               this.menuItems = new ArrayList<>();
          }
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
