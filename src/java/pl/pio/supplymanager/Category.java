package pl.pio.supplymanager;

public class Category implements Comparable<Category>{
    private int categoryID;
    private String category;

    public Category(int categoryID, String category) {
        this.categoryID = categoryID;
        this.category = category;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category){
        this.category = category;
    }
    @Override
    public int compareTo(Category category2){
        return this.category.compareTo(category2.category);
    }

    @Override
    public int hashCode() {
        return categoryID;
    }
    @Override
    public boolean equals( Object o ) {
        if( o instanceof Category ) {
            Category cat = (Category)o;
            return (cat.categoryID == this.categoryID) && (cat.category.equals(this.category));
        } else {
            return false;
        }
    }
}
