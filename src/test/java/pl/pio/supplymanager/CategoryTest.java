package pl.pio.supplymanager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

    @Test
    void testEquals() {
        Category compareCategory = new Category(1, "example category");
        Category secondCategory = new Category(1, "example category");
        Category thirdCategory = new Category(2, "example category");
        Category fourthCategory = new Category(3, "another category");
        Object obj = new Object();

        Assertions.assertEquals(compareCategory, secondCategory);
        Assertions.assertFalse(compareCategory.equals(thirdCategory));
        Assertions.assertFalse(compareCategory.equals(fourthCategory));
        Assertions.assertFalse(compareCategory.equals(obj));
    }

    @Test
    void testCompareTo(){
        Category compareCategory = new Category(1, "example category");
        Category secondCategory = new Category(1, "example category");
        Category thirdCategory = new Category(2, "example category");
        Category fourthCategory = new Category(3, "another category");

        Assertions.assertEquals(0, compareCategory.compareTo(secondCategory));
        Assertions.assertFalse(compareCategory.equals(thirdCategory));
        Assertions.assertFalse(compareCategory.equals(fourthCategory));

    }
}