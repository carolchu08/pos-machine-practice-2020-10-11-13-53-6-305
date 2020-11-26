package pos.machine;

public class Battery extends Product {
    private String barcode ;
    private   int price ;
    private  String name;

    public Battery() {
        barcode ="ITEM000004";
        price =2;
        name="Battery";
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
