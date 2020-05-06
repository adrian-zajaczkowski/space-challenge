package zajaczkowski.adrian.simulation;

import zajaczkowski.adrian.tools.Item;
import zajaczkowski.adrian.tools.Rocket;
import zajaczkowski.adrian.tools.U1;
import zajaczkowski.adrian.tools.U2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Simulation {

    public static final String DELIMITER = "=";


    public int runSimulation(ArrayList<Rocket> rockets) {
        int budget = 0;
        for (Rocket rocket : rockets) {
            budget += rocket.getCost();

            while (!rocket.launch() || !rocket.land()) {
                budget += rocket.getCost();
            }
        }


        return budget;
    }

    public ArrayList<U1> loadU1(ArrayList<Item> items) {
        ArrayList<U1> fleetU1 = new ArrayList<>();

        int itemsSize = items.size();
        int counter = 0;

        if (itemsSize > 0) {
            while (counter < itemsSize - 1) {
                U1 rocket = new U1();
                Item item = items.get(counter);

                while (rocket.getCargoLimit() > item.getWeight() + rocket.getCargoCarried()) {
                    rocket.carry(item);

                }
                counter += 1;
                fleetU1.add(rocket);
            }
        }

        return fleetU1;
    }

    public ArrayList<U2> loadU2(ArrayList<Item> items) {
        ArrayList<U2> fleetU2 = new ArrayList<>();

        int itemsSize = items.size();
        int counter = 0;

        if (itemsSize > 0) {
            while (counter < itemsSize - 1) {
                U2 rocket = new U2();
                Item item = items.get(counter);

                while (rocket.getCargoLimit() > item.getWeight() + rocket.getCargoCarried()) {
                    rocket.carry(item);

                }
                counter += 1;
                fleetU2.add(rocket);
            }
        }

        return fleetU2;
    }

    public ArrayList<Item> loadItems(Path path) throws IOException {
        ArrayList<Item> result = new ArrayList<>();
        List<String> items = Files.readAllLines(path);
        for (String item : items) {
            result.add(createItemFromStringFromFile(item));
        }
        return result;
    }

    private Item createItemFromStringFromFile(String file) {
        String[] splitItem = file.split(DELIMITER);
        Item item = new Item(splitItem[0], Integer.valueOf(splitItem[1]));
        return item;
    }

}
