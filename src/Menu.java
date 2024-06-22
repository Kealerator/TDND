import java.util.ArrayList;

public class Menu extends MenuBuilder {
     private ArrayList<MenuItem> menuItems;
     private String menuType;
     private String menuTitle;

     public Menu(String menuType, String menuTitle) {
          this.menuType = menuType;
          this.menuTitle = menuTitle;
          if (MenuBuilder.checkIfMenuValidType(this)) {
               this.initializeMenuItems();
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

     public void addMainMenuItem(MenuItem item){
          this.menuItems.add(item);
          item.setChoiceID(this.menuItems.indexOf(item));
     }

     public void printMenu(){
          if (this.getMenuType().equals("main")) {

               String menuItemContent = "";

               for (MenuItem menuItem : menuItems) {
                    menuItemContent += menuItem + "\n";     
               }

               UserInterface menu = new UserInterface(10, this.menuTitle.length(), this);
               System.out.println(menuItemContent);
               
          }
     }

     public String getMenuType() {
          return menuType;
     }

     public String getMenuTitle() {
          return menuTitle;
     }

}
