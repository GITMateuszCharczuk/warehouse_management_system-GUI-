package pl.pio.supplymanager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductAdderTest {

    @Test
    public void getProductionFromUserInputTest() {
        //given
        AppDB appDB = new AppDB();
        ProductAdder productAdder = new ProductAdder(appDB);
        int expected = 2;
        int result;


        //when
        productAdder.getProductionFromUserInput("pierwszaProdukcja",appDB.getProductionDB());
        productAdder.getProductionFromUserInput("pierwszaProdukcja",appDB.getProductionDB());
        productAdder.getProductionFromUserInput("drugaProdukcja",appDB.getProductionDB());
        result = appDB.getProductionDB().size();

        //then
        Assertions.assertEquals(expected, result);

    }

    @Test
    public void getCategoryFromUserInputTest() {
        //given
        AppDB appDB = new AppDB();
        ProductAdder productAdder = new ProductAdder(appDB);
        int expected = 2;
        int result;


        //when
        productAdder.getCategoryFromUserInput("pierwszaKategoria",appDB.getCategoriesDB());
        productAdder.getCategoryFromUserInput("drugaKategoria",appDB.getCategoriesDB());
        productAdder.getCategoryFromUserInput("drugaKategoria",appDB.getCategoriesDB());
        result = appDB.getCategoriesDB().size();

        //then
        Assertions.assertEquals(expected, result);

    }

    @Test
    public void getDescriptionFromUserInputTest() {
        //given
        AppDB appDB = new AppDB();
        ProductAdder productAdder = new ProductAdder(appDB);
        int expected = 3;
        int result;


        //when
        productAdder.getDescriptionFromUserInput("pierwszyOpis",appDB.getDescriptionsDB());
        productAdder.getDescriptionFromUserInput("pierwszyOpis",appDB.getDescriptionsDB());
        productAdder.getDescriptionFromUserInput("drugiOpis",appDB.getDescriptionsDB());
        productAdder.getDescriptionFromUserInput("trzeciOpis",appDB.getDescriptionsDB());
        result = appDB.getDescriptionsDB().size();

        //then
        Assertions.assertEquals(expected, result);

    }
}
