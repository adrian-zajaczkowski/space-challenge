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
        boolean result = true;
        double random = Math.random();
        double chanceOfLaunchExplosion = 0.05 * ( (double) cargoCarried/ (double) cargoLimit);
        if (random <= chanceOfLaunchExplosion){
            result = false;
        }
        return result;
    }

    @Override
    public boolean land() {
        boolean result = true;
        double random = Math.random();
        double chanceOfLandExplosion = 0.01 * ( (double) cargoCarried/ (double) cargoLimit);
        if (random <= chanceOfLandExplosion){
            result = false;
        }
        return result;
    }


}
