package JunglePrimateSanctuary;

public enum Size {
  SMALL("SMALL", 1, 100),
  MEDIUM("MEDIUM", 5, 250),
  LARGE("LARGE", 10, 500);

  private final String sizeDescription;
  private final int space;
  private final int foodQty;

  Size(String sizeDescription, int space, int foodQty) {
    this.sizeDescription = sizeDescription;
    this.space = space;
    this.foodQty = foodQty;
  }

  public String getSizeDescription() {
    return sizeDescription;
  }

  public int getSpace() {
    return space;
  }

  public int getFoodQty() {
    return foodQty;
  }
}
