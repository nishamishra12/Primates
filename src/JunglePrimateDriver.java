import java.util.List;

import JunglePrimateSanctuary.Food;
import JunglePrimateSanctuary.MonkeyFactoryImpl;
import JunglePrimateSanctuary.Primate;
import JunglePrimateSanctuary.Sanctuary;
import JunglePrimateSanctuary.Sex;
import JunglePrimateSanctuary.Size;

public class JunglePrimateDriver {

  public static void main(String[] args) {

    Sanctuary sanctuary = new Sanctuary(new MonkeyFactoryImpl(), 7, 4);

    /**create new monkeys, new monkeys will always go to Isolation.
     * Enter Housing values null as user doesn't know the type of housing or cage no
     */
    sanctuary.createNewPrimate("Blim", Size.MEDIUM.getSizeDescription(), Sex.FEMALE.getSex()
            , 40, 100, Food.EGGS.foodName(), Size.MEDIUM.getFoodQty()
            , Size.MEDIUM.getSpace(), "Drill", false, null, 0);
    sanctuary.createNewPrimate("Bob", Size.LARGE.getSizeDescription(), Sex.MALE.getSex()
            , 55, 200, Food.FRUITS.foodName(), Size.LARGE.getFoodQty()
            , Size.LARGE.getSpace(), "Spider", false, null, 0);
    sanctuary.createNewPrimate("Tom", Size.LARGE.getSizeDescription(), Sex.MALE.getSex()
            , 50, 225, Food.TREE_SAP.foodName(), Size.LARGE.getFoodQty()
            , Size.LARGE.getSpace(), "Squirrel", false, null, 0);
    sanctuary.createNewPrimate("Chan", Size.MEDIUM.getSizeDescription(), Sex.MALE.getSex()
            , 35, 120, Food.NUTS.foodName(), Size.MEDIUM.getFoodQty()
            , Size.LARGE.getSpace(), "Spider", true, null, 0);
    sanctuary.createNewPrimate("Lily", Size.SMALL.getSizeDescription(), Sex.FEMALE.getSex()
            , 25, 50, Food.INSECTS.foodName(), Size.SMALL.getFoodQty()
            , Size.SMALL.getSpace(), "Mangabey", false, null, 0);
    sanctuary.createNewPrimate("Lake", Size.LARGE.getSizeDescription(), Sex.MALE.getSex()
            , 30, 300, Food.LEAVES.foodName(), Size.LARGE.getFoodQty()
            , Size.SMALL.getSpace(), "Mangabey", false, null, 0);
    //System.out.println("Yay created new primate "+ p.getMedicalCondition());

    //Change Medical Health of monkey
    sanctuary.changeMedicalConditionOfMonkey("Bob", true);
    sanctuary.changeMedicalConditionOfMonkey("Lily", true);
    sanctuary.changeMedicalConditionOfMonkey("Lake", true);

    //Alphabetical List of Monkey
    System.out.println("Alphabetical list of monkey's along with their housing");
    System.out.println(printAlphabeticalMonkeyList(sanctuary.getAlphabeticalListOfMonkeys()));

    //Get Enclosure Sign --- Sign Contains: Name, Sex, Favorite Food
    System.out.println("Enclosure sign any enclosure. Includes Name, Sex, and Favorite food.");
    System.out.println(sanctuary.getEnclosureSign(1));

    //Get Shopping List of all favorite foods for the sanctuary
    System.out.println("*******Shopping List of all favorite foods for the Sanctuary (Food, Qty) ********"
            + '\n' + sanctuary.getShoppingList());

    //Get species housing
    System.out.println("---Species Housing---" + '\n' + sanctuary.getAlphabeticalSpeciesList());

    //LookUpSpecies
    System.out.println("Check housing for Mangabey" + '\n' + sanctuary.lookUpSpecies("Mangabey"));
  }

  private static String printAlphabeticalMonkeyList(List<Primate> arr) {
    StringBuilder str = new StringBuilder();
    for (int i = 0; i < arr.size(); i++) {
      System.out.println("Name: " + arr.get(i).getName() + " Housing: " + arr.get(i).getHousing()
              + " Cage No: " + arr.get(i).getHousingNo());
    }
    return str.toString();
  }

}
