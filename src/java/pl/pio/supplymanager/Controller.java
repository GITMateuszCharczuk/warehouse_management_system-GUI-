package pl.pio.supplymanager;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    @FXML private TableView<CompleteProductRecord> productsTable;
    @FXML private TableColumn<CompleteProductRecord, Button> colName;
    @FXML private TableColumn<CompleteProductRecord, Integer> colQuantity;
    @FXML private TableColumn<CompleteProductRecord, Integer> colCode;
    @FXML private TableColumn<CompleteProductRecord, String> colCategory;
    @FXML private TableColumn<CompleteProductRecord, String> colProducer;
    @FXML private TableColumn<CompleteProductRecord, Double> colPrice;
    @FXML private TableColumn<CompleteProductRecord, Button> colDescription;
    @FXML private TableColumn<CompleteProductRecord, CheckBox> colSelect;

    @FXML private Button saveButton;
    @FXML private Button archiveButton;
    @FXML private Button addNewItem;

    private AppDB appDB;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colName.setCellValueFactory(new PropertyValueFactory<CompleteProductRecord, Button>("changeProductNameButton"));
        colQuantity.setCellValueFactory(new PropertyValueFactory<CompleteProductRecord,Integer>("quantity"));
        colCode.setCellValueFactory(new PropertyValueFactory<CompleteProductRecord,Integer>("code"));
        colCategory.setCellValueFactory(new PropertyValueFactory<CompleteProductRecord,String>("category"));
        colProducer.setCellValueFactory(new PropertyValueFactory<CompleteProductRecord,String>("production"));
        colPrice.setCellValueFactory(new PropertyValueFactory<CompleteProductRecord,Double>("price"));
        colDescription.setCellValueFactory(new PropertyValueFactory<CompleteProductRecord, Button>("descriptionButton"));
        colDescription.setStyle("-fx-alignment: CENTER;");
        colSelect.setCellValueFactory(new PropertyValueFactory<CompleteProductRecord, CheckBox>("select"));
        colSelect.setStyle("-fx-alignment: CENTER;");

        appDB = new AppDB();
        try {
            appDB.readProductsFromFile("products.txt");
            appDB.readProductionsFromFile("productions.txt");
            appDB.readCategoriesFromFile("categories.txt");
            appDB.readDescriptionsFromFile("descriptions.txt");
            appDB.createCompleteProductDB(appDB.getCompleteProductRecordDB(), appDB.getProductsDB());
        } catch (Exception e) {
            e.printStackTrace();
        }
        productsTable.setItems(appDB.getCompleteProductRecordDB());
        preventColumnReordering(productsTable);

        saveButton.setOnAction(this::onSaveButtonClick);
        archiveButton.setOnAction(this::onArchiveButtonClick);
        addNewItem.setOnAction(this::onAddNewItemButtonClick);
    }

    public static <T> void preventColumnReordering(TableView<T> tableView) {
        Platform.runLater(() -> {
            for (Node header : tableView.lookupAll(".column-header")) {
                header.addEventFilter(MouseEvent.MOUSE_DRAGGED, Event::consume);
            }
        });
    }

    @FXML
    public void onSaveButtonClick(ActionEvent e) {
        AppDBSaver appDBSaver = new AppDBSaver(appDB);
        URL urlToProducts = getClass().getResource("products.txt");
        URL urlToProductions = getClass().getResource("productions.txt");
        URL urlToCategories = getClass().getResource("categories.txt");
        URL urlToDescriptions = getClass().getResource("descriptions.txt");
        try {
            appDBSaver.saveProductsToFile(urlToProducts.getPath());
            appDBSaver.saveProductionsToFile(urlToProductions.getPath());
            appDBSaver.saveCategoriesToFile(urlToCategories.getPath());
            appDBSaver.saveDescriptionsToFile(urlToDescriptions.getPath());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    public void onArchiveButtonClick(ActionEvent e) {
        AppDBSaver appDBSaver = new AppDBSaver(appDB);

        TextInputDialog td = new TextInputDialog("");
        td.setHeaderText("Podaj ścieżkę folderu do zapisania bazy danych");
        td.showAndWait();
        String folderPath = td.getEditor().getText().trim();
        File folder = new File(folderPath);
        if (!folder.exists()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Podano nieprawidłową ścieżkę!");
            alert.setContentText("Nie można odnaleźć takiego folderu!");
            alert.showAndWait();
            return;
        }

        try {
            appDBSaver.saveProductsToFile(folderPath + "\\products.txt");
            appDBSaver.saveProductionsToFile(folderPath + "\\productions.txt");
            appDBSaver.saveCategoriesToFile(folderPath + "\\categories.txt");
            appDBSaver.saveDescriptionsToFile(folderPath + "\\descriptions.txt");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    public void onAddNewItemButtonClick(ActionEvent e) {
        ProductAdder productAdder = new ProductAdder(appDB);
        productAdder.addNewProduct();
    }
}
