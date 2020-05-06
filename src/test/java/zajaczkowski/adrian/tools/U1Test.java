package zajaczkowski.adrian.tools;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


class U1Test {


    private U1 testObj = new U1();



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
        Item item = new Item("plants",10000000);
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