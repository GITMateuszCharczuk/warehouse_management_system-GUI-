package pl.pio.supplymanager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class ProductionTest {

    Date date1 = new Date();
    Date date3 = new Date();
    Date date4 = new Date();

    @Test
    void testEquals() {
        Production compareProduction = new Production(1, "manu1", "country1", date1);
        Production secondProduction = new Production(1, "manu1", "country1", date1);
        Production thirdProduction = new Production(3, "manu3", "country3", date3);
        Production fourthProduction = new Production(4, "manu4", "country4", date4);
        Object obj = new Object();

        Assertions.assertEquals(compareProduction, secondProduction);
        Assertions.assertFalse(compareProduction.equals(thirdProduction));
        Assertions.assertFalse(compareProduction.equals(fourthProduction));
        Assertions.assertFalse(compareProduction.equals(obj));
    }

    @Test
    void testCompareTo() {
        Production compareProduction = new Production(1, "manu1", "country1", date1);
        Production secondProduction = new Production(1, "manu1", "country1", date1);
        Production thirdProduction = new Production(3, "manu3", "country3", date3);
        Production fourthProduction = new Production(4, "manu4", "country4", date4);

        Assertions.assertEquals(0, compareProduction.compareTo(secondProduction));
        Assertions.assertFalse(compareProduction.equals(thirdProduction));
        Assertions.assertFalse(compareProduction.equals(fourthProduction));
    }
}
