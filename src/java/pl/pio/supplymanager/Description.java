package pl.pio.supplymanager;

public class Description {
    private int descID;
    private String desc;

    public Description(int descID, String desc) {
        this.desc = desc;
        this.descID = descID;
    }

    public int getDescID() {
        return descID;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public int hashCode() {
        return descID;
    }

    @Override
    public boolean equals( Object o ) {
        if( o instanceof Description ) {
            Description desc = (Description)o;
            return (desc.descID == this.descID) && (desc.desc.equals(this.desc));
        } else {
            return false;
        }
    }
}