package jungleprimatesanctuary;

import java.util.ArrayList;
import java.util.List;

/**
 * Isolation class represents the list of monkeys present in isolation housing.
 */
public class Isolation implements Housing {

  private final List<Primate> isolationList = new ArrayList<Primate>();
  private final int n;

  public Isolation(int n) {
    this.n = n;
  }

  /**
   * * Check availability for a primate in isolation.
   *
   * @return the availableSpace
   */
  private int checkAvailability() {
    if (isolationList.size() < n) {

      return (n - isolationList.size());
    } else {
      return 0;
    }
  }

  /**
   * This method adds a new primate to isolation
   * @param p takes primate object.
   * @throws IllegalArgumentException
   * @throws IllegalStateException
   */
  @Override
  public void addMonkey(Primate p) throws IllegalArgumentException, IllegalStateException {

    if (p == null) {
      throw new IllegalArgumentException("primate object passed was null, invalid input");
    }
    if (checkAvailability() == 0) {
      throw new IllegalStateException("No space in isolation");
    }
    p.setHousing(HousingType.ISOLATION.gethousingType());
    p.setHousingNo(isolationList.size() + 1);
    isolationList.add(p);
  }

  /**
   * This method provides list of primates in cages of housing
   * @return list of primates in all housing cages.
   */
  @Override
  public List<List<Primate>> getHousingList() {
    List<List<Primate>> arr = new ArrayList<>();
    arr.add(isolationList);
    return arr;
  }

  /**
   * This method removes a primate object from housing
   * @param p takes primate object.
   * @throws IllegalStateException
   * @throws IllegalArgumentException
   */
  @Override
  public void removeMonkey(Primate p) throws IllegalStateException, IllegalArgumentException {
    if (p == null) {
      throw new IllegalArgumentException("primate object is null, not a valid argument.");
    }
    if (isolationList.isEmpty()) {
      throw new IllegalStateException("Isolation is empty, there are no primates in isolation");
    } else {
      int count = 0;
      for (int i = 0; i < isolationList.size(); i++) {
        if (isolationList.get(i).getName().equals(p.getName())) {
          count++;
          isolationList.remove(p);
          break;
        }
      }
      if (count == 0) {
        throw new IllegalArgumentException("primate not present in isolation");
      }
    }
  }
}