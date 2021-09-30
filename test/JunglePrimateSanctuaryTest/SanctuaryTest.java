package JunglePrimateSanctuaryTest;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import JunglePrimateSanctuary.Food;
import JunglePrimateSanctuary.MonkeyFactoryImpl;
import JunglePrimateSanctuary.Primate;
import JunglePrimateSanctuary.Sanctuary;
import JunglePrimateSanctuary.Sex;
import JunglePrimateSanctuary.Size;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class SanctuaryTest {

  Sanctuary sanctuary = new Sanctuary(new MonkeyFactoryImpl(), 7, 4);
  List<Primate> primateList = new ArrayList<>();
  MonkeyFactoryImpl p = new MonkeyFactoryImpl();

  @Before
  public void setUp() throws Exception {

    sanctuary.createNewPrimate("Blim", Size.MEDIUM.getSizeDescription(), Sex.FEMALE.getSex()
            , 40, 100, Food.EGGS.foodName(), Size.MEDIUM.getFoodQty()
            , Size.MEDIUM.getSpace(), "Drill", false, null, 0);
    sanctuary.createNewPrimate("Tom", Size.LARGE.getSizeDescription(), Sex.MALE.getSex()
            , 55, 200, Food.FRUITS.foodName(), Size.LARGE.getFoodQty()
            , Size.LARGE.getSpace(), "Spider", false, null, 0);
    sanctuary.createNewPrimate("Bob", Size.LARGE.getSizeDescription(), Sex.MALE.getSex()
            , 50, 225, Food.TREE_SAP.foodName(), Size.LARGE.getFoodQty()
            , Size.LARGE.getSpace(), "Squirrel", false, null, 0);
    sanctuary.createNewPrimate("Black", Size.SMALL.getSizeDescription(), Sex.FEMALE.getSex()
            , 40, 100, Food.EGGS.foodName(), Size.SMALL.getFoodQty()
            , Size.SMALL.getSpace(), "Drill", false, null, 0);
  }

  @Test
  public void createNewPrimate() {
    sanctuary.createNewPrimate("Jimmy", Size.SMALL.getSizeDescription(), Sex.FEMALE.getSex()
            , 40, 100, Food.EGGS.foodName(), Size.SMALL.getFoodQty()
            , Size.SMALL.getSpace(), "Drill", false, null, 0);
    assertEquals("Check if monkey created and added to isolation", 5,
            sanctuary.getIsolationList().size());
    assertEquals("Isolation",sanctuary.findMonkey("Jimmy").getHousing());
  }

  @Test
  public void changeMedicalConditionOfMonkey() {

    /* keep the medical condition same and test if monkey is not shifted
     * The monkey is in isolation, and isHealthy flag is false,
     * giving false again should not shift the monkey from isolation to enclosure
     * */
    sanctuary.changeMedicalConditionOfMonkey("Blim", false);
    assertEquals("Monkey should stay in Isolation only", "Isolation",
            sanctuary.findMonkey("Blim").getHousing());

    /* Change the medical condition same and test if monkey is shifted
     * The monkey is in isolation, and isHealthy flag is false,
     * giving true shift the monkey from isolation to enclosure
     * */
    sanctuary.changeMedicalConditionOfMonkey("Blim", true);
    assertEquals("Monkey should be removed from Isolation", "Enclosure",
            sanctuary.findMonkey("Blim").getHousing());

    /* The monkey is now in enclosure, keep the isHealthy flag true
     * and check if it stays in enclosure
     * */
    sanctuary.changeMedicalConditionOfMonkey("Blim", true);
    assertEquals("Monkey should not move to isolation", "Enclosure",
            sanctuary.findMonkey("Blim").getHousing());

    /* Change the medical condition and test if monkey is shifted.
     * The monkey is in enclosure, and isHealthy flag is true,
     * giving false should shift the monkey from enclosure to isolation
     * */
    sanctuary.changeMedicalConditionOfMonkey("Blim", false);
    assertEquals("Monkey should not move to isolation", "Isolation",
            sanctuary.findMonkey("Blim").getHousing());
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
    //move to enclosure
    sanctuary.changeMedicalConditionOfMonkey("Blim",true);
    //sanctuary.getEnclosureSign(1);
    assertEquals("Monkey Name: Blim, Sex: FEMALE, Favorite Food: EGGS",sanctuary.getEnclosureSign(0));
    sanctuary.changeMedicalConditionOfMonkey("Tom",true);
    assertEquals("Monkey Name: Tom, Sex: MALE, Favorite Food: FRUITS",sanctuary.getEnclosureSign(1));
    sanctuary.changeMedicalConditionOfMonkey("Tom",false);
    sanctuary.changeMedicalConditionOfMonkey("Black",true);
    assertEquals("Monkey Name: Blim, Sex: FEMALE, Favorite Food: EGGSMonkey Name: Black, Sex: FEMALE, Favorite Food: EGGS",sanctuary.getEnclosureSign(0));
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
    Map<String, String> map = new HashMap<>();
    map.put("Enclosure", "Cage No: ");
    map.put("Isolation", "Cage No: 1, 4");
    alphabeticalSpeciesList.put("Drill", map);
    map = new HashMap<>();
    map.put("Enclosure", "Cage No: ");
    map.put("Isolation", "Cage No: 2");
    alphabeticalSpeciesList.put("Spider", map);
    map = new HashMap<>();
    map.put("Enclosure", "Cage No: ");
    map.put("Isolation", "Cage No: 3");
    alphabeticalSpeciesList.put("Squirrel", map);
    assertEquals(alphabeticalSpeciesList, sanctuary.getAlphabeticalSpeciesList());
  }

  @Test
  public void lookUpSpecies() {
    Map<String, String> map = new HashMap<>();
    //Check Drill
    map.put("Isolation", "Cage No: 1, 3");
    map.put("Enclosure", "Cage No: ");
    sanctuary.createNewPrimate("Blim", Size.MEDIUM.getSizeDescription(), Sex.FEMALE.getSex()
            , 40, 100, Food.EGGS.foodName(), Size.MEDIUM.getFoodQty()
            , Size.MEDIUM.getSpace(), "Drill", false, null, 0);
    sanctuary.createNewPrimate("Tom", Size.LARGE.getSizeDescription(), Sex.MALE.getSex()
            , 55, 200, Food.FRUITS.foodName(), Size.LARGE.getFoodQty()
            , Size.LARGE.getSpace(), "Spider", false, null, 0);
    sanctuary.createNewPrimate("Black", Size.SMALL.getSizeDescription(), Sex.FEMALE.getSex()
            , 40, 100, Food.EGGS.foodName(), Size.SMALL.getFoodQty()
            , Size.SMALL.getSpace(), "Drill", false, null, 0);

    assertEquals(map, sanctuary.lookUpSpecies("Drill"));

    //Check Spider
    map = new HashMap<>();
    map.put("Isolation", "Cage No: 2");
    map.put("Enclosure", "Cage No: ");
    assertEquals(map, sanctuary.lookUpSpecies("Spider"));

    //Check a monkey which is not present
    map = new HashMap<>();
    map.put("Isolation", "Cage No: ");
    map.put("Enclosure", "Cage No: ");
    assertEquals(map, sanctuary.lookUpSpecies("Howler"));
  }
}