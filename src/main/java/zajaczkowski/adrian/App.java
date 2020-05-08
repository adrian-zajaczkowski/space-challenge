package zajaczkowski.adrian;


import zajaczkowski.adrian.simulation.Simulation;
import zajaczkowski.adrian.tools.Item;
import zajaczkowski.adrian.tools.Rocket;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws IOException {
        final Path phase1Path = Paths.get("./src/main/resources/Phase-1.txt");
        final Path phase2Path = Paths.get("./src/main/resources/Phase-2.txt");

        Simulation simulation = new Simulation();

        ArrayList<Item> itemsForPhase1 = simulation.loadItems(phase1Path);
        ArrayList<Item> itemsForPhase2 = simulation.loadItems(phase2Path);


        System.out.println("Loading U1 fleet...");
        ArrayList<Rocket> fleetU1 = new ArrayList<>();
        fleetU1.addAll(simulation.loadU1(itemsForPhase1));
        fleetU1.addAll(simulation.loadU1(itemsForPhase2));

        System.out.println("Total budget for U1 fleet is: " + simulation.runSimulation(fleetU1) + " millions $");

        System.out.println("Loading U2 fleet...");
        ArrayList<Rocket> fleetU2 = new ArrayList<>();
        fleetU2.addAll(simulation.loadU2(itemsForPhase1));
        fleetU2.addAll(simulation.loadU2(itemsForPhase2));

        System.out.println("Total budget for U2 fleet is: " + simulation.runSimulation(fleetU2) + " millions $");
    }

}
