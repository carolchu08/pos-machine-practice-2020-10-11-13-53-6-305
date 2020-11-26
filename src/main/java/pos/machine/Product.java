package pos.machine;

public abstract class Product {
    private String barcode;
    private int price;
    private  String name;

    public String getBarcode() {
        return barcode;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
