import java.util.List;
import java.util.Map;

import jungleprimatesanctuary.Food;
import jungleprimatesanctuary.MonkeyFactory;
import jungleprimatesanctuary.Primate;
import jungleprimatesanctuary.Sanctuary;
import jungleprimatesanctuary.Sex;
import jungleprimatesanctuary.Size;

public class JunglePrimateDriver {

  public static void main(String[] args) {

    Sanctuary sanctuary = new Sanctuary(new MonkeyFactory(), 7, 4);

    /**create new monkeys, new monkeys will always go to Isolation.
     * Enter housing values null as user doesn't know the type of housing or cage no
     */
    try {
      sanctuary.createNewPrimate("Blim", Size.MEDIUM.getSizeDescription(), Sex.FEMALE.getSex()
              , 40, 100, Food.EGGS.foodName(), Size.MEDIUM.getFoodQuantity()
              , Size.MEDIUM.getSpaceRequirement(), "Drill");
      System.out.println("Monkey with name Blim created");
      sanctuary.createNewPrimate("Bob", Size.LARGE.getSizeDescription(), Sex.MALE.getSex()
              , 55, 200, Food.FRUITS.foodName(), Size.LARGE.getFoodQuantity()
              , Size.LARGE.getSpaceRequirement(), "Spider");
      System.out.println("Monkey with name Bob created");
      sanctuary.createNewPrimate("Tom", Size.LARGE.getSizeDescription(), Sex.MALE.getSex()
              , 50, 225, Food.TREE_SAP.foodName(), Size.LARGE.getFoodQuantity()
              , Size.LARGE.getSpaceRequirement(), "Squirrel");
      System.out.println("Monkey with name Tom created");
      sanctuary.createNewPrimate("Chan", Size.MEDIUM.getSizeDescription(), Sex.MALE.getSex()
              , 35, 120, Food.NUTS.foodName(), Size.MEDIUM.getFoodQuantity()
              , Size.LARGE.getSpaceRequirement(), "Spider");
      System.out.println("Monkey with name Chan created");
      sanctuary.createNewPrimate("Lily", Size.SMALL.getSizeDescription(), Sex.FEMALE.getSex()
              , 25, 50, Food.INSECTS.foodName(), Size.SMALL.getFoodQuantity()
              , Size.SMALL.getSpaceRequirement(), "Mangabey");
      System.out.println("Monkey with name Lily created");
      sanctuary.createNewPrimate("Lake", Size.LARGE.getSizeDescription(), Sex.MALE.getSex()
              , 30, 300, Food.LEAVES.foodName(), Size.LARGE.getFoodQuantity()
              , Size.SMALL.getSpaceRequirement(), "Mangabey");
      System.out.println("Monkey with name Lake created");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    /* Create monkey with already existing name*/
    try {
      sanctuary.createNewPrimate("Lake", Size.LARGE.getSizeDescription(), Sex.MALE.getSex()
              , 30, 300, Food.LEAVES.foodName(), Size.LARGE.getFoodQuantity()
              , Size.SMALL.getSpaceRequirement(), "Mangabey");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    /* Get Alphabetical List of all monkey's in sanctuary with their housing */
    System.out.println('\n' + "****** Alphabetical list of monkey's along with their housing *******");
    System.out.println(printAlphabeticalMonkeyList(sanctuary.getAlphabeticalListOfMonkeys()));

    /* Change Medical Health of any monkey in the sanctuary by its name*/
    try {
      sanctuary.changeMedicalConditionOfMonkey("Bob", true);
      System.out.println("Medical condition of Bob changed");
      sanctuary.changeMedicalConditionOfMonkey("Lily", true);
      System.out.println("Medical condition of Lily changed");
      sanctuary.changeMedicalConditionOfMonkey("Lake", true);
      System.out.println("Medical condition of Lake changed");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    } catch (IllegalStateException s) {
      System.out.println(s.getMessage());
    }

    /* Get Alphabetical List of all monkey's in sanctuary with their housing */
    System.out.println("****** Alphabetical list of monkey's along with their housing *******");
    System.out.println(printAlphabeticalMonkeyList(sanctuary.getAlphabeticalListOfMonkeys()));

    /* Get Enclosure Sign --- Sign Contains: Name, Sex, Favorite Food */
    System.out.println('\n' + "****** Enclosure sign for any cage includes Name, Sex, and Favorite food ******");
    try {
      System.out.println(sanctuary.getEnclosureSign(1));
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    /* Get Shopping List of all favorite foods for the sanctuary */
    System.out.println("****** Shopping List of all favorite foods for the sanctuary (Food, Qty) ******");
    System.out.println(printShoppingList(sanctuary.getShoppingList()));

    /* Get Alphabetical list of species with housing. */
    System.out.println("****** Alphabetical list of species with housing ******");
    try {
      System.out.println(printSpeciesList(sanctuary.getAlphabeticalSpeciesList()));
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    /* Look up housing of a particular species in sanctuary by giving their species */
    System.out.println("****** Look Up housing details for a species ******");
    try {
      System.out.println(printSpeciesList(sanctuary.lookUpSpecies("Mangabey")));
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }

  private static String printAlphabeticalMonkeyList(List<Primate> arr) {
    StringBuilder str = new StringBuilder();
    if (arr.isEmpty()) {
      str.append("No monkey currently housed in the sanctuary");
    } else {
      for (int i = 0; i < arr.size(); i++) {
        System.out.println("Name: " + arr.get(i).getName() + " housing: " + arr.get(i).getHousing()
                + " Cage No: " + arr.get(i).getHousingNo());
      }
    }
    return str.toString();
  }

  private static String printShoppingList(Map<String, Integer> shoppingList) {
    StringBuilder str = new StringBuilder();
    if (shoppingList.isEmpty()) {
      str.append("No monkey housed, shopping list is empty");
    } else {
      for (Map.Entry<String, Integer> entry : shoppingList.entrySet())
        str.append("Food = " + entry.getKey() +
                ", Quantity = " + entry.getValue() + " gms" + '\n');
    }
    return str.toString();
  }

  private static String printSpeciesList(
          Map<String, Map<String, String>> alphabeticalSpeciesList) throws IllegalArgumentException {
    var str = new StringBuilder();
    for (Map.Entry<String, Map<String, String>> speciesItr : alphabeticalSpeciesList.entrySet()) {
      str.append("Species: " + speciesItr.getKey() + " |");
      for (Map.Entry<String, String> housingItr : speciesItr.getValue().entrySet()) {
        str.append(" " + housingItr.getKey() + ": " + housingItr.getValue());
      }
      str.append('\n');
    }
    return str.toString();
  }


}
