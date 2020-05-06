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
        boolean result = true;
        double random = Math.random();
        double chanceOfLaunchExplosion = 0.04 * ( (double) cargoCarried/ (double) cargoLimit);
        if (random <= chanceOfLaunchExplosion){
            result = false;
        }
        return result;
    }

    @Override
    public boolean land() {
        boolean result = true;
        double random = Math.random();
        double chanceOfLandExplosion = 0.08 * ( (double) cargoCarried/ (double) cargoLimit);
        if (random <= chanceOfLandExplosion){
            result = false;
        }
        return result;
    }


}
