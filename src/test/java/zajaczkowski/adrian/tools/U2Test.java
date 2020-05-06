package zajaczkowski.adrian.tools;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class U2Test {

    private U2 testObj = new U2();

    @Test
    void shouldCanCarry() {
        //given
        Item item = new Item("plant",10000);
        //when
        boolean result = testObj.canCarry(item);
        //then
        assertEquals(true,result);
    }

    @Test
    void shouldCanNotCarry() {
        //given
        Item item = new Item("plants",19000000);
        //when
        boolean result = testObj.canCarry(item);
        //then
        assertEquals(false,result);
    }

    @Test
    void shouldReturnTrue() {
        //when
        boolean result = testObj.launch();
        while (result == false) {
            result = testObj.launch();
        }
        //then
        assertEquals(true, result);
    }

    @Test
    @Disabled("Probability is very small.")
    void shouldReturnFalse() {
        //when
        boolean result = testObj.land();
        while (result == true) {
            result = testObj.land();
        }
        //then
        assertEquals(false, result);
    }

}