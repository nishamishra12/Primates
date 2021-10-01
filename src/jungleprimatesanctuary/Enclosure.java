package jungleprimatesanctuary;

import java.util.ArrayList;
import java.util.List;

/**
 * Enclosure class represents the list of monkeys present in enclosure housing.
 */
public class Enclosure implements Housing {

  private final int enclosureSize = 100; /* every enclosure is of fixed size 100 sq.m */
  private final List<List<Primate>> enclosureList = new ArrayList<>();
  private int m;

  public Enclosure(int m) {
    this.m = m;
  }

  /**
   * * Helper method to check availability for a primate in enclosure.
   *
   * @return the availableSpace
   */
  private int checkAvailability(String speciesType, int space) {
    int spaceOccupied = 0;
    int remainingSpace;
    int troopNo = 0;

    if (enclosureList.isEmpty()) {
      troopNo = 0;
    } else {
      for (int i = 0; i < enclosureList.size(); i++) {
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
   * {@inheritDoc}
   */
  @Override
  public void addMonkey(Primate p) throws NullPointerException, IllegalStateException {
    if (p == null) {
      throw new IllegalArgumentException("No primate Object passed");
    }
    int troopNo = checkAvailability(p.getSpecies(), p.getSpaceReq());
    if (troopNo >= m) {
      throw new IllegalStateException("No space in Enclosure, please check other sanctuaries");
    } else {
      if (getHousingList().isEmpty() || getHousingList().size() == troopNo) {
        ArrayList<Primate> newItem = new ArrayList<Primate>();
        newItem.add(p);
        enclosureList.add(troopNo, newItem);
      } else {
        enclosureList.get(troopNo).add(p);
      }
      p.setHousing(HousingType.ENCLOSURE.gethousingType());
      p.setHousingNo(troopNo + 1);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<List<Primate>> getHousingList() {
    return enclosureList;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void removeMonkey(Primate p) {
    if(p==null) {
      throw new IllegalArgumentException("primate object is null, not a valid argument.");
    }
    if (!enclosureList.isEmpty()) {
      for (int i = 0; i < enclosureList.size(); i++) {
        for (int j = 0; j < enclosureList.get(i).size(); j++) {
          if (enclosureList.get(i).get(j).getName().equals(p.getName())) {
            if(enclosureList.get(i).size()<=1) {
              enclosureList.remove(enclosureList.get(i));
              break;
            }
            else {
              enclosureList.get(i).remove(enclosureList.get(i).get(j));
              break;
            }
          }
        }
      }
    }
  }
}
