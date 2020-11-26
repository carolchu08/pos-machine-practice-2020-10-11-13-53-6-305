package pos.machine;

public class Sprite extends Product{
    private   String barcode;
    private int price;
    private  String name;

    public Sprite() {
        barcode = "ITEM000001";
        price = 3;
        name="Sprite";
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
