package JunglePrimateSanctuary;

import java.util.ArrayList;
import java.util.List;

public class Isolation implements Housing {

  private final List<Primate> isolationList = new ArrayList<Primate>();
  private int n;

  public Isolation(int n) {
    this.n = n;
  }

  /**
   * * Check availability in enclosure and isolation.
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
   * * Add monkey to housing.
   *
   * @return void
   */
  @Override
  public void addMonkey(Primate p) {

    if(p ==null) {
      throw new NullPointerException("No Primate Object");
    }
    if (checkAvailability() == 0) {
      throw new IllegalStateException("No space in isolation");
    }
    p.setHousing(HousingType.Isolation.gethousingType());
    p.setHousingNo(isolationList.size() + 1);
    isolationList.add(p);
  }

  /**
   * * Get list of monkeys in isolation.
   *
   * @return isolation list
   */
  @Override
  public List<Primate> getIsolationList() {
    return isolationList;
  }

  /**
   * * Remove monkey from housing.
   *
   * @return void
   */
  @Override
  public void removeMonkey(Primate p) {
    for (int i = 0; i < isolationList.size(); i++) {
      if (isolationList.get(i).getName().equals(p.getName())) {
        isolationList.remove(p);
        break;
      }
    }
  }

  /**
   * * Get Enclosure List.
   *
   * @return Enclosure List
   */
  @Override
  public List<List<Primate>> getEnclosureList() {
    return null;
  }
}