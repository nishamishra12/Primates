package jungleprimatesanctuary;

/**
 * This is an enumeration for favorite food of monkey.
 */
public enum Food {
  EGGS("EGGS"),
  FRUITS("FRUITS"),
  INSECTS("INSECTS"),
  LEAVES("LEAVES"),
  NUTS("NUTS"),
  SEEDS("SEEDS"),
  TREE_SAP("TREE SAP");

  private final String foodName;

  private Food(String foodName) {
    this.foodName = foodName;
  }

  public String foodName() {
    return foodName;
  }
}
