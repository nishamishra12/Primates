package jungleprimatesanctuary;

import java.util.ArrayList;
import java.util.List;

/**
 * Isolation class represents the list of monkeys present in isolation housing.
 */
public class Isolation implements Housing {

  private final List<Primate> isolationList = new ArrayList<Primate>();

  private int noOfIsolationCages;

  public Isolation(int n) {
    this.noOfIsolationCages = n;
  }

  /**
   * * Check availability for a primate in isolation.
   *
   * @return the availableSpace
   */
  private int checkAvailability() {
    if (isolationList.size() < noOfIsolationCages) {

      return (noOfIsolationCages - isolationList.size());
    } else {
      return 0;
    }
  }

  /**
   * This method adds a new primate to housing.
   *
   * @param p takes primate object
   * @throws IllegalArgumentException when an invalid primate is passed
   * @throws IllegalStateException    when a particular housing is full
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
    isolationList.add(p);
    p.setHousingNo(isolationList.indexOf(p) + 1);

  }

  /**
   * This method provides list of primates in cages of isolation.
   *
   * @return list of primates in all housing cages
   */
  @Override
  public List<List<Primate>> getHousingList() {
    List<List<Primate>> arr = new ArrayList<>();
    arr.add(isolationList);
    return arr;
  }

  /**
   * This method removes a primate object from isolation.
   *
   * @param p takes primate object.
   * @throws IllegalArgumentException when an invalid primate object is passed
   */
  @Override
  public void removeMonkey(Primate p) throws IllegalArgumentException {
    if (p == null) {
      throw new IllegalArgumentException("primate object is null, not a valid argument.");
    }
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

  /**
   * {@inheritDoc}
   */
  @Override
  public int getHousingSize() {
    return noOfIsolationCages;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setHousingSize(int m) {
    this.noOfIsolationCages = m;
  }

}