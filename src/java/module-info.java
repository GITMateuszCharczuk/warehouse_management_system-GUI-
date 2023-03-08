module pl.pio.supplymanager {
    requires javafx.controls;
    requires javafx.fxml;


    opens pl.pio.supplymanager to javafx.fxml;
    exports pl.pio.supplymanager;
}