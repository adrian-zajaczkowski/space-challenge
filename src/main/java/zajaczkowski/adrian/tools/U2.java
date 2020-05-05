package zajaczkowski.adrian.tools;

public class U2 extends Rocket {

    public U2() {
        name = "U2";
        cost = 120;
        weight = 18_000_000;
        maxWeight = 29_000_000;
        cargoLimit = maxWeight - weight;
    }

    @Override
    public boolean launch() {
        boolean result = false;
        double random = Math.random();
        double chanceOfLaunch = 0.04 * (cargoCarried/cargoLimit);
        if (random <= chanceOfLaunch){
            result = true;
        }
        return result;
    }

    @Override
    public boolean land() {
        boolean result = false;
        double random = Math.random();
        double chanceOfLand = 0.08 * (cargoCarried/cargoLimit);
        if (random <= chanceOfLand){
            result = true;
        }
        return result;
    }


}
