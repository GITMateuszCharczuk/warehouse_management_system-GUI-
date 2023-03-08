package pl.pio.supplymanager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProductTest {
    @Test
    void testEquals(){
        Product compareProduct = new Product(1, 1, 1, 1, "Product1", 1, 1);
        Product secondProduct = new Product(1, 1, 1, 1, "Product1", 1, 1);
        Product thirdProduct = new Product(3, 3, 3, 3, "Product 3", 3, 3);
        Product fourthProduct = new Product(4, 4, 4, 4, "Product 4", 4, 4);
        Object obj = new Object();

        Assertions.assertEquals(compareProduct, secondProduct);
        Assertions.assertFalse(compareProduct.equals(thirdProduct));
        Assertions.assertFalse(compareProduct.equals(fourthProduct));
        Assertions.assertFalse(compareProduct.equals(obj));
    }

    @Test
    void testCompareTo(){
        Product compareProduct = new Product(1, 1, 1, 1, "Product1", 1, 1);
        Product secondProduct = new Product(1, 1, 1, 1, "Product1", 1, 1);
        Product thirdProduct = new Product(3, 3, 3, 3, "Product 3", 3, 3);
        Product fourthProduct = new Product(4, 4, 4, 4, "Product 4", 4, 4);

        Assertions.assertEquals(0, compareProduct.compareTo(secondProduct));
        Assertions.assertFalse(compareProduct.equals(thirdProduct));
        Assertions.assertFalse(compareProduct.equals(fourthProduct));

    }
}
