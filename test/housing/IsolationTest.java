package housing;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import jungleprimatesanctuary.Food;
import jungleprimatesanctuary.Housing;
import jungleprimatesanctuary.Isolation;
import jungleprimatesanctuary.MonkeyFactory;
import jungleprimatesanctuary.Primate;
import jungleprimatesanctuary.Sex;
import jungleprimatesanctuary.Size;

import static org.junit.Assert.assertEquals;

/**
 * Test to check all the implementation of housing in isolation.
 */
public class IsolationTest {

  private MonkeyFactory monkeyFactory;
  private Primate p;
  private Housing isolation = new Isolation(5);

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
          , String favFood, int foodReq, int spaceReq, String speciesType){
    return monkeyFactory.createMonkey(name, size, sex, age, weight
            , favFood, foodReq, spaceReq, speciesType);
  }

  @Test
  public void addMonkey() {
    isolation.addMonkey(p);
    assertEquals("Monkey should be added to isolation", "Isolation",
            isolation.getHousingList().get(0).get(0).getHousing());
    assertEquals("Check size of isolation", 1,
            isolation.getHousingList().get(0).size());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testForNullPrimateObject() {
    isolation.addMonkey(null);
  }

  @Test(expected = IllegalStateException.class)
  public void testForNoSpaceInIsolation() {
    isolation = new Isolation(1);
    p = createPrimateObject("Jake", Size.MEDIUM.getSizeDescription(), Sex.FEMALE.getSex()
            , 40, 100, Food.EGGS.foodName(), Size.MEDIUM.getFoodQuantity()
            , Size.MEDIUM.getSpaceRequirement(), "Drill");
    isolation.addMonkey(p);
    p = createPrimateObject("Blim", Size.MEDIUM.getSizeDescription(), Sex.FEMALE.getSex()
            , 40, 100, Food.EGGS.foodName(), Size.MEDIUM.getFoodQuantity()
            , Size.MEDIUM.getSpaceRequirement(), "Howler");
    isolation.addMonkey(p);
  }

  @Test
  public void getHousingList() {
    List<Primate> primateList = new ArrayList<>();
    primateList.add(p);
    isolation.addMonkey(p);
    assertEquals("Check if both the lists are equal", primateList,
            isolation.getHousingList().get(0));
    assertEquals("Check size of both the lists are equal", primateList.size(),
            isolation.getHousingList().get(0).size());
  }

  @Test
  public void removeMonkey() {
    isolation.addMonkey(p);
    assertEquals("Isolation list should be of size one", 1,
            isolation.getHousingList().get(0).size());
    /* Removing the added monkey from isolation. */
    isolation.removeMonkey(p);
    assertEquals("Isolation list should be of size 0", 0,
            isolation.getHousingList().get(0).size());
  }

  @Test (expected = IllegalArgumentException.class)
  public void testForRemovingWrongMonkey() {
    isolation.removeMonkey(null);
  }

  @Test (expected = IllegalStateException.class)
    public void testForRemovingMonkeyFromEmptyList() {
    isolation.removeMonkey(p);
  }

  @Test (expected = IllegalArgumentException.class)
    public void testForRemovingNotPresentPrimate() {
    isolation.addMonkey(p);
     p = createPrimateObject("Janice", Size.MEDIUM.getSizeDescription(), Sex.FEMALE.getSex()
            , 40, 100, Food.EGGS.foodName(), Size.MEDIUM.getFoodQuantity()
            , Size.MEDIUM.getSpaceRequirement(), "Drill");
     isolation.removeMonkey(p);
    }
  }
