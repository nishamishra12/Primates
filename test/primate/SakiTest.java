package primate;

import org.junit.Before;
import org.junit.Test;

import jungleprimatesanctuary.Food;
import jungleprimatesanctuary.MonkeyFactory;
import jungleprimatesanctuary.Primate;
import jungleprimatesanctuary.Sex;
import jungleprimatesanctuary.Size;

import static org.junit.Assert.*;

/**
 * Testing for Saki class
 */
public class SakiTest {

  private Primate primate;

  @Before
  public void setUp() throws Exception {
    primate = MonkeyFactory.createMonkey("Blim", Size.MEDIUM.getSizeDescription(), Sex.FEMALE.getSex()
            , 40, 100, Food.EGGS.foodName(), Size.MEDIUM.getFoodQuantity()
            , Size.MEDIUM.getSpaceRequirement(), "Saki");
  }

  @Test
  public void getSpecies() {
    assertEquals("Check species type","Saki", primate.getSpecies());
  }
}