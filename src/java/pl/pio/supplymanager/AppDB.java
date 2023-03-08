package pl.pio.supplymanager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class AppDB {
    private ObservableList<CompleteProductRecord> completeProductRecordDB = FXCollections.observableArrayList();
    private ObservableList<Product> productsDB = FXCollections.observableArrayList();
    private ObservableList<Production> productionDB = FXCollections.observableArrayList();
    private ObservableList<Category> categoriesDB = FXCollections.observableArrayList();
    private ObservableList<Description> descriptionsDB = FXCollections.observableArrayList();

    public void readProductsFromFile(String pathToFile) throws FileNotFoundException {
        int code;
        int descriptionID;
        int categoryID;
        int productionID;
        String name;
        int quantity;
        double price;

        URL url = getClass().getResource(pathToFile);
        assert url != null;
        File file = new File(url.getPath());
        Scanner input = new Scanner(file);

        while (input.hasNextLine()) {
            String line = input.nextLine();
            if (line.trim().isEmpty()) continue;

            String[] parts = line.split("\\t");

            if (parts.length == 7) {
                name = parts[0].trim();
                code = parseInt(parts[1]);
                descriptionID = parseInt(parts[2]);
                categoryID = parseInt(parts[3]);
                productionID = parseInt(parts[4]);
                quantity = parseInt(parts[5]);
                price = parseDouble(parts[6]);

                productsDB.add(new Product(code, descriptionID, categoryID, productionID, name, quantity, price));
                //System.out.printf("Dodano produkt poprawnie (" + name + ")\n");
            }
        }
    }

    public void readProductionsFromFile(String pathToFile) throws FileNotFoundException, ParseException {
        int productionID;
        String manufacturer;
        String country;
        Date data;

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        URL url = getClass().getResource(pathToFile);
        assert url != null;
        File file = new File(url.getPath());
        Scanner input = new Scanner(file);

        while (input.hasNextLine()) {
            String line = input.nextLine();
            if (line.trim().isEmpty()) continue;

            String[] parts = line.split("\\t");

            if (parts.length == 4) {
                productionID = parseInt(parts[0]);
                manufacturer = parts[1].trim();
                country = parts[2].trim();
                String dateAsString = parts[3].trim();
                data = formatter.parse(dateAsString);

                productionDB.add(new Production(productionID, manufacturer, country, data));
                //System.out.printf("Dodano producenta poprawnie (" + manufacturer + ")\n");
            }
        }
    }

    public void readCategoriesFromFile(String pathToFile) throws FileNotFoundException {
        int categoryID;
        String category;

        URL url = getClass().getResource(pathToFile);
        assert url != null;
        File file = new File(url.getPath());
        Scanner input = new Scanner(file);

        while (input.hasNextLine()) {
            String line = input.nextLine();
            if (line.trim().isEmpty()) continue;

            String[] parts = line.split("\\t");

            if (parts.length == 2) {
                categoryID = parseInt(parts[0]);
                category = parts[1].trim();

                categoriesDB.add(new Category(categoryID, category));
                //System.out.printf("Dodano kategorię poprawnie (" + category + ")\n");
            }
        }
    }

    public void readDescriptionsFromFile(String pathToFile) throws FileNotFoundException {
        int descID;
        String desc;

        URL url = getClass().getResource(pathToFile);
        assert url != null;
        File file = new File(url.getPath());
        Scanner input = new Scanner(file);

        while (input.hasNextLine()) {
            String line = input.nextLine();
            if (line.trim().isEmpty()) continue;

            String[] parts = line.split("\\t");

            if (parts.length == 2) {
                descID = parseInt(parts[0]);
                desc = parts[1].trim();

                descriptionsDB.add(new Description(descID, desc));
                //System.out.printf("Dodano opis poprawnie (" + desc.substring(0, 10) + "...)\n");
            }
        }
    }

    public String getCategoryAsID(int ID) {
        Category cat = categoriesDB.get(ID - 1);
        return cat.getCategory();
    }

    public String getDiscriptionAsID(int ID) {
        Description des = descriptionsDB.get(ID - 1);
        return des.getDesc();

    }

    public String getProductionAsID(int ID) {
        Production pro = productionDB.get(ID - 1);
        return pro.getManufacturer();
    }

    public void createCompleteProductDB(ObservableList<CompleteProductRecord> completeProductRecordDB, ObservableList<Product> productsDB) {
        int size = productsDB.size();
        for (int currentIndex = 0; currentIndex < size; currentIndex++) {
            String code;
            String description;
            String category;
            String production;
            String name;
            int quantity;
            double price;

            Product currentProduct = productsDB.get(currentIndex);

            code = String.valueOf(currentProduct.getCode());
            name = currentProduct.getName();
            quantity = currentProduct.getQuantity();
            price = currentProduct.getPrice();

            category = getCategoryAsID(currentProduct.getCategoryID());
            production = getProductionAsID(currentProduct.getProductionID());
            description = getDiscriptionAsID(currentProduct.getDescriptionID());


            completeProductRecordDB.add(new CompleteProductRecord(code, description, category, production, name, quantity, price, this));
        }
    }

    public ObservableList<Product> getProductsDB() {
        return productsDB;
    }

    public ObservableList<Production> getProductionDB() {
        return productionDB;
    }

    public ObservableList<Category> getCategoriesDB() {
        return categoriesDB;
    }

    public ObservableList<Description> getDescriptionsDB() {
        return descriptionsDB;
    }

    public ObservableList<CompleteProductRecord> getCompleteProductRecordDB() {
        return completeProductRecordDB;
    }
    public void searchAndSetNameProduct(String name, String newName){
        for (Product p:productsDB) {
            if(p.getName().equals(name))
            {
                p.setName(newName);
            }
        }
    }
    public boolean searchNameProduct(String name){
        for (Product p:productsDB) {
            if(p.getName().equals(name))
            {
                return true;
            }
        }
        return false;
    }
    public void searchAndSetNameCompleteProductRecord(String name, String newName){
        for (CompleteProductRecord p:completeProductRecordDB) {
            if(p.getName().equals(name))
            {
                p.setName(newName);
            }
        }
    }
    public boolean searchNameCompleteProductRecord(String name){
        for (CompleteProductRecord p:completeProductRecordDB) {
            if(p.getName().equals(name))
            {
                return true;
            }
        }
        return false;
    }

    public void deleteProductsFromDB(Product product){
        productsDB.remove(product);
    }

}
