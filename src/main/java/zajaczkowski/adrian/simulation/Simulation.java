package zajaczkowski.adrian.simulation;

import zajaczkowski.adrian.tools.Item;
import zajaczkowski.adrian.tools.U1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Simulation {

    public static final String DELIMITER = "=";
    public static final Path phase1Path = Paths.get("./src/main/resources/Phase-1.txt");
    public static final Path phase2Path = Paths.get("./src/main/resources/Phase-2.txt");

    public void runSimulation() {
    }

    private ArrayList<U1> loadU1(ArrayList<Item> items) {
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

    private ArrayList<Item> loadItems(Path path) throws IOException {
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
