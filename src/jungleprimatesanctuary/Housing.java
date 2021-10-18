package jungleprimatesanctuary;

import java.util.List;

/**
 * This class represents the housing of all primates present in the sanctuary.
 */
public interface Housing {

  /**
   * This method adds a new primate to housing.
   *
   * @param p takes primate object
   * @throws IllegalArgumentException when an invalid primate is passed
   * @throws IllegalStateException    when a particular housing is full
   */
  void addMonkey(Primate p) throws IllegalStateException, IllegalArgumentException;

  /**
   * This method removes a primate object from housing.
   *
   * @param p takes primate object.
   * @throws IllegalArgumentException when an invalid primate object is passed
   */
  void removeMonkey(Primate p) throws IllegalArgumentException;

  /**
   * This method provides list of primates in cages of housing.
   *
   * @return list of primates in all housing cages.
   */
  List<List<Primate>> getHousingList();

  /**
   * this method provides the size of the housing.
   *
   * @return the size of housing.
   */
  int getHousingSize();

  /**
   * this method sets the size of the housing.
   */
  void setHousingSize(int m);
}
