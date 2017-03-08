import javafx.beans.property.*;

public class Product {

    private final IntegerProperty productId = new SimpleIntegerProperty();
    private final StringProperty productName = new SimpleStringProperty();
    private final FloatProperty productCost = new SimpleFloatProperty();

    public Product(){}


    public Product(Integer productId,String productName,Float productCost){
        setProductId(productId);
        setProductName(productName);
        setProductCost(productCost);
    }

    public int getProductId() {
        return productId.get();
    }

    public IntegerProperty productIdProperty() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId.set(productId);
    }

    public String getProductName() {
        return productName.get();
    }

    public StringProperty productNameProperty() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName.set(productName);
    }

    public float getProductCost() {
        return productCost.get();
    }

    public FloatProperty productCostProperty() {
        return productCost;
    }

    public void setProductCost(float productCost) {
        this.productCost.set(productCost);
    }
}
