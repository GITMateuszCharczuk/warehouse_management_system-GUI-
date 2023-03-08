package pl.pio.supplymanager;

import javafx.application.Platform;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CompleteProductRecordTest {

    @Test
    void testEquals() {
        try {
            Platform.startup(() -> {}); // init javafx toolkit
        } catch (Exception e) { // the only error is when the toolkit has been already initialised
        }

        AppDB appDb = new AppDB();
        CompleteProductRecord compareCompleteProductRecord = new CompleteProductRecord("1", "example description", "example category", "example production","example name", 1, 1.0, appDb);
        CompleteProductRecord compareCompleteProductRecord2 = new CompleteProductRecord("1", "example description", "example category", "example production","example name", 1, 1.0, appDb);
        CompleteProductRecord compareCompleteProductRecord3 = new CompleteProductRecord("2", "example description", "example category", "example production","example name 2", 1, 1.0, appDb);
        CompleteProductRecord compareCompleteProductRecord4 = new CompleteProductRecord("3", "example description", "example category", "example production","example name 3", 1, 1.0, appDb);
        Object obj = new Object();

        Assertions.assertEquals(compareCompleteProductRecord, compareCompleteProductRecord2);
        Assertions.assertFalse(compareCompleteProductRecord.equals(compareCompleteProductRecord3));
        Assertions.assertFalse(compareCompleteProductRecord.equals(compareCompleteProductRecord4));
        Assertions.assertFalse(compareCompleteProductRecord.equals(obj));
    }

    @Test
    void testCompareTo(){
        try {
            Platform.startup(() -> {}); // init javafx toolkit
        } catch (Exception e) { // the only error is when the toolkit has been already initialised
        }

        AppDB appDb = new AppDB();
        CompleteProductRecord compareCompleteProductRecord = new CompleteProductRecord("1", "example description", "example category", "example production","example name", 1, 1.0, appDb);
        CompleteProductRecord secondCompleteProductRecord = new CompleteProductRecord("1", "example description", "example category", "example production","example name", 1, 1.0, appDb);
        CompleteProductRecord thirdCompleteProductRecord = new CompleteProductRecord("2", "example description", "example category", "example production","example name 2", 1, 1.0, appDb);
        CompleteProductRecord fourthCompleteProductRecord = new CompleteProductRecord("3", "example description", "example category", "example production","example name 3", 1, 1.0, appDb);

        Assertions.assertEquals(0, compareCompleteProductRecord.compareTo(secondCompleteProductRecord));
        Assertions.assertFalse(compareCompleteProductRecord.equals(thirdCompleteProductRecord));
        Assertions.assertFalse(compareCompleteProductRecord.equals(fourthCompleteProductRecord));
    }

}