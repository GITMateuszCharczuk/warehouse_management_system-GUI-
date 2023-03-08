package pl.pio.supplymanager;

import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class DescriptionButton extends Button {

    private final String productName;
    private final String description;

    public DescriptionButton(String productName, String description) {
        super("Pokaż");
        this.productName = productName;
        this.description = description;
        setPrefWidth(200);
        setPrefHeight(200);
        setStyle(".button{\n" +
                "    -fx-border-color: transparent;\n" +
//                "    -fx-font-color: #333;\n" +
                "    -fx-border-width: 0;\n" +
                "    -fx-background-radius: 0;\n" +
                "    -fx-background-color: transparent;\n" +
                "    -fx-font-family:\"Segoe UI\", Helvetica, Arial, sans-serif;\n" +
                "    -fx-font-size: 1em; /* 12 */\n" +
                "    -fx-text-fill: #333;\n" +
                "}"
        );
        setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setStyle("-fx-background-color: #0096C9;\n"+
                        "-fx-text-fill: #fff");
            }
        });
        setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setStyle("-fx-background-color: transparent;");
            }
        });

        setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Alert descriptionAlert = new Alert(Alert.AlertType.INFORMATION);
                descriptionAlert.setTitle("Opis produktu");
                descriptionAlert.setHeaderText(productName);
                descriptionAlert.setContentText(getDescription());
                descriptionAlert.showAndWait();
            }
        });
    }

    public String getDescription() {
        return description;
    }
}
