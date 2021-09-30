package JunglePrimateSanctuary;

public class MonkeyFactoryImpl{

  public static Primate createMonkey(String name, String size, String sex, int age, double weight
          , String favFood, int foodReq, int spaceReq, String speciesType, boolean isHealthy
          , String housing, int housingNo) {

    switch (speciesType) {
      case "Drill":
        return new Drill(name, size, sex, age, weight, favFood, foodReq, spaceReq, isHealthy, housing, housingNo);
      case "Guereza":
        return new Guereza(name, size, sex, age, weight, favFood, foodReq, spaceReq, isHealthy, housing, housingNo);
      case "Howler":
        return new Howler(name, size, sex, age, weight, favFood, foodReq, spaceReq, isHealthy, housing, housingNo);
      case "Saki":
        return new Saki(name, size, sex, age, weight, favFood, foodReq, spaceReq, isHealthy, housing, housingNo);
      case "Spider":
        return new Spider(name, size, sex, age, weight, favFood, foodReq, spaceReq, isHealthy, housing, housingNo);
      case "Squirrel":
        return new Squirrel(name, size, sex, age, weight, favFood, foodReq, spaceReq, isHealthy, housing, housingNo);
      case "Tamarin":
        return new Tamarin(name, size, sex, age, weight, favFood, foodReq, spaceReq, isHealthy, housing, housingNo);
      case "Mangabey":
        return new Mangabey(name, size, sex, age, weight, favFood, foodReq, spaceReq, isHealthy, housing, housingNo);
      default:
        throw new IllegalStateException("Unexpected value: " + speciesType);
    }
  }
}
