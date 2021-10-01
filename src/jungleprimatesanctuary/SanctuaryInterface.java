package jungleprimatesanctuary;

import java.util.List;
import java.util.Map;

/**
 * SanctuaryInterface represents the entire sanctuary which houses primates in different housings.
 */
public interface SanctuaryInterface {

  /**
   * This method creates a new primate object and adds it to the isolation list.
   *
   * @param name        This parameter takes the name of the monkey
   * @param size        this parameter takes the size of the monkey
   * @param sex         this parameter takes the sex of the monkey
   * @param age         this parameter takes the age of the monkey
   * @param weight      this parameter takes the weight of the monkey
   * @param favFood     this parameter takes the favorite food of the monkey
   * @param foodReq     this parameter takes the food requirement in grams of the monkey
   * @param spaceReq    this parameter takes the space required by the monkey in the enclosure
   * @param speciesType this parameter takes the species type of the monkey
   * @throws IllegalArgumentException when a newly added monkey has name same as a
   *                                  monkey already present in the sanctuary
   */
  void createNewPrimate(String name, String size, String sex, int age, double weight
          , String favFood, int foodReq, int spaceReq, String speciesType) throws IllegalArgumentException;

  /**
   * This method changes the medical condition of the monkey and calls the shift method
   * to shift the monkey to appropriate housing based on medical condition
   *
   * @param name        this parameter takes the name of the monkey
   * @param medicalFlag this parameter takes the medical condition of the monkey,
   *                    true if healthy and false if sick
   * @throws IllegalStateException    when a monkey is already present in appropriate housing
   * @throws IllegalArgumentException when a monkey is not present in the sanctuary.
   */
  public void changeMedicalConditionOfMonkey(String name, boolean medicalFlag)
          throws IllegalStateException, IllegalArgumentException;

  /**
   * This method gives the alphabetical list of all the primates housed in the sanctuary.
   *
   * @return list of primates housed in the sanctuary
   */
  public List<Primate> getAlphabeticalListOfMonkeys();

  /**
   * This method provides the enclosure sign for each individual primate
   * details for an enclosure cage consisting of name, sex, and favorite food of the primate.
   *
   * @param CageNo this parameter takes the cage no of the enclosure
   *               for which the enclosure sign is required.
   * @return the enclosure sign for all the primates in the enclosure cage
   * @throws IllegalArgumentException when the cage number entered is not present in the enclosure
   */
  public String getEnclosureSign(int CageNo) throws IllegalArgumentException;

  /**
   * This method provides a shopping list of the favorite foods of the primates
   * along with the quantity required.
   * @return favorite food and quantity of all the favorite foods.
   */
  public Map<String, Integer> getShoppingList();

  /**
   * This method provides the list of all species in the sanctuary in alphabetical order
   * along with their respective housing.
   * @return alphabetical list of the species.
   */
  public Map<String, Map<String, String>> getAlphabeticalSpeciesList();

  /**
   * This method looks up a particular species and provides the housing details for that species.
   * @param species this parameter takes the species name
   * @return the list of species along with housing details and cage numbers
   * @throws IllegalArgumentException when the given species is not present.
   */
  public Map<String, Map<String, String>> lookUpSpecies(String species) throws IllegalArgumentException;

  /**
   * This method provides the entire primate object for any monkey by the monkey name.
   * @param name this parameter takes the name of the monkey
   * @return primate object for a unique monkey name.
   * @throws IllegalArgumentException when name entered is not present in the sanctuary.
   * @throws NullPointerException when name passed is null.
   */
  public Primate findMonkey(String name) throws IllegalArgumentException, NullPointerException;
}
