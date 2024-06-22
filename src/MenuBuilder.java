import java.util.ArrayList;

public class MenuBuilder extends Engine {  
    
    public static void generateMenu(Menu obj){
        checkMenuType(obj);
    }    

    public static boolean checkIfMenuValidType(Menu obj){
        ArrayList<String> menuTypes = initMenuTypes();

       if (!(isMenuTypeValid(obj, menuTypes))) {
             engLog.add("Invalid menu type " + obj.getMenuType(), true);
             return false;
       }else {
            engLog.add("Menu built : " + obj.getMenuType() + " : " + obj.getMenuTitle());
            return true;
       } 
    }

    private static boolean isMenuTypeValid(Menu obj, ArrayList<String> menuTypes) {
        if (menuTypes.contains(obj.getMenuType())) {
            return true;            
        }else {
            return false;
        }

    }

    private static ArrayList<String> initMenuTypes(){
        ArrayList<String> menuTypes = new ArrayList<>();

        menuTypes.add("main");
        menuTypes.add("prompt");
        menuTypes.add("confirm");
        
        return menuTypes;
    }

    private static void checkMenuType(Menu obj){
        if (obj.getMenuType().equals("main")) {
            
        }
    }

}
