package zajaczkowski.adrian.tools;

public class Rocket implements SpaceShip {

    String name;
    int cost;
    int weight;
    int maxWeight;
    int cargoLimit;
    int cargoCarried;


    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    @Override
    public boolean canCarry(Item item) {
        boolean result = false;
        if (item != null) {
            if (cargoLimit >= cargoCarried + item.getWeight()) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public void carry(Item item) {
        if (canCarry(item)) {
            cargoCarried += item.getWeight();
        }
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }


    public int getCargoLimit() {
        return cargoLimit;
    }


    public int getCargoCarried() {
        return cargoCarried;
    }

}
