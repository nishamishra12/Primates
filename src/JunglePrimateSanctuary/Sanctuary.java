package JunglePrimateSanctuary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class Sanctuary {

  private final MonkeyFactoryImpl monkeyFactory;
  private final Housing isolation;
  private final Housing enclosure;
  private Primate primate;

  public Sanctuary(MonkeyFactoryImpl monkeyFactory, int isoSize, int enclSize) {

    this.monkeyFactory = monkeyFactory;
    this.isolation = new Isolation(isoSize);
    this.enclosure = new Enclosure(enclSize);
  }

  //Create new monkey Object
  public void createNewPrimate(String name, String size, String sex, int age, double weight
          , String favFood, int foodReq, int spaceReq, String speciesType, boolean isHealthy
          , String housing, int housingNo) {
    List<Primate> arr = entireHousingList();
    IntStream.range(0, arr.size()).filter(i -> arr.get(i).getName().equals(name)).forEach(i -> {
      throw new IllegalArgumentException("Can't add monkey, duplicate monkey. Name of a monkey should be unique!");
    });
    Primate p = monkeyFactory.createMonkey(name, size, sex, age, weight
            , favFood, foodReq, spaceReq, speciesType, isHealthy, housing, housingNo);

    //Add all new monkey's irrespective of medical condition to Isolation
    if (p.getMedicalCondition()) {
      p.setHealthy(false);
    }
    isolation.addMonkey(p);
  }

  //Change medical health of the monkey
  public void changeMedicalConditionOfMonkey(String name, boolean medicalFlag) {
    //checking in housing list
    List<Primate> arr = entireHousingList();
    for (int i = 0; i < arr.size(); i++) {
      if (arr.get(i).getName().equals(name)) {
        arr.get(i).setHealthy(medicalFlag);
        //if medical condition is true then move to isolation, else move to enclosure
        if (!medicalFlag && arr.get(i).getHousing().equals(HousingType.Enclosure.gethousingType())) {
          enclosure.removeMonkey(arr.get(i));
          isolation.addMonkey(arr.get(i));
        } else if (medicalFlag && arr.get(i).getHousing().equals(HousingType.Isolation.gethousingType())) {
          isolation.removeMonkey(arr.get(i));
          enclosure.addMonkey(arr.get(i));
        } else if ((!medicalFlag && arr.get(i).getHousing().equals(HousingType.Isolation.gethousingType()))
                || (medicalFlag && arr.get(i).getHousing().equals(HousingType.Enclosure.gethousingType()))) {
          System.out.println("Monkey already in appropriate housing");
        }
        break;
      }
      if (i == arr.size() - 1) {
        throw new IllegalArgumentException("Monkey is not present in Sanctuary");
      }
    }
  }

  //Get alphabetical list of monkeys with housing
  public List<Primate> getAlphabeticalListOfMonkeys() {
    List<Primate> arr = entireHousingList();
    arr.sort(Comparator.comparing(Primate::getName));
    return arr;
  }

  //Get Enclosure Sign
  public String getEnclosureSign(int CageNo) {
    List<Primate> arr = enclosure.getEnclosureList().get(CageNo);
    StringBuilder str = new StringBuilder();

    for (Primate value : arr) {
      str.append("Monkey Name: ").append(value.getName()).append(", Sex: ").append(value.getSex()).append(", Favorite Food: ").append(value.getFavFood());
    }
    return str.toString();
  }

  //Get Shopping List for Sanctuary
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

  //Get Alphabetical List of Species with housing
  public Map<String, Map<String, String>> getAlphabeticalSpeciesList() {
    return getHousingOfSpeciesHelper(uniqueListOfSpecies());
  }

  //LookUp Species
  public Map<String, String> lookUpSpecies(String species) {
    String[] s = new String[1];
    s[0] = species;
    Map<String, Map<String, String>> lookUpHousing = getHousingOfSpeciesHelper(s);
    return lookUpHousing.get(species);
  }

  //Get Housing of species
  private Map<String, Map<String, String>> getHousingOfSpeciesHelper(String[] speciesKey) {
    List<Primate> arr = entireHousingList();
    Map<String, Map<String, String>> speciesHsgList
            = new HashMap<>();
    for (String s : speciesKey) {
      Map<String, String> list = new HashMap<>();
      for (HousingType hsg : HousingType.values()) {
//       ArrayList<Integer> num = new ArrayList<>();
        StringJoiner joiner = new StringJoiner(", ", "Cage No: ", "");
        for (Primate primate : arr) {
          if (primate.getSpecies().equals(s) && primate.getHousing().equals(hsg.gethousingType())) {
            joiner.add(String.valueOf(primate.getHousingNo()));
          }
        }
        list.put(hsg.gethousingType(), joiner.toString());
      }
      speciesHsgList.put(s, list);
    }
    return new TreeMap<>(speciesHsgList);
  }

  //Get Unique list of species
  private String[] uniqueListOfSpecies() {
    List<Primate> arr = entireHousingList();
    String[] speciesKey = new String[arr.size()];

    for (int i = 0; i < arr.size(); i++) {
      speciesKey[i] = arr.get(i).getSpecies();
    }
    Arrays.sort(speciesKey, Comparator.naturalOrder());
    return speciesKey;
  }

  public List<Primate> getIsolationList() {
    return isolation.getIsolationList();
  }

  public List<List<Primate>> getEnclosureList() {
    return enclosure.getEnclosureList();
  }

  private List<Primate> entireHousingList() {
    //add isolationElements into Housing List
    List<Primate> housingList = new ArrayList<>(isolation.getIsolationList());

    //add Enclosure List
    for (int i = 0; i < enclosure.getEnclosureList().size(); i++) {
      housingList.addAll(enclosure.getEnclosureList().get(i));
    }
    //return list of all monkeys in housing (isolation & enclosure)
    return housingList;
  }

  public Primate findMonkey(String name) {
    List<Primate> arr = entireHousingList();
    for (Primate value : arr) {
      if (value.getName().equals(name)) {
        primate = value;
      }
    }
    return primate;
  }
}