package jungleprimatesanctuary;

import java.util.List;

/**
 * This class represents the housing of all primates present in the sanctuary.
 */
public interface Housing {

  /**
   * This method adds a new primate to housing
   * @param p takes primate object.
   * @throws IllegalArgumentException
   * @throws IllegalStateException
   */
  public void addMonkey(Primate p) throws IllegalStateException, IllegalArgumentException;

  /**
   * This method removes a primate object from housing
   * @param p takes primate object.
   * @throws IllegalStateException
   * @throws IllegalArgumentException
   */
  public void removeMonkey(Primate p) throws IllegalStateException, IllegalArgumentException;

  /**
   * This method provides list of primates in cages of housing
   * @return list of primates in all housing cages.
   */
  public List<List<Primate>> getHousingList();

}
