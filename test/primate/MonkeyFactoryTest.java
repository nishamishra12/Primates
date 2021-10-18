package primate;

import org.junit.Test;

import jungleprimatesanctuary.Drill;
import jungleprimatesanctuary.Food;
import jungleprimatesanctuary.Guereza;
import jungleprimatesanctuary.Howler;
import jungleprimatesanctuary.Mangabey;
import jungleprimatesanctuary.MonkeyFactory;
import jungleprimatesanctuary.Primate;
import jungleprimatesanctuary.Saki;
import jungleprimatesanctuary.Sex;
import jungleprimatesanctuary.Size;
import jungleprimatesanctuary.Spider;
import jungleprimatesanctuary.Squirrel;
import jungleprimatesanctuary.Tamarin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Testing for the monkey factory class.
 */
public class MonkeyFactoryTest {


  @Test
  public void createMonkey() {
    Primate primate;
    primate = MonkeyFactory.createMonkey("Blim", Size.MEDIUM.getSizeDescription(),
            Sex.FEMALE.getSex(), 40, 100, Food.EGGS.foodName(),
            Size.MEDIUM.getFoodQuantity(), Size.MEDIUM.getSpaceRequirement(), "Drill");
    assertTrue("Check if object if created of correct species type",
            primate instanceof Drill);
    assertEquals("Drill", primate.getSpecies());

    primate = MonkeyFactory.createMonkey("Bob", Size.MEDIUM.getSizeDescription(),
            Sex.FEMALE.getSex(), 40, 100, Food.EGGS.foodName(),
            Size.MEDIUM.getFoodQuantity(), Size.MEDIUM.getSpaceRequirement(), "Howler");
    assertTrue("Check if object if created of correct species type",
            primate instanceof Howler);
    assertEquals("Howler", primate.getSpecies());

    primate = MonkeyFactory.createMonkey("Jack", Size.MEDIUM.getSizeDescription(),
            Sex.FEMALE.getSex()
            , 40, 100, Food.EGGS.foodName(), Size.MEDIUM.getFoodQuantity()
            , Size.MEDIUM.getSpaceRequirement(), "Guereza");
    assertTrue("Check if object if created of correct species type",
            primate instanceof Guereza);
    assertEquals("Guereza", primate.getSpecies());

    primate = MonkeyFactory.createMonkey("Jill", Size.MEDIUM.getSizeDescription(),
            Sex.FEMALE.getSex()
            , 40, 100, Food.EGGS.foodName(), Size.MEDIUM.getFoodQuantity()
            , Size.MEDIUM.getSpaceRequirement(), "Mangabey");
    assertTrue("Check if object if created of correct species type",
            primate instanceof Mangabey);
    assertEquals("Mangabey", primate.getSpecies());

    primate = MonkeyFactory.createMonkey("James", Size.MEDIUM.getSizeDescription(),
            Sex.FEMALE.getSex()
            , 40, 100, Food.EGGS.foodName(), Size.MEDIUM.getFoodQuantity()
            , Size.MEDIUM.getSpaceRequirement(), "Saki");
    assertTrue("Check if object if created of correct species type",
            primate instanceof Saki);
    assertEquals("Saki", primate.getSpecies());

    primate = MonkeyFactory.createMonkey("Janice", Size.MEDIUM.getSizeDescription(),
            Sex.FEMALE.getSex()
            , 40, 100, Food.EGGS.foodName(), Size.MEDIUM.getFoodQuantity()
            , Size.MEDIUM.getSpaceRequirement(), "Spider");
    assertTrue("Check if object if created of correct species type",
            primate instanceof Spider);
    assertEquals("Spider", primate.getSpecies());

    primate = MonkeyFactory.createMonkey("Jock", Size.MEDIUM.getSizeDescription(),
            Sex.FEMALE.getSex(), 40, 100, Food.EGGS.foodName(),
            Size.MEDIUM.getFoodQuantity(), Size.MEDIUM.getSpaceRequirement(), "Squirrel");
    assertTrue("Check if object if created of correct species type",
            primate instanceof Squirrel);
    assertEquals("Squirrel", primate.getSpecies());

    primate = MonkeyFactory.createMonkey("Joy", Size.MEDIUM.getSizeDescription(),
            Sex.FEMALE.getSex(), 40, 100, Food.EGGS.foodName(),
            Size.MEDIUM.getFoodQuantity(), Size.MEDIUM.getSpaceRequirement(), "Tamarin");
    assertTrue("Check if object if created of correct species type",
            primate instanceof Tamarin);
    assertEquals("Tamarin", primate.getSpecies());
  }
}