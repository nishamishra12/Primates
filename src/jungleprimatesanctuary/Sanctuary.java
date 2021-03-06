package jungleprimatesanctuary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.TreeMap;

/**
 * This class represents a sanctuary which houses different type of species.
 */
public class Sanctuary implements SanctuaryInterface {

  private final Housing isolation;
  private final Housing enclosure;
  private Primate primate;
  private final int initialIsolationSize;
  private final int initialEnclosureSize;

  /**
   * Constructs a Sanctuary which houses primates of different species.
   *
   * @param isolationSize this parameter takes the isolation size
   * @param enclosureSize this parameter takes the enclosure size
   * @throws IllegalArgumentException when a non-positive number is entered as housing size
   */
  public Sanctuary(int isolationSize, int enclosureSize)
          throws IllegalArgumentException {

    if (isolationSize <= 0) {
      throw new IllegalArgumentException("Size of the isolation should be a positive number");
    }
    if (enclosureSize <= 0) {
      throw new IllegalArgumentException("Size of the enclosure should be a positive number");
    }
    this.isolation = new Isolation(isolationSize);
    this.enclosure = new Enclosure(enclosureSize);
    this.initialIsolationSize = isolationSize;
    this.initialEnclosureSize = enclosureSize;
  }

  /**
   * This method updates the size of enclosure and isolation.
   *
   * @param isolationSize takes isolation size
   * @param enclosureSize takes enclosure size
   * @throws IllegalArgumentException when a non-positive number is entered as housing size
   */
  @Override
  public void updateHousingSize(int isolationSize, int enclosureSize)
          throws IllegalArgumentException {
    if (isolationSize <= 0) {
      throw new IllegalArgumentException("Size of the isolation should be a positive number");
    }
    if (enclosureSize <= 0) {
      throw new IllegalArgumentException("Size of the enclosure should be a positive number");
    }
    if (isolationSize < initialIsolationSize) {
      throw new IllegalArgumentException("Size of the isolation cannot be decreased");
    }
    if (enclosureSize <= initialEnclosureSize) {
      throw new IllegalArgumentException("Size of the enclosure cannot be decreased");
    }
    isolation.setHousingSize(isolationSize);
    enclosure.setHousingSize(enclosureSize);
  }

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
   * @throws IllegalStateException    when there is no space in isolation and a new monkey is added.
   */
  @Override
  public void createNewPrimate(String name, String size, String sex, int age, double weight,
                               String favFood, int foodReq, int spaceReq, String speciesType)
          throws IllegalArgumentException, IllegalStateException {

    if (name == null) {
      throw new IllegalArgumentException("Name of the monkey cannot be null");
    }
    if (age <= 0 || weight <= 0) {
      throw new IllegalArgumentException("Age or weight of the monkey should be a positive number");
    }
    if (size == null) {
      throw new IllegalArgumentException("Size of monkey cannot be null");
    }
    if (sex == null) {
      throw new IllegalArgumentException("Sex of monkey cannot be null");
    }
    if (favFood == null) {
      throw new IllegalArgumentException("Favorite food of monkey cannot be null");
    }
    if (foodReq <= 0) {
      throw new IllegalArgumentException("Favorite requirement of monkey should be positive");
    }
    if (spaceReq <= 0) {
      throw new IllegalArgumentException("Space requirement of monkey should be positive");
    }
    List<Primate> arr = entireHousingList();
    for (Primate value : arr) {
      if (value.getName().equals(name)) {
        throw new IllegalArgumentException("Can't add monkey, duplicate monkey. Name of a monkey "
                + "should be unique!");
      }
    }
    Primate p = MonkeyFactory.createMonkey(name, size, sex, age, weight, favFood, foodReq,
            spaceReq, speciesType);
    /* Add all new monkey's irrespective of medical condition to Isolation. */
    isolation.addMonkey(p);
  }

  /**
   * This method changes the medical condition of the monkey and calls the shift method.
   * to shift the monkey to appropriate housing based on medical condition
   *
   * @param name        this parameter takes the name of the monkey
   * @param medicalFlag this parameter takes the medical condition of the monkey,
   *                    true if healthy and false if sick
   * @throws IllegalStateException    when a monkey is already present in appropriate housing
   * @throws IllegalArgumentException when a monkey is not present in the sanctuary.
   */
  @Override
  public void changeMedicalConditionOfMonkey(String name, boolean medicalFlag)
          throws IllegalStateException, IllegalArgumentException {
    shiftMonkey(name, medicalFlag);
  }

  /**
   * This method shifts the primate from enclosure to isolation or isolation to enclosure
   * based on the medical condition of the money.
   *
   * @param medicalFlag this parameter takes the medical condition of the monkey,
   *                    true if healthy and false if sick
   * @throws IllegalStateException    when a monkey is already present in appropriate housing
   * @throws IllegalArgumentException when a monkey is not present in the sanctuary.
   */
  private void shiftMonkey(String name, boolean medicalFlag)
          throws IllegalStateException, IllegalArgumentException {
    List<Primate> arr = entireHousingList();
    if (name == null) {
      throw new IllegalArgumentException("Monkey name cannot be null");
    }
    for (int i = 0; i < arr.size(); i++) {
      if (arr.get(i).getName().equals(name)) {
        /* if medical condition is true then move to isolation, else move to enclosure. */
        if (!medicalFlag && arr.get(i).getHousing()
                .equals(HousingType.ENCLOSURE.gethousingType())) {
          enclosure.removeMonkey(arr.get(i));
          isolation.addMonkey(arr.get(i));
        } else if (medicalFlag && arr.get(i).getHousing()
                .equals(HousingType.ISOLATION.gethousingType())) {
          isolation.removeMonkey(arr.get(i));
          enclosure.addMonkey(arr.get(i));
        } else if ((!medicalFlag && arr.get(i).getHousing()
                .equals(HousingType.ISOLATION.gethousingType()))
                || (medicalFlag && arr.get(i).getHousing()
                .equals(HousingType.ENCLOSURE.gethousingType()))) {
          throw new IllegalStateException("Monkey is already in appropriate housing");
        }
        break;
      }
      if (i == arr.size() - 1) {
        throw new IllegalArgumentException("Monkey is not present in sanctuary");
      }
    }
  }

  /**
   * This method gives the alphabetical list of all the primates housed in the sanctuary.
   *
   * @return list of primates housed in the sanctuary
   */
  @Override
  public List<Primate> getAlphabeticalListOfMonkeys() {
    List<Primate> arr = entireHousingList();
    arr.sort(Comparator.comparing(Primate::getName));
    return arr;
  }

  /**
   * This method provides the enclosure sign for each individual primate
   * details for an enclosure cage consisting of name, sex, and favorite food of the primate.
   *
   * @param cageNumber this parameter takes the cage no of the enclosure
   *                   for which the enclosure sign is required.
   * @return the enclosure sign for all the primates in the enclosure cage
   * @throws IllegalArgumentException when the cage number entered is not present in the enclosure
   */
  @Override
  public String getEnclosureSign(int cageNumber) throws IllegalArgumentException {

    if (cageNumber >= enclosure.getHousingList().size()) {
      throw new IllegalArgumentException("Enclosure Cage Number "
              + "entered is not present in the sanctuary");
    }
    List<Primate> arr = enclosure.getHousingList().get(cageNumber);
    StringBuilder str = new StringBuilder();
    if (arr.isEmpty()) {
      str.append("The cage is currently empty, "
              + "and not housed by any primate troop");
    } else {
      str.append("Enclosure sign for Cage ").append(cageNumber).append('\n');
      for (Primate value : arr) {
        str.append("Monkey Name: ").append(value.getName()).append('\n').append("Sex: ")
                .append(value.getSex()).append('\n').append("Favorite Food: ")
                .append(value.getFavFood()).append('\n')
                .append("--------------------------").append('\n');
      }
    }
    return str.toString();
  }

  /**
   * This method provides a shopping list of the favorite foods of the primates
   * along with the quantity required.
   *
   * @return favorite food and quantity of all the favorite foods.
   */
  @Override
  public Map<String, Integer> getShoppingList() {

    Map<String, Integer> shoppingList = new HashMap<>();
    List<Primate> arr = entireHousingList();
    for (Food food : Food.values()) {
      int countQty = 0;
      for (Primate primate : arr) {
        if (primate.getFavFood().equals(food.foodName())) {
          countQty = primate.getFoodReq() + countQty;
        }
      }
      if (countQty > 0) {
        shoppingList.put(food.foodName(), countQty);
      }
    }
    return shoppingList;
  }

