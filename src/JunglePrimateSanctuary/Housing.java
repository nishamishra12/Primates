package JunglePrimateSanctuary;

import java.util.List;

public interface Housing {

  /**
   * * Add monkey to housing.
   *
   * @return void
   */
  public void addMonkey(Primate p);

  /**
   * * Remove monkey from housing.
   *
   * @return void
   */
  public void removeMonkey(Primate p);

  /**
   * * Get Enclosure List.
   *
   * @return Enclosure List
   */
  public List<List<Primate>> getEnclosureList();

  /**
   * * Get Enclosure List.
   *
   * @return Enclosure List
   */
  public List<Primate> getIsolationList();

}
