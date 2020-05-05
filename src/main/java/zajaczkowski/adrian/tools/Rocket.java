package zajaczkowski.adrian.tools;

public class Rocket implements SpaceShip {

    public String name;
    public int cost;
    public int weight;
    public int maxWeight;
    public int cargoLimit;
    public int cargoCarried;


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

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public int getCargoLimit() {
        return cargoLimit;
    }

    public void setCargoLimit(int cargoLimit) {
        this.cargoLimit = cargoLimit;
    }

    public int getCargoCarried() {
        return cargoCarried;
    }

    public void setCargoCarried(int cargoCarried) {
        this.cargoCarried = cargoCarried;
    }
}