  /**
   * This method provides the list of all species in the sanctuary in alphabetical order
   * along with their respective housing.
   *
   * @return alphabetical list of the species.
   */
  @Override
  public Map<String, Map<String, String>> getAlphabeticalSpeciesList() {
    return getHousingOfSpeciesHelper(uniqueListOfSpecies());
  }

  /**
   * This method looks up a particular species and provides the housing details for that species.
   *
   * @param species this parameter takes the species name
   * @return the list of species along with housing details and cage numbers
   * @throws IllegalArgumentException when the given species is not present.
   */
  @Override
  public Map<String, Map<String, String>> lookUpSpecies(String species)
          throws IllegalArgumentException {
    String[] s = new String[1];
    s[0] = species;
    Map<String, Map<String, String>> lookUpHousing = getHousingOfSpeciesHelper(s);
    if (lookUpHousing.get(species).isEmpty()) {
      throw new IllegalArgumentException("Report: The species is not present in the sanctuary");
    }
    return lookUpHousing;
  }

  /**
   * This method is a helper method which provides housing of all the species.
   *
   * @param speciesKey this parameter takes the list of species present
   * @return the list of species with housing details.
   */
  private Map<String, Map<String, String>> getHousingOfSpeciesHelper(String[] speciesKey) {
    List<Primate> arr = entireHousingList();
    int oldValue;
    Map<String, Map<String, String>> speciesHsgList
            = new HashMap<>();
    for (String s : speciesKey) {
      Map<String, String> list = new HashMap<>();
      for (HousingType hsg : HousingType.values()) {
        int count = 0;
        oldValue = 0;
        StringJoiner joiner = new StringJoiner(", ", "Cage No: ", "");
        for (Primate primate : arr) {
          if (primate.getSpecies().equals(s) && primate.getHousing().equals(hsg.gethousingType())) {
            count++;
            if (oldValue != primate.getHousingNo()) {
              joiner.add(String.valueOf(primate.getHousingNo()));
            }
            oldValue = primate.getHousingNo();
          }
        }
        if (count != 0) {
          list.put(hsg.gethousingType(), joiner.toString());
        }
      }
      speciesHsgList.put(s, list);
    }
    return new TreeMap<>(speciesHsgList);
  }

  /**
   * This method is a helper method which provides unique list of species.
   *
   * @return unique list of species
   */
  private String[] uniqueListOfSpecies() {
    List<Primate> arr = entireHousingList();
    String[] speciesKey = new String[arr.size()];

    for (int i = 0; i < arr.size(); i++) {
      speciesKey[i] = arr.get(i).getSpecies();
    }
    Arrays.sort(speciesKey, Comparator.naturalOrder());
    return speciesKey;
  }

  /**
   * This method is a helper method which gives list of total primates in the sanctuary.
   *
   * @return total list of primates in enclosure plus isolation.
   */
  private List<Primate> entireHousingList() {
    /* add isolationElements into housing List */
    List<Primate> housingList = new ArrayList<>(isolation.getHousingList().get(0));

    /* add Enclosure List into housing list */
    for (int i = 0; i < enclosure.getHousingList().size(); i++) {
      housingList.addAll(enclosure.getHousingList().get(i));
    }
    /* return list of all monkeys in housing (isolation & enclosure) */
    return housingList;
  }

  /**
   * This method provides the entire primate object for any monkey by the monkey name.
   *
   * @param name this parameter takes the name of the monkey
   * @return primate object for a unique monkey name.
   * @throws IllegalArgumentException when name entered is not present in the sanctuary.
   * @throws NullPointerException     when name passed is null.
   */
  @Override
  public Primate findMonkey(String name) throws IllegalArgumentException {
    if (name == null) {
      throw new IllegalArgumentException("Monkey name cannot be null");
    }
    List<Primate> arr = entireHousingList();
    int count = 0;
    for (Primate value : arr) {
      if (value.getName().equals(name)) {
        count++;
        primate = value;
        break;
      }
    }
    if (count == 0) {
      throw new IllegalArgumentException("Monkey with this name doesn't exist in sanctuary");
    }
    return primate;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Housing getIsolation() {
    return this.isolation;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Housing getEnclosure() {
    return this.enclosure;
  }


}