package zajaczkowski.adrian.simulation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import zajaczkowski.adrian.exceptions.TooBigItemExceptions;
import zajaczkowski.adrian.tools.Item;
import zajaczkowski.adrian.tools.Rocket;
import zajaczkowski.adrian.tools.U1;
import zajaczkowski.adrian.tools.U2;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SimulationTest {

    @InjectMocks
    private Simulation testObj = new Simulation();

    @Mock
    private Rocket rocket;

    @Test
    void shouldReturn500() {
        //given
        ArrayList<Rocket> rockets = new ArrayList<>();
        rockets.add(new U1());
        rockets.add(new U1());
        rockets.add(new U1());
        rockets.add(new U1());
        rockets.add(new U1());
        //when
        int result = testObj.runSimulation(rockets);
        //then

        assertThat(result).isEqualTo(500);
    }

    @Test
    void shouldReturnExceptionsAndNotLoadU1Rockets() {
        //given
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("trolololo",12000));

        //then
        assertThatThrownBy(()->testObj.loadU1(items)).isInstanceOf(TooBigItemExceptions.class);
    }

    @Test
    void shouldReturnExceptionsAndNotLoadU2Rockets() {
        //given
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("trolololo",12000));

        //then
        assertThatThrownBy(()->testObj.loadU2(items)).isInstanceOf(TooBigItemExceptions.class);
    }

    @Test
    void shouldNotLoadU1Rockets() {
        //given
        ArrayList<Item> items = new ArrayList<>();
        //when
        ArrayList<U1> result = testObj.loadU1(items);
        //then
        Assertions.assertThat(result).hasSize(1);
    }

    @Test
    void shouldNotLoadU2Rockets() {
        //given
        ArrayList<Item> items = new ArrayList<>();
        //when
        ArrayList<U2> result = testObj.loadU2(items);
        //then
        Assertions.assertThat(result).hasSize(1);
    }

    @Test
    void shouldLoadU1RocketsAndAddThemToFleet() {
        //given
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("shelter equipment",5000));
        items.add(new Item("shelter equipment",5000));
        items.add(new Item("shelter equipment",5000));
        items.add(new Item("shelter equipment",5000));
        items.add(new Item("shelter equipment",5000));
        //when
        ArrayList<U1> result = testObj.loadU1(items);
        //then
        Assertions.assertThat(result).hasSize(5);
    }

    @Test
    void shouldLoadU2RocketsAndAddThemToFleet() {
        //given
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("shelter equipment",5000));
        items.add(new Item("shelter equipment",5000));
        items.add(new Item("shelter equipment",5000));
        items.add(new Item("shelter equipment",5000));
        items.add(new Item("shelter equipment",5000));
        //when
        ArrayList<U2> result = testObj.loadU2(items);
        //then
        Assertions.assertThat(result).hasSize(3);
    }

    @Test
    void shouldNotCreateItemsAndReturnException() throws IOException {
        //given
        Path path = Paths.get("");
        //then
        assertThatThrownBy(()->testObj.loadItems(path)).isInstanceOf(IOException.class);
    }

    @Test
    void shouldCreateItemsAndAddToList() throws IOException {
        //given
        Path path = Paths.get("./src/main/resources/Phase-1.txt");

        //when
        ArrayList<Item> result = testObj.loadItems(path);
        //then
        Assertions.assertThat(result).hasSize(15);
    }

    @Test
    void shouldNotCreateItemFromString() {
        //given
        String data = "";


        //then
        assertThatThrownBy(()->testObj.createItemFromStringFromFile(data)).isInstanceOf(IOException.class);
    }

    @Test
    void shouldCreateItemFromString() throws IOException {
        //given
        String data = "plants=10000";
        //when
        Item result = testObj.createItemFromStringFromFile(data);
        //then
        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.name).isEqualTo("plants");
        Assertions.assertThat(result.weight).isEqualTo(10000);
    }
}