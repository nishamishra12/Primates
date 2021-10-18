package jungleprimatesanctuary;

import java.util.List;
import java.util.Map;

/**
 * This a driver class which acts like a user input for the project.
 */
public class JunglePrimateDriver {

  /**
   * This is a main class which will be used to start the driver class.
   *
   * @param args Args can be provided as any
   */
  public static void main(String[] args) {

    System.out.println("------------- Run 1 --------------");
    System.out.println("****** Creating a new sanctuary ******");
    SanctuaryInterface sanctuary = new Sanctuary(5, 7);
    System.out.println("Sanctuary created with Isolation Size: "
            + sanctuary.getIsolation().getHousingSize() + " and Enclosure Size: "
            + sanctuary.getEnclosure().getHousingSize());

    try {
      sanctuary.createNewPrimate("Blim", Size.MEDIUM.getSizeDescription(),
              Sex.FEMALE.getSex(), 40, 100, Food.EGGS.foodName(),
              Size.MEDIUM.getFoodQuantity(), Size.MEDIUM.getSpaceRequirement(), "Drill");
      System.out.println("Monkey with name Blim created");
      sanctuary.createNewPrimate("Bob", Size.LARGE.getSizeDescription(),
              Sex.MALE.getSex(), 55, 200, Food.FRUITS.foodName(),
              Size.LARGE.getFoodQuantity(), Size.LARGE.getSpaceRequirement(), "Spider");
      System.out.println("Monkey with name Bob created");
      sanctuary.createNewPrimate("Chan", Size.MEDIUM.getSizeDescription(), Sex.MALE.getSex(),
              35, 120, Food.NUTS.foodName(), Size.MEDIUM.getFoodQuantity(),
              Size.LARGE.getSpaceRequirement(), "Spider");
      System.out.println("Monkey with name Chan created");
      sanctuary.createNewPrimate("Lily", Size.SMALL.getSizeDescription(), Sex.FEMALE.getSex(),
              25, 50, Food.INSECTS.foodName(), Size.SMALL.getFoodQuantity(),
              Size.SMALL.getSpaceRequirement(), "Mangabey");
      System.out.println("Monkey with name Lily created");
      sanctuary.createNewPrimate("Lake", Size.LARGE.getSizeDescription(), Sex.MALE.getSex(),
              30, 300, Food.LEAVES.foodName(), Size.LARGE.getFoodQuantity(),
              Size.SMALL.getSpaceRequirement(), "Mangabey");
      System.out.println("Monkey with name Lake created");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    } catch (IllegalStateException s) {
      System.out.println(s.getMessage());
    }


    /* Create monkey with already existing name*/
    try {
      sanctuary.createNewPrimate("Lake", Size.LARGE.getSizeDescription(), Sex.MALE.getSex(),
              30, 300, Food.LEAVES.foodName(), Size.LARGE.getFoodQuantity(),
              Size.SMALL.getSpaceRequirement(), "Mangabey");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    /* Get Alphabetical List of all monkey's in sanctuary with their housing */
    System.out.println('\n' + "****** Alphabetical list of monkey's "
            + "along with their housing *******");
    System.out.println(printAlphabeticalMonkeyList(sanctuary.getAlphabeticalListOfMonkeys()));

    /* Change Medical Health of any monkey in the sanctuary by its name*/
    try {
      sanctuary.changeMedicalConditionOfMonkey("Bob", true);
      System.out.println("Medical condition of Bob changed to true");
      sanctuary.changeMedicalConditionOfMonkey("Lily", true);
      System.out.println("Medical condition of Lily changed to true");
      sanctuary.changeMedicalConditionOfMonkey("Lake", true);
      System.out.println("Medical condition of Lake changed to true");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    } catch (IllegalStateException s) {
      System.out.println(s.getMessage());
    }

    /* Get Alphabetical List of all monkey's in sanctuary with their housing */
    System.out.println('\n' + "****** Alphabetical list of monkey's "
            + "along with their housing *******");
    System.out.println(printAlphabeticalMonkeyList(sanctuary.getAlphabeticalListOfMonkeys()));

    /* Get Enclosure Sign --- Sign Contains: Name, Sex, Favorite Food */
    System.out.println('\n' + "****** Enclosure sign for any cage includes Name, "
            + "Sex, and Favorite food ******");
    try {
      System.out.println(sanctuary.getEnclosureSign(1));
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    /* Get Shopping List of all favorite foods for the sanctuary */
    System.out.println("****** Shopping List of all favorite foods for "
            + "the sanctuary (Food, Qty) ******");
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

    System.out.println("------------- Run 2 --------------");
    sanctuary = new Sanctuary( 2, 2);

    System.out.println("Initial Size of enclosure and isolation: "
            + sanctuary.getIsolation().getHousingSize() + " and Enclosure Size: "
            + sanctuary.getEnclosure().getHousingSize());
    System.out.println("Update size of sanctuary");
    try {
      sanctuary.updateHousingSize(3, 3);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
    System.out.println("Change size of isolation and enclosure: "
            + sanctuary.getIsolation().getHousingSize() + " and Enclosure Size: "
            + sanctuary.getEnclosure().getHousingSize());

    try {
      sanctuary.createNewPrimate("Jake", Size.MEDIUM.getSizeDescription(),
              Sex.FEMALE.getSex(), 40, 100, Food.EGGS.foodName(),
              Size.MEDIUM.getFoodQuantity(), Size.MEDIUM.getSpaceRequirement(), "Drill");
      System.out.println("Monkey with name Jake created");
      sanctuary.createNewPrimate("Amy", Size.LARGE.getSizeDescription(),
              Sex.MALE.getSex(), 55, 200, Food.FRUITS.foodName(),
              Size.LARGE.getFoodQuantity(), Size.LARGE.getSpaceRequirement(), "Spider");
      System.out.println("Monkey with name Amy created");
      sanctuary.createNewPrimate("Danu", Size.LARGE.getSizeDescription(), Sex.MALE.getSex(),
              30, 300, Food.LEAVES.foodName(), Size.LARGE.getFoodQuantity(),
              Size.SMALL.getSpaceRequirement(), "Saki");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    } catch (IllegalStateException s) {
      System.out.println(s.getMessage());
    }

    /* Get Alphabetical List of all monkey's in sanctuary with their housing */
    System.out.println('\n' + "****** Alphabetical list of monkey's "
            + "along with their housing *******");
    System.out.println(printAlphabeticalMonkeyList(sanctuary.getAlphabeticalListOfMonkeys()));

    /* Trying adding one more monkey*/
    System.out.println("Trying to add one more monkey");
    try {
      sanctuary.createNewPrimate("Chimpu", Size.LARGE.getSizeDescription(), Sex.MALE.getSex(),
              30, 300, Food.LEAVES.foodName(), Size.LARGE.getFoodQuantity(),
              Size.SMALL.getSpaceRequirement(), "Mangabey");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    } catch (IllegalStateException s) {
      System.out.println(s.getMessage());
    }

    /* Change Medical Health of any monkey in the sanctuary by its name*/
    System.out.println("Change the medical condition of a monkey in isolation to false");
    try {
      sanctuary.changeMedicalConditionOfMonkey("Jake", false);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    } catch (IllegalStateException s) {
      System.out.println(s.getMessage());
    }

    /* Get Enclosure Sign --- Sign Contains: Name, Sex, Favorite Food */
    System.out.println('\n' + "****** Enclosure sign for any cage includes Name, "
            + "Sex, and Favorite food ******");
    try {
      System.out.println(sanctuary.getEnclosureSign(1));
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    /* Get Shopping List of all favorite foods for the sanctuary */
    System.out.println("****** Shopping List of all favorite foods for "
            + "the sanctuary (Food, Qty) ******");
    System.out.println(printShoppingList(sanctuary.getShoppingList()));

    /* Look up housing of a particular species in sanctuary by giving their species */
    System.out.println("****** Look Up housing details for a species ******");
    try {
      System.out.println(printSpeciesList(sanctuary.lookUpSpecies("Mangabey")));
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    System.out.println("------------- Run 3 --------------");
    System.out.println("****** Creating a new sanctuary ******");
    sanctuary = new Sanctuary(2, 2);
    System.out.println("Sanctuary created with Isolation Size: "
            + sanctuary.getIsolation().getHousingSize() + " and Enclosure Size: "
            + sanctuary.getEnclosure().getHousingSize());

    /* Create monkey with negative age name*/
    try {
      sanctuary.createNewPrimate("Blim", Size.MEDIUM.getSizeDescription(),
              Sex.FEMALE.getSex(), -40, 100, Food.EGGS.foodName(),
              Size.MEDIUM.getFoodQuantity(), Size.MEDIUM.getSpaceRequirement(), "Drill");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    } catch (IllegalStateException s) {
      System.out.println(s.getMessage());
    }

    /* Create monkey with null name*/
    try {
      sanctuary.createNewPrimate(null, Size.MEDIUM.getSizeDescription(),
              Sex.FEMALE.getSex(), 40, 100, Food.EGGS.foodName(),
              Size.MEDIUM.getFoodQuantity(), Size.MEDIUM.getSpaceRequirement(), "Drill");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    } catch (IllegalStateException s) {
      System.out.println(s.getMessage());
    }

    /* Create monkey with negative weight name*/
    try {
      sanctuary.createNewPrimate("Dock", Size.MEDIUM.getSizeDescription(),
              Sex.FEMALE.getSex(), 40, -100, Food.EGGS.foodName(),
              Size.MEDIUM.getFoodQuantity(), Size.MEDIUM.getSpaceRequirement(), "Drill");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    } catch (IllegalStateException s) {
      System.out.println(s.getMessage());
    }

    /* Create monkey with wrong species*/
    try {
      sanctuary.createNewPrimate("Jin", Size.MEDIUM.getSizeDescription(),
              Sex.FEMALE.getSex(), 40, 100, Food.EGGS.foodName(),
              Size.MEDIUM.getFoodQuantity(), Size.MEDIUM.getSpaceRequirement(), "abc");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    } catch (IllegalStateException s) {
      System.out.println(s.getMessage());
    }

    try {
      sanctuary.createNewPrimate("Jin", Size.MEDIUM.getSizeDescription(),
              Sex.FEMALE.getSex(), 40, 100, Food.EGGS.foodName(),
              Size.MEDIUM.getFoodQuantity(), Size.MEDIUM.getSpaceRequirement(), "Drill");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    } catch (IllegalStateException s) {
      System.out.println(s.getMessage());
    }

    /* Get Alphabetical List of all monkey's in sanctuary with their housing */
    System.out.println('\n' + "****** Alphabetical list of monkey's "
            + "along with their housing *******");
    System.out.println(printAlphabeticalMonkeyList(sanctuary.getAlphabeticalListOfMonkeys()));

    /* Get Shopping List of all favorite foods for the sanctuary */
    System.out.println("****** Shopping List of all favorite foods for "
            + "the sanctuary (Food, Qty) ******");
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
      System.out.println(printSpeciesList(sanctuary.lookUpSpecies("Drill")));
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    System.out.println("****** Look Up housing details for species not present ******");
    try {
      System.out.println(printSpeciesList(sanctuary.lookUpSpecies("Saki")));
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
      for (Map.Entry<String, Integer> entry : shoppingList.entrySet()) {
        str.append("Food = " + entry.getKey() + ", Quantity = " + entry.getValue() + " gms" + '\n');
      }
    }
    return str.toString();
  }

  private static String printSpeciesList(
          Map<String, Map<String, String>> alphabeticalSpeciesList)
          throws IllegalArgumentException {
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
