package JunglePrimateSanctuary;

public enum Food {
  EGGS("EGGS"),
  FRUITS("FRUITS"),
  INSECTS("INSECTS"),
  LEAVES("LEAVES"),
  NUTS("NUTS"),
  SEEDS("SEEDS"),
  TREE_SAP("TREE SAP");

  private final String foodName;

  Food(String foodName) {
    this.foodName = foodName;
  }

  public String foodName() {
    return foodName;
  }
}
