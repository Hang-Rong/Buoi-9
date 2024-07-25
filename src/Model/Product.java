package Model;

public class Product {
    private int id;
    private String name;
    private int price;
    private String catelogy;
    private static int idIncrement = 1;

    public Product(String name, int price, String catelogy) {
        this.id = idIncrement;
        this.name = name;
        this.price = price;
        this.catelogy = catelogy;
        idIncrement++;
    }
    public Product(int id,String name, int price, String catelogy) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.catelogy = catelogy;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCatelogy() {
        return catelogy;
    }

    public void setCatelogy(String catelogy) {
        this.catelogy = catelogy;
    }

    public static int getIdIncrement() {
        return idIncrement;
    }

    public static void setIdIncrement(int idIncrement) {
        Product.idIncrement = idIncrement;
    }

    @Override
    public String toString() {
        return "Sản phẩm số: " + id + " - Tên: " + name + " - Giá: " + price+ "đ" + " - Danh mục:" + catelogy;
    }
}
