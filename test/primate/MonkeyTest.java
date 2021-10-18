package primate;

import org.junit.Before;
import org.junit.Test;

import jungleprimatesanctuary.Food;
import jungleprimatesanctuary.MonkeyFactory;
import jungleprimatesanctuary.Primate;
import jungleprimatesanctuary.Sex;
import jungleprimatesanctuary.Size;

import static org.junit.Assert.assertEquals;

/**
 * Test to check all implementation of Monkey class in primate interface.
 */
public class MonkeyTest {
  private Primate p;
  private MonkeyFactory monkeyFactory;


  @Before
  public void setUp() throws Exception {
    p = createPrimateObject("Blim", Size.MEDIUM.getSizeDescription(), Sex.FEMALE.getSex()
            , 40, 100, Food.EGGS.foodName(), Size.MEDIUM.getFoodQuantity()
            , Size.MEDIUM.getSpaceRequirement(), "Drill");
  }

  protected Primate createPrimateObject(String name, String size, String sex, int age, double weight
          , String favFood, int foodReq, int spaceReq, String speciesType) {
    return monkeyFactory.createMonkey(name, size, sex, age, weight
            , favFood, foodReq, spaceReq, speciesType);
  }

  @Test
  public void getName() {
    assertEquals("Check Name of primate","Blim",p.getName());
  }

  @Test
  public void getSize() {
    assertEquals("Check Size of primate",Size.MEDIUM.getSizeDescription(),p.getSize());
  }

  @Test
  public void getSex() {
    assertEquals("Check Sex of primate",Sex.FEMALE.getSex(),p.getSex());
  }

  @Test
  public void getAge() {
    assertEquals("Check Age of primate",40,p.getAge());
  }

  @Test
  public void getWeight() {
    assertEquals("Check Weight of primate",100,p.getWeight(),0.1);
  }

  @Test
  public void getFavFood() {
    assertEquals("Check Favorite food of primate",Food.EGGS.foodName(),p.getFavFood());
  }

  @Test
  public void getSpaceReq() {
    assertEquals("Check space requirement of primate",
            Size.MEDIUM.getSpaceRequirement(),p.getSpaceReq());
  }

  @Test
  public void getHousing() {
    p.setHousing("Enclosure");
    assertEquals("Check housing type of monkey","Enclosure",p.getHousing());
  }

  @Test
  public void setHousing() {
    p.setHousing("Isolation");
    assertEquals("set housing type of monkey","Isolation",p.getHousing());
  }

  @Test
  public void getHousingNo() {
    p.setHousingNo(6);
    assertEquals(6,p.getHousingNo());

  }

  @Test
  public void setHousingNo() {
    p.setHousingNo(5); /* Set housing number. */
    assertEquals(5,p.getHousingNo());
  }

  @Test
  public void getFoodReq() {
    assertEquals("Check food requirement of the primate",250,p.getFoodReq());
  }
}