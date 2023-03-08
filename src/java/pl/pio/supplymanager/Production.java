package pl.pio.supplymanager;

import java.util.Date;

public class Production implements Comparable<Production>{
    private int productionID;
    private String manufacturer;
    private String country;
    private Date data;

    public Production(int productionID, String manufacturer, String country, Date data) {
        this.productionID = productionID;
        this.manufacturer = manufacturer;
        this.country = country;
        this.data = data;
    }

    public int getProductionID() {
        return productionID;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getCountry() {
        return country;
    }

    public Date getData() {
        return data;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public void setData(Date data) {
        this.data = data;
    }
    @Override
    public int compareTo(Production production2){
        return this.manufacturer.compareTo(production2.manufacturer);
    }

    @Override
    public int hashCode() {
        return productionID;
    }

    @Override
    public boolean equals( Object o ) {
        if( o instanceof Production ) {
            Production prod = (Production)o;
            return prod.productionID == this.productionID;
        } else {
            return false;
        }
    }
}
