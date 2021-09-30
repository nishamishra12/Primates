package JunglePrimateSanctuary;

import java.util.ArrayList;
import java.util.List;

public class Enclosure implements Housing {

  private int m;
  private final int enclosureSize = 100; //every enclosure is of fixed size 100 sq.m
  private final List<List<Primate>> enclosureList = new ArrayList<>();

  public Enclosure(int m) {
    this.m = m;
  }

  private int checkAvailability(String speciesType, int space) {
    int spaceOccupied = 0;
    int remainingSpace = 0;
    int troopNo = 0;

    if (enclosureList.isEmpty()) {
      troopNo = 0;
    } else {
      for (int i = 0; i < enclosureList.size(); i++) {
        remainingSpace = 0;
        for (int j = 0; j < enclosureList.get(i).size(); j++) {
          if (speciesType != enclosureList.get(i).get(0).getSpecies()) {
            troopNo = i++;
            break;
          } else {
            spaceOccupied = enclosureList.get(i).get(j).getSpaceReq() + spaceOccupied;
          }
        }
        remainingSpace = enclosureSize - spaceOccupied;
        if (remainingSpace >= space) {
          troopNo = i;
          break;
        }
      }
    }
    return troopNo;
  }

  /**
   * * Add monkey to housing.
   *
   * @return void
   */
  @Override
  public void addMonkey(Primate p) {
    int troopNo = checkAvailability(p.getSpecies(), p.getSpaceReq());
    if (troopNo > m) {
      throw new IllegalStateException("No space in Enclosure");
    } else {
      if (getEnclosureList().isEmpty() || getEnclosureList().size()==troopNo) {
        ArrayList<Primate> newItem = new ArrayList<Primate>();
        newItem.add(p);
        enclosureList.add(troopNo, newItem);
      } else {
        for (int k = 0; k < getEnclosureList().get(troopNo).size(); k++) {
          if (enclosureList.get(troopNo).get(k).getName().equals(p.getName())) {
            throw new IllegalArgumentException("Duplicate Name, Name is a key and should be unique");
          }
        }
        enclosureList.get(troopNo).add(p);
      }
      p.setHousing(HousingType.Enclosure.gethousingType());
      p.setHousingNo(troopNo);
    }
  }

  /**
   * * Get list of monkeys in isolation.
   *
   * @return isolation list
   */
  @Override
  public List<List<Primate>> getEnclosureList() {
    return enclosureList;
  }

  /**
   * * Get Enclosure List.
   *
   * @return Enclosure List
   */
  @Override
  public List<Primate> getIsolationList() {
    return null;
  }

  /**
   * * Remove monkey from housing.
   *
   * @return void
   */
  @Override
  public void removeMonkey(Primate p) {
    if (!enclosureList.isEmpty()) {
      for (int i = 0; i < enclosureList.size(); i++) {
        for (int j = 0; j < enclosureList.get(i).size(); j++) {
          if (enclosureList.get(i).get(j).getName() == p.getName()) {
            enclosureList.get(i).remove(enclosureList.get(i).get(j));

          }
        }
      }
    }
  }
}
