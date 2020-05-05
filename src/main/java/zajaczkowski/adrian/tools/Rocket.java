package zajaczkowski.adrian.tools;

public class Rocket implements SpaceShip {

    public String name;
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
            cargoCarried = + item.getWeight();
        }
    }
}
