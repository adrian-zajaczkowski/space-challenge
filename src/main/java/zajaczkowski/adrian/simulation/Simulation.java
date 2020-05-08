package zajaczkowski.adrian.simulation;

import zajaczkowski.adrian.exceptions.TooBigItemExceptions;
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
                if (!rocket.launch()) {
                    System.out.println("Rocket " + rocket.getName() + " crashed when launching. Try again.");
                } else if (!rocket.land()) {
                    System.out.println("Rocket " + rocket.getName() + " crashed when landing. Try again.");
                }
            }
            System.out.println("Rocket " + rocket.getName() + " launched and landed correctly.");
        }


        return budget;
    }

    public ArrayList<U1> loadU1(ArrayList<Item> items) {
        ArrayList<U1> fleetU1 = new ArrayList<>();

        U1 rocket = new U1();

        for (Item item : items) {

            while (!rocket.canCarry(item)) {
                fleetU1.add(rocket);
                rocket = new U1();
            }
            rocket.carry(item);
        }
        fleetU1.add(rocket);
        return fleetU1;
    }


    public ArrayList<U2> loadU2(ArrayList<Item> items) {
        ArrayList<U2> fleetU2 = new ArrayList<>();
        U2 rocket = new U2();

        try {


            for (Item item : items) {
                if (item.getWeight()>11000) throw new TooBigItemExceptions();
                while (!rocket.canCarry(item)) {
                    fleetU2.add(rocket);
                    rocket = new U2();
                }
                rocket.carry(item);
            }

        } catch (TooBigItemExceptions tooBigItemExceptions) {
            tooBigItemExceptions.getMessage();
        }
        fleetU2.add(rocket);
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

    public Item createItemFromStringFromFile(String file) throws IOException {
        if (!file.contains(DELIMITER)) {
            throw new IOException();
        }
        String[] splitItem = file.split(DELIMITER);
        return new Item(splitItem[0], Integer.valueOf(splitItem[1]));
    }

}
