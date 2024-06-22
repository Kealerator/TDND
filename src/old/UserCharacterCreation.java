/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Scanner;

public class UserCharacterCreation {

public static void textDecorationGen(int length, int rows, String symbol) {


    for (int j = 0; j < rows; j++){

        for (int i = 0; i < length; i++){
        System.out.print(symbol);
        } //end of for i
               
    } // end of for j
} //end of textDecorationGen


public static void fillAbilitiesToDefaults(double[] AbilityScore, int defaultValue){

    for(int i = 0; i < 6; i++){
    AbilityScore[i] = defaultValue;
    }

}

public static void getAbilitiesFromUser (double[] AbilityScore, String[] abilityScoreNames) {

Scanner UserInput = new Scanner(System.in);


    int j = 0;

    for(int i = 0; i < 6; i++){
        while (true){

        System.out.print("Input your " + abilityScoreNames[j] + ": ");
        int userInput = Integer.valueOf(UserInput.nextLine());

            if (userInput <= 0) {
                  System.out.println("Invalid value!");
                  continue;
                }
            AbilityScore[i] = userInput;
            j++;

           break;

        } // end of while
    } //end of for    
 
 
} //end of getAbilitiesFromUser

public static void getAbilityModifier (double[] AbilityScore, double[] AbilityModifier){
    
    
   
    
    for (int i = 0; i < 6; i++) {
        
        // double modifierFixer = AbilityScore[i];
        
        
        
        double modifierFixer = (AbilityScore[i] - 10) / 2;
        
            
        
        if (modifierFixer % 2 == 0.5 || modifierFixer % 2 == -0.5) {
            
            modifierFixer = modifierFixer - 0.5;
           
        }
     
        int modifierValue = (int)modifierFixer;
        
        AbilityModifier[i] = modifierValue;
    }
    
}

public static void printAbilityPointsList(double[] AbilityScore, String[] abilityScoreNames, double[] AbilityModifier) {


    int j = 0;

    System.out.println("\n\n\n");
    textDecorationGen(40,1,"=");
    System.out.println("");
    textDecorationGen(12,1," ");
    System.out.print("Ability Score: \n");
    textDecorationGen(40,1,"=");
    System.out.println("");


        for (int i = 0; i < 6; i++){
            System.out.println("");
            System.out.println(abilityScoreNames[j] + ": \t" + (int)AbilityScore[i]);
                if(AbilityModifier[i] > 0){
                    System.out.println("Modifier:\t +" + (int)AbilityModifier[i]);
                    
                }
                else if(AbilityModifier[i] <= 0){
                    System.out.println("Modifier:\t" + (int)AbilityModifier[i]);
                    
                }
            System.out.println("");
           j++;
        } //end of for i

} //end of printAbilityPointsList

public static void getSkillScores (String[] allSkillNames, double[] AbilityModifier, int proficiencyBonus){
    
    String[] strengthBasedSkills = {allSkillNames[0]};
    String[] dexterityBasedSkills = new String[3];
    
    
    int j = 0;
    for (int i = 1; i < 4; i++) {                       //transfer dex skills
        dexterityBasedSkills[j] = allSkillNames[i];
        j++;
    }
    

    
    System.out.println("Strength based skills:");
    System.out.println(strengthBasedSkills[0]);         //print str  skills
    
    
    System.out.println("Dexterity based skills:");
    for (int i = 0; i < 3; i++) {                       //print dex skills
        System.out.println(dexterityBasedSkills[i]);
    }
    
  
    
    
}

 public static void main(String[] args)
 {
  double[] AbilityScore= new double [6];
  double[] AbilityModifier= new double [6];
  String[] abilityScoreNames = {"Strength", "Dexterity", "Constitution", "Intelligence", "Wisdom", "Charisma"};
  String[] allSkillNames = {"Athletics", "Acrobatics", "Sleight of Hand", "Stealth",
                        "Arcana", "History", "Investigation", "Nature", "Religion",
                        "Animal Handling", "Insight", "Medicine", "Preception",
                        "Survival", "Deception", "Intimidation","Performance",
                        "Persuasion"};
  
    
    fillAbilitiesToDefaults(AbilityScore, 1);
    getAbilityModifier(AbilityScore, AbilityModifier);
  
    printAbilityPointsList(AbilityScore, abilityScoreNames, AbilityModifier);
    getSkillScores(allSkillNames, AbilityModifier, 2);

  
  
 }

}