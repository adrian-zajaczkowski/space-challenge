package zajaczkowski.adrian.tools;

public class U1 extends Rocket {

    public U1() {
        name = "U1";
        cost = 100;
        weight = 10_000_000;
        maxWeight = 18_000_000;
        cargoLimit = maxWeight - weight;
    }

    @Override
    public boolean launch() {
        boolean result = false;
        double random = Math.random();
        double chanceOfLaunch = 0.05 * (cargoCarried/cargoLimit);
        if (random <= chanceOfLaunch){
            result = true;
        }
        return result;
    }

    @Override
    public boolean land() {
        boolean result = false;
        double random = Math.random();
        double chanceOfLand = 0.01 * (cargoCarried/cargoLimit);
        if (random <= chanceOfLand){
            result = true;
        }
        return result;
    }


}
