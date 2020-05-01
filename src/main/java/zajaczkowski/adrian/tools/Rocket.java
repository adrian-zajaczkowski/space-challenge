package zajaczkowski.adrian.tools;

public class Rocket implements SpaceShip {

    private String name;
    private int weight;
    private int maxWeight;
    private int cargoLimit;
    private int cargoCarried;


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
        return false;
    }

    @Override
    public void carry(Item item) {

    }
}
