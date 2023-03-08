package pl.pio.supplymanager;

import javafx.collections.ObservableList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class AppDBSaverTest {

    @Test
    public void saveProductsToFile_Test() {
        AppDB appDB = new AppDB();
        try {
            appDB.readProductsFromFile("products.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
        // original product
        Product expected = appDB.getProductsDB().get(0);

        AppDBSaver appDBSaver = new AppDBSaver(appDB);
        try {
            appDBSaver.saveProductsToFile("products.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }

        appDB = new AppDB();
        try {
            appDB.readProductsFromFile("products.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
        // result after saving
        Product result = appDB.getProductsDB().get(0);

        Assertions.assertEquals(expected, result);
    }

}
