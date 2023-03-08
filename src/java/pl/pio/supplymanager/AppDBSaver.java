package pl.pio.supplymanager;

import javafx.collections.ObservableList;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;

public class AppDBSaver {

    private AppDB appDB;

    public AppDBSaver(AppDB appDB) {
        this.appDB = appDB;
    }

    public void saveProductsToFile(String pathToFile) throws IOException {
        File file = new File(pathToFile);
        FileWriter myWriter = new FileWriter(file.getPath());

        ObservableList<Product> list = appDB.getProductsDB();
        for (int i = 0; i < list.size(); i++) {
            Product product = list.get(i);
            myWriter.write(product.getName() + "\t" + product.getCode() + "\t" + product.getDescriptionID() + "\t"
                            + product.getCategoryID() + "\t" + product.getProductionID() + "\t"
                            + product.getQuantity() + "\t" + product.getPrice() + (i < list.size() - 1 ? "\n" : ""));
        }
        myWriter.close();
    }

    public void saveProductionsToFile(String pathToFile) throws IOException {
        File file = new File(pathToFile);
        FileWriter myWriter = new FileWriter(file.getPath());

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        ObservableList<Production> list = appDB.getProductionDB();
        for (int i = 0; i < list.size(); i++) {
            Production production = list.get(i);
            myWriter.write(production.getProductionID() + "\t" + production.getManufacturer() + "\t"
                            + production.getCountry() + "\t" + formatter.format(production.getData()) + (i < list.size() - 1 ? "\n" : ""));
        }
        myWriter.close();
    }

    public void saveCategoriesToFile(String pathToFile) throws IOException {
        File file = new File(pathToFile);
        FileWriter myWriter = new FileWriter(file.getPath());

        ObservableList<Category> list = appDB.getCategoriesDB();
        for (int i = 0; i < list.size(); i++) {
            Category category = list.get(i);
            myWriter.write(category.getCategoryID() + "\t" + category.getCategory() + (i < list.size() - 1 ? "\n" : ""));
        }
        myWriter.close();
    }

    public void saveDescriptionsToFile(String pathToFile) throws IOException {
        File file = new File(pathToFile);
        FileWriter myWriter = new FileWriter(file.getPath());

        ObservableList<Description> list = appDB.getDescriptionsDB();
        for (int i = 0; i < list.size(); i++) {
            Description description = list.get(i);
            myWriter.write(description.getDescID() + "\t" + description.getDesc() + (i < list.size() - 1 ? "\n" : ""));
        }
        myWriter.close();
    }

}
