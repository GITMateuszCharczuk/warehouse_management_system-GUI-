package pl.pio.supplymanager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextInputDialog;

import java.util.Date;

public class ProductAdder {
    
    AppDB appDB;
    public ProductAdder(AppDB appDB){
        this.appDB = appDB;
    }

    public void addNewProduct() {
        ObservableList<Production> productionDB = appDB.getProductionDB();
        ObservableList<Category> categoriesDB = appDB.getCategoriesDB();
        ObservableList<Description> descriptionsDB = appDB.getDescriptionsDB();

        Product newProduct = new Product();
        String description;
        String category;
        String production;
        String name;
        int quantity;
        double price;

        TextInputDialog td = new TextInputDialog("");
        td.setHeaderText("Podaj nazwę produktu");
        td.showAndWait();
        String nameFromUser = td.getEditor().getText().trim();

        td = new TextInputDialog("");
        td.setHeaderText("Podaj ilość produktu");
        td.showAndWait();
        int quantityFromUser = Integer.parseInt(td.getEditor().getText());

        td = new TextInputDialog("");
        td.setHeaderText("Podaj kategorię produktu");
        td.showAndWait();
        String categoryFromUser = td.getEditor().getText().trim();

        td = new TextInputDialog("");
        td.setHeaderText("Podaj producenta produktu");
        td.showAndWait();
        String productionFromUser = td.getEditor().getText().trim();

        td = new TextInputDialog("");
        td.setHeaderText("Podaj cenę produktu");
        td.showAndWait();
        double priceFromUser = Double.parseDouble(td.getEditor().getText().trim());

        td = new TextInputDialog("");
        td.setHeaderText("Podaj opis produktu");
        td.showAndWait();
        String descriptionFromUser = td.getEditor().getText().trim();

        newProduct.setCode(appDB.getCompleteProductRecordDB().size()+1);
        newProduct.setName(nameFromUser);
        newProduct.setQuantity(quantityFromUser);
        newProduct.setPrice(priceFromUser);
        String code = String.valueOf(newProduct.getCode());

        newProduct.setCategoryID(getCategoryFromUserInput(categoryFromUser,categoriesDB));
        newProduct.setProductionID(getProductionFromUserInput(productionFromUser,productionDB));
        newProduct.setDescriptionID(getDescriptionFromUserInput(descriptionFromUser, descriptionsDB));

        name = newProduct.getName();
        quantity = newProduct.getQuantity();
        price = newProduct.getPrice();
        category = appDB.getCategoryAsID(newProduct.getCategoryID());
        production = appDB.getProductionAsID(newProduct.getProductionID());
        description = appDB.getDiscriptionAsID(newProduct.getDescriptionID());

        CompleteProductRecord newItem = new CompleteProductRecord(code, description, category, production,name,quantity,price, appDB);
        appDB.getCompleteProductRecordDB().add(newItem);

        appDB.getProductsDB().add(newProduct);
    }

    public int getDescriptionFromUserInput(String descriptionFromUser, ObservableList<Description> descriptionsDB) {
        int descriptionID = -1;
        for(int i = 0; i <descriptionsDB.size(); i++) {
            if (descriptionsDB.get(i).getDesc().equals(descriptionFromUser)) {
                return descriptionsDB.get(i).getDescID();
            }
        }
        if(descriptionID == -1) {
            descriptionsDB.add(new Description(descriptionsDB.size() + 1, descriptionFromUser));
            return descriptionsDB.size();
        }
        return 0;
    }

    public int getProductionFromUserInput(String productionFromUser, ObservableList<Production> productionDB) {
        int productionID = -1;
        for(int i = 0; i <productionDB.size(); i++) {
            if (productionDB.get(i).getManufacturer().equals(productionFromUser)) {
                return productionDB.get(i).getProductionID();
            }
        }
        if(productionID == -1) {
            productionDB.add(new Production(productionDB.size() + 1, productionFromUser, "", new Date()));
            return productionDB.size();
        }
        return 0;
    }

    public int getCategoryFromUserInput(String categoryFromUser, ObservableList<Category> categoriesDB) {
        int categoryId = -1;
        for (int i = 0; i <categoriesDB.size(); i++) {
            if (categoriesDB.get(i).getCategory().equals(categoryFromUser)) {
                return categoriesDB.get(i).getCategoryID();
            }
        }
        if(categoryId == -1) {
            categoriesDB.add(new Category(categoriesDB.size() + 1, categoryFromUser));
            return categoriesDB.size();
        }
        return 0;
    }


}
