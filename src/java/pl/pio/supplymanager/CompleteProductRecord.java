package pl.pio.supplymanager;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class CompleteProductRecord implements Comparable<pl.pio.supplymanager.CompleteProductRecord>{
    private String code;
    private DescriptionButton descriptionButton;
    private ChangeProductNameButton changeProductNameButton;
    private String category;
    private String production;
    private String name;
    private int quantity;
    private double price;
    private CheckBox select;

    public void setName(String name) {
        this.name = name;
    }

    public CompleteProductRecord(String code, String description, String category, String production, String name, int quantity, double price, AppDB appDb) {
        this.code = code;
        this.descriptionButton = new DescriptionButton(name, description);
        this.changeProductNameButton = new ChangeProductNameButton(name, appDb);
        this.category = category;
        this.production = production;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.select = new CheckBox();
    }

    public String getCode() {
        return code;
    }

    public Button getDescriptionButton() {
        return descriptionButton;
    }
    public Button getChangeProductNameButton() {
        return changeProductNameButton;
    }

    public String getCategory() {
        return category;
    }

    public String getProduction() {
        return production;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
    public CheckBox getSelect(){
        return select;
    }

    public void setSelect(CheckBox select){
        this.select = select;
    }

    @Override
    public boolean equals( Object o ) {
        if( o instanceof pl.pio.supplymanager.CompleteProductRecord) {
            pl.pio.supplymanager.CompleteProductRecord os = (pl.pio.supplymanager.CompleteProductRecord)o;
            return Integer.parseInt(os.code) == Integer.parseInt(this.code);
        } else {
            return false;
        }
    }
    @Override
    public int compareTo(pl.pio.supplymanager.CompleteProductRecord cmp2){
        return this.quantity - cmp2.quantity;
    }

    public int compareToQuantity(pl.pio.supplymanager.CompleteProductRecord cmp2){
        return this.quantity - cmp2.quantity;
    }
    public double compareToPrice(pl.pio.supplymanager.CompleteProductRecord cmp2){
        return this.price - cmp2.price;
    }

    @Override
    public int hashCode() {
        return Integer.parseInt(code);
    }
}

