package pl.pio.supplymanager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DescriptionTest {

    @Test
    void testEquals() {
        Description compareDescription = new Description(1, "example description");
        Description secondDescription = new Description(1, "example description");
        Description thirdDescription = new Description(2, "example description");
        Description fourthDescription = new Description(3, "another description");
        Object obj = new Object();

        Assertions.assertEquals(compareDescription, secondDescription);
        Assertions.assertFalse(compareDescription.equals(thirdDescription));
        Assertions.assertFalse(compareDescription.equals(fourthDescription));
        Assertions.assertFalse(compareDescription.equals(obj));
    }
    @Test
    void testCompareTo() {
       Description compareDescription = new Description(1, "example description");
        Description secondDescription = new Description(1, "example description");
        Description thirdDescription = new Description(2, "example description");
        Description fourthDescription = new Description(3, "another description");

        Assertions.assertTrue(compareDescription.equals(secondDescription));
        Assertions.assertFalse(compareDescription.equals(thirdDescription));
        Assertions.assertFalse(compareDescription.equals(fourthDescription));
    }
}