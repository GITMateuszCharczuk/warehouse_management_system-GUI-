package pl.pio.supplymanager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.Date;
import java.text.ParseException;

public class AppDBTest {

    @Test
    public void readProductsFromFile_Test(){
        //given
        AppDB appDB = new AppDB();
        ObservableList<Product> productsDB = FXCollections.observableArrayList();
        Product expected = new Product(1,2,3, 4, "Smartfon testowy", 5, 6.780000);

        //when
        try {
            appDB.readProductsFromFile("productsTest.txt");
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        Product result = appDB.getProductsDB().get(0);

        //then
        Assertions.assertEquals(expected, result);

    }
    @Test
    public void readProductionsFromFile_Test(){
        //given
        AppDB appDB = new AppDB();
        Production expected = new Production(1,"Marka Testowa", "Kraj Testowy", new Date(2000,1,1));

        //when
        try {
            appDB.readProductionsFromFile("productionsTest.txt");
        } catch (ParseException | FileNotFoundException e){
            e.printStackTrace();
        }
        Production result = appDB.getProductionDB().get(0);

        //then
        Assertions.assertEquals(expected, result);
    }
    @Test
    public void readCategoriesFromFile_Test(){
        //given
        AppDB appDB = new AppDB();
        Category expected = new Category(1,"Kategoria Testowa");

        //when
        try {
            appDB.readCategoriesFromFile("categoriesTest.txt");
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        Category result = appDB.getCategoriesDB().get(0);

        //then
        Assertions.assertEquals(expected, result);
    }
    @Test
    public void readDescriptionsFromFile_Test(){
        //given
        AppDB appDB = new AppDB();
        Description expected = new Description(1, "Opis testowy");

        //when
        try {
            appDB.readDescriptionsFromFile("descriptionsTest.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Description result = appDB.getDescriptionsDB().get(0);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void deleteProductsFromDB_Test(){
        //given
        AppDB appDB = new AppDB();

        //when
        try {
            appDB.readProductsFromFile("productsTest.txt");
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        Product product = appDB.getProductsDB().get(0);

        int expectedAmountOfProductsInDB = appDB.getProductsDB().size() - 1;

        appDB.deleteProductsFromDB(product);

        int actualAmountOfProductsInDB = appDB.getProductsDB().size();

        Assertions.assertEquals(expectedAmountOfProductsInDB, actualAmountOfProductsInDB);
    }
}
