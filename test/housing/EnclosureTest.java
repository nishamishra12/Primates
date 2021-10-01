package housing;

import org.junit.Before;
import org.junit.Test;

import jungleprimatesanctuary.Enclosure;
import jungleprimatesanctuary.Food;
import jungleprimatesanctuary.Housing;
import jungleprimatesanctuary.MonkeyFactory;
import jungleprimatesanctuary.Primate;
import jungleprimatesanctuary.Sex;
import jungleprimatesanctuary.Size;

import static org.junit.Assert.assertEquals;

/**
 * Test to check all the implementation of housing in isolation.
 */
public class EnclosureTest {

  private MonkeyFactory monkeyFactory;
  private Primate p;
  private Housing enclosure = new Enclosure(5);

  @Before
  public void setUp() throws Exception {
    p = createPrimateObject("Blim", Size.MEDIUM.getSizeDescription(), Sex.FEMALE.getSex()
            , 40, 100, Food.EGGS.foodName(), Size.MEDIUM.getFoodQuantity()
            , Size.MEDIUM.getSpaceRequirement(), "Drill");
  }

  /**
   * Creates a new primate object everytime it is called.
   */
  protected Primate createPrimateObject(String name, String size, String sex, int age, double weight
          , String favFood, int foodReq, int spaceReq, String speciesType) {
    return monkeyFactory.createMonkey(name, size, sex, age, weight
            , favFood, foodReq, spaceReq, speciesType);
  }

  @Test
  public void addMonkey() {
    /* Add primate to empty list. */
    enclosure = new Enclosure(5);
    enclosure.addMonkey(p);
    assertEquals("Added new primate, check housing type","Enclosure", enclosure.getHousingList().get(0).get(0).getHousing());
    assertEquals("Added new primate, check cage no.",1, enclosure.getHousingList().get(0).get(0).getHousingNo());

    /* Add new monkey of the same species to enclosure. */
    p = createPrimateObject("Blake", Size.MEDIUM.getSizeDescription(), Sex.MALE.getSex()
            , 40, 100, Food.FRUITS.foodName(), Size.MEDIUM.getFoodQuantity()
            , Size.MEDIUM.getSpaceRequirement(), "Drill");
    enclosure.addMonkey(p);
    assertEquals("Added new monkey of same species, check cage no",1, enclosure.getHousingList().get(0).get(1).getHousingNo());
    assertEquals("Added new monkey of same species, check troop size",2, enclosure.getHousingList().get(0).size());

    /* Add new primate of different species. Check if it gets added to a different cage */
    p = createPrimateObject("Janice", Size.MEDIUM.getSizeDescription(), Sex.FEMALE.getSex()
            , 40, 100, Food.FRUITS.foodName(), Size.MEDIUM.getFoodQuantity()
            , Size.MEDIUM.getSpaceRequirement(), "Howler");
    enclosure.addMonkey(p);
    assertEquals("Added new monkey of different species, check cage no",2, enclosure.getHousingList().size());
    assertEquals("Added new monkey of different species, check no of full cages in enclosure list",2, enclosure.getHousingList().get(1).get(0).getHousingNo());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testForNullPrimateObject() {
    enclosure.addMonkey(null);
  }

  @Test(expected = IllegalStateException.class)
  public void testForNoSpaceInEnclosure() {
    enclosure = new Enclosure(1);
    p = createPrimateObject("Jake", Size.MEDIUM.getSizeDescription(), Sex.FEMALE.getSex()
            , 40, 100, Food.EGGS.foodName(), Size.MEDIUM.getFoodQuantity()
            , Size.MEDIUM.getSpaceRequirement(), "Drill");
    enclosure.addMonkey(p);
    p = createPrimateObject("Blim", Size.MEDIUM.getSizeDescription(), Sex.FEMALE.getSex()
            , 40, 100, Food.EGGS.foodName(), Size.MEDIUM.getFoodQuantity()
            , Size.MEDIUM.getSpaceRequirement(), "Spider");
    enclosure.addMonkey(p);
  }

  @Test
  public void getHousingList() {
  enclosure.addMonkey(p);
  assertEquals("Check size of enclosure list after adding a monkey", 1, enclosure.getHousingList().size());
  }

  @Test
  public void removeMonkey() {
    enclosure.addMonkey(p);
    assertEquals("Check size after adding primate",1,enclosure.getHousingList().size());
    enclosure.removeMonkey(p);
    assertEquals("Check size of enclosure after removing primate",true,enclosure.getHousingList().isEmpty());
  }
}