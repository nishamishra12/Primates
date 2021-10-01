package sanctuary;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import jungleprimatesanctuary.Food;
import jungleprimatesanctuary.MonkeyFactory;
import jungleprimatesanctuary.Sanctuary;
import jungleprimatesanctuary.SanctuaryInterface;
import jungleprimatesanctuary.Sex;
import jungleprimatesanctuary.Size;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Class for testing sanctuary class.
 */
public class SanctuaryTest {

  private final SanctuaryInterface sanctuary;

  public SanctuaryTest() {
    sanctuary = new Sanctuary(new MonkeyFactory(), 7, 4);
  }

  @Before
  public void setUp() {

    sanctuary.createNewPrimate("Blim", Size.MEDIUM.getSizeDescription(), Sex.FEMALE.getSex()
            , 40, 100, Food.EGGS.foodName(), Size.MEDIUM.getFoodQuantity()
            , Size.MEDIUM.getSpaceRequirement(), "Drill");
    sanctuary.createNewPrimate("Tom", Size.LARGE.getSizeDescription(), Sex.MALE.getSex()
            , 55, 200, Food.FRUITS.foodName(), Size.LARGE.getFoodQuantity()
            , Size.LARGE.getSpaceRequirement(), "Spider");
    sanctuary.createNewPrimate("Bob", Size.LARGE.getSizeDescription(), Sex.MALE.getSex()
            , 50, 225, Food.TREE_SAP.foodName(), Size.LARGE.getFoodQuantity()
            , Size.LARGE.getSpaceRequirement(), "Squirrel");
    sanctuary.createNewPrimate("Black", Size.SMALL.getSizeDescription(), Sex.FEMALE.getSex()
            , 40, 100, Food.EGGS.foodName(), Size.SMALL.getFoodQuantity()
            , Size.SMALL.getSpaceRequirement(), "Drill");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testForNegativeIsolationSize() {
    new Sanctuary(new MonkeyFactory(), -7, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testForNegativeEnclosureSize() {
    new Sanctuary(new MonkeyFactory(), 7, -4);
  }

  /**
   * Test to check new primate object creation and if it is moved directly to isolation.
   */
  @Test
  public void createNewPrimate() {
    sanctuary.createNewPrimate("Jimmy", Size.SMALL.getSizeDescription(), Sex.FEMALE.getSex()
            , 40, 100, Food.EGGS.foodName(), Size.SMALL.getFoodQuantity()
            , Size.SMALL.getSpaceRequirement(), "Drill");
    assertEquals("Isolation", sanctuary.findMonkey("Jimmy").getHousing());
  }

  @Test(expected = IllegalArgumentException.class)
  public void createNewPrimateNoDuplicateEntry() {
    /* Bob already exists, so the method should throw exception and test should pass */
    sanctuary.createNewPrimate("Bob", Size.SMALL.getSizeDescription(), Sex.FEMALE.getSex()
            , 40, 100, Food.EGGS.foodName(), Size.SMALL.getFoodQuantity()
            , Size.SMALL.getSpaceRequirement(), "Drill");
  }

  @Test(expected = IllegalArgumentException.class)
  public void createNewPrimateNegativeAge() {
    /* Bob already exists, so the method should throw exception and test should pass */
    sanctuary.createNewPrimate("Bob", Size.SMALL.getSizeDescription(), Sex.FEMALE.getSex()
            , -40, 100, Food.EGGS.foodName(), Size.SMALL.getFoodQuantity()
            , Size.SMALL.getSpaceRequirement(), "Drill");
  }

  @Test(expected = IllegalArgumentException.class)
  public void createNewPrimateNegativeWeight() {
    /* Bob already exists, so the method should throw exception and test should pass */
    sanctuary.createNewPrimate("Bob", Size.SMALL.getSizeDescription(), Sex.FEMALE.getSex()
            , 40, 100, Food.EGGS.foodName(), Size.SMALL.getFoodQuantity()
            , Size.SMALL.getSpaceRequirement(), "Drill");
  }

  @Test(expected = IllegalArgumentException.class)
  public void createNewPrimateNullSize() {
    /* Bob already exists, so the method should throw exception and test should pass */
    sanctuary.createNewPrimate("Bob", Size.SMALL.getSizeDescription(), null
            , 40, 100, Food.EGGS.foodName(), Size.SMALL.getFoodQuantity()
            , Size.SMALL.getSpaceRequirement(), "Drill");
  }

  @Test(expected = IllegalArgumentException.class)
  public void createNewPrimateNullFavFood() {
    /* Bob already exists, so the method should throw exception and test should pass */
    sanctuary.createNewPrimate("Bob", Size.SMALL.getSizeDescription(), Sex.FEMALE.getSex()
            , 40, 100, null, Size.SMALL.getFoodQuantity()
            , Size.SMALL.getSpaceRequirement(), "Drill");
  }

  @Test(expected = IllegalArgumentException.class)
  public void createNewPrimateNegativeFoodRequirement() {
    /* Bob already exists, so the method should throw exception and test should pass */
    sanctuary.createNewPrimate("Bob", Size.SMALL.getSizeDescription(), Sex.FEMALE.getSex()
            , 40, 100, Food.EGGS.foodName(), -4
            , Size.SMALL.getSpaceRequirement(), "Drill");
  }

  @Test(expected = IllegalArgumentException.class)
  public void createNewPrimateNegativeSpaceRequirement() {
    /* Bob already exists, so the method should throw exception and test should pass */
    sanctuary.createNewPrimate("Bob", Size.SMALL.getSizeDescription(), Sex.FEMALE.getSex()
            , 40, 100, Food.EGGS.foodName(), Size.SMALL.getFoodQuantity()
            , -8, "Drill");
  }

  @Test(expected = IllegalArgumentException.class)
  public void createNewPrimateNullSe() {
    /* Bob already exists, so the method should throw exception and test should pass */
    sanctuary.createNewPrimate("Bob", null, Sex.FEMALE.getSex()
            , 40, -100, Food.EGGS.foodName(), Size.SMALL.getFoodQuantity()
            , Size.SMALL.getSpaceRequirement(), "Drill");
  }

  @Test(expected = IllegalArgumentException.class)
  public void createNewPrimateNullName() {
    /* Name should not be null, so the method should throw exception and test should pass */
    sanctuary.createNewPrimate(null, Size.SMALL.getSizeDescription(), Sex.FEMALE.getSex()
            , 40, 100, Food.EGGS.foodName(), Size.SMALL.getFoodQuantity()
            , Size.SMALL.getSpaceRequirement(), "Drill");
  }

  @Test
  public void changeMedicalConditionOfMonkey() {

    /* The monkey is in isolation, Change the isHealthy flag to true
     * and check if it shifts to enclosure.
     * */
    sanctuary.changeMedicalConditionOfMonkey("Blim", true);
    assertEquals("Monkey should not move to isolation", "Enclosure",
            sanctuary.findMonkey("Blim").getHousing());

    /* Change the medical condition and test if monkey is shifted.
     * The monkey is in enclosure, and isHealthy flag is true,
     * giving false should shift the monkey from enclosure to isolation.
     * */
    sanctuary.changeMedicalConditionOfMonkey("Blim", false);
    assertEquals("Monkey should move to isolation", "Isolation",
            sanctuary.findMonkey("Blim").getHousing());
  }

  /**
   * Test to check if a user is changing medical condition of a non-existent monkey,
   * method should throw IllegalArgumentException.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testForNonExistentMonkeyMedicalCondition() {
    sanctuary.changeMedicalConditionOfMonkey("Alia", true);
  }

  /**
   * Test to check if a user is changing medical condition by entering null monkey,
   * method should throw NullPointerException.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testForNullMonkeyMedicalCondition() {
    sanctuary.changeMedicalConditionOfMonkey(null, true);
  }

  /* keep the medical condition same and test if monkey is not shifted
   * The monkey is in isolation, and isHealthy flag is false,
   * giving false again should not shift the monkey from isolation to enclosure
   * */
  @Test(expected = IllegalStateException.class)
  public void testForSameHousingMedicalCondition() {
    sanctuary.changeMedicalConditionOfMonkey("Blim", false);
  }

  @Test
  public void getAlphabeticalListOfMonkeys() {
    assertEquals("Black", sanctuary.getAlphabeticalListOfMonkeys().get(0).getName());
    assertEquals("Blim", sanctuary.getAlphabeticalListOfMonkeys().get(1).getName());
    assertEquals("Bob", sanctuary.getAlphabeticalListOfMonkeys().get(2).getName());
    assertEquals("Tom", sanctuary.getAlphabeticalListOfMonkeys().get(3).getName());
  }

  @Test
  public void getEnclosureSign() {
    /* First move monkey to enclosure, then check assert condition. */
    sanctuary.changeMedicalConditionOfMonkey("Blim", true);
    assertEquals("Enclosure sign for Cage 0\n" +
            "Monkey Name: Blim\n" +
            "Sex: FEMALE\n" +
            "Favorite Food: EGGS\n" +
            "--------------------------" + '\n', sanctuary.getEnclosureSign(0));
    sanctuary.changeMedicalConditionOfMonkey("Tom", true);
    assertEquals("Enclosure sign for Cage 1\n" +
            "Monkey Name: Tom\n" +
            "Sex: MALE\n" +
            "Favorite Food: FRUITS\n" +
            "--------------------------\n", sanctuary.getEnclosureSign(1));
    sanctuary.changeMedicalConditionOfMonkey("Tom", false);
    sanctuary.changeMedicalConditionOfMonkey("Black", true);
    assertEquals("Enclosure sign for Cage 0\n" +
            "Monkey Name: Blim\n" +
            "Sex: FEMALE\n" +
            "Favorite Food: EGGS\n" +
            "--------------------------\n" +
            "Monkey Name: Black\n" +
            "Sex: FEMALE\n" +
            "Favorite Food: EGGS\n" +
            "--------------------------\n", sanctuary.getEnclosureSign(0));
  }

  /**
   * If Cage No. entered is greater than the number of cages in Isolation.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testForCageNoNotInEnclosure() {
    sanctuary.getEnclosureSign(7);
  }

  @Test
  public void getShoppingList() {
    Map<String, Integer> shoppingList = new HashMap<>();
    shoppingList.put("EGGS", 350);
    shoppingList.put("FRUITS", 500);
    shoppingList.put("TREE SAP", 500);
    assertEquals(shoppingList, sanctuary.getShoppingList());

    shoppingList = new HashMap<>();
    shoppingList.put("EGGS", 200);
    shoppingList.put("FRUITS", 500);
    shoppingList.put("TREE SAP", 500);
    assertNotEquals(shoppingList, sanctuary.getShoppingList());
  }

  @Test
  public void getAlphabeticalSpeciesList() {
    Map<String, Map<String, String>> alphabeticalSpeciesList
            = new HashMap<>();
    /* Changing medical condition of a monkey and moving it to enclosure */
    sanctuary.changeMedicalConditionOfMonkey("Black", true);
    Map<String, String> map = new HashMap<>();
    map.put("Isolation", "Cage No: 1");
    map.put("Enclosure", "Cage No: 1");
    alphabeticalSpeciesList.put("Drill", map);
    map = new HashMap<>();
    map.put("Isolation", "Cage No: 2");
    alphabeticalSpeciesList.put("Spider", map);
    map = new HashMap<>();
    map.put("Isolation", "Cage No: 3");
    alphabeticalSpeciesList.put("Squirrel", map);
    /* List should return the order of Drill, Spider, Squirrel along with correct housing */
    assertEquals(alphabeticalSpeciesList, sanctuary.getAlphabeticalSpeciesList());
  }

  @Test
  public void lookUpSpecies() {
    Map<String, Map<String, String>> speciesMap = new HashMap<>();
    Map<String, String> map = new HashMap<>();
    /* Check a species which is in multiple cages of isolation */
    map.put("Isolation", "Cage No: 1, 4");
    speciesMap.put("Drill", map);
    assertEquals(speciesMap, sanctuary.lookUpSpecies("Drill"));

    /* Changing medical condition of a monkey and moving it to enclosure */
    sanctuary.changeMedicalConditionOfMonkey("Black", true);
    map = new HashMap<>();
    map.put("Isolation", "Cage No: 1");
    map.put("Enclosure", "Cage No: 1");
    speciesMap.put("Drill", map);
    /* Check a monkey which is in multiple housing */
    assertEquals(speciesMap, sanctuary.lookUpSpecies("Drill"));

    /* Changing medical condition of a monkey and moving it to enclosure */
    sanctuary.changeMedicalConditionOfMonkey("Blim", true);
    /* Check for a species consisting of multiple primates which is in same cages of enclosure */
    map = new HashMap<>();
    map.put("Enclosure", "Cage No: 1");
    speciesMap.put("Drill", map);
    assertEquals(speciesMap, sanctuary.lookUpSpecies("Drill"));
  }

  /* Check a monkey which is not present */
  @Test(expected = IllegalArgumentException.class)
  public void testLookUpSpeciesWithoutHousing() {
    sanctuary.lookUpSpecies("Howler");
  }

  @Test
  public void testFindMonkeyDetailsByName() {
    assertEquals("Tom", sanctuary.findMonkey("Tom").getName());
    assertEquals("Isolation", sanctuary.findMonkey("Tom").getHousing());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testForFindMonkeyIncorrectName() {
    sanctuary.findMonkey("Lolly");
  }

  @Test (expected = IllegalArgumentException.class)
  public void testForUpdateNegativeIsolationSize() {
    sanctuary.updateHousingSize(-2,6);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testForUpdateNegativeEnclosureSize() {
    sanctuary.updateHousingSize(7,-2);
  }

  @Test
  public void updateHousingSize() {
    sanctuary.updateHousingSize(8,6);
    assertEquals(8,sanctuary.getIsolation().getHousingSize());
    assertEquals(6,sanctuary.getEnclosure().getHousingSize());
  }
}