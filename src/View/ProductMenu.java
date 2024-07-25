package View;

import Manager.ProductManager;
import Model.Product;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductMenu {
    static ProductManager ProductManager = new ProductManager();

    static Scanner inputInt = new Scanner(System.in);
    static Scanner inputString = new Scanner(System.in);
    static Scanner inputNumber = new Scanner(System.in);
    public static void showProductMenu() {
        int choice;
        do {
            System.out.println("===== Menu Sản Phẩm  =====");
            System.out.println("1. Thêm mới sản phẩm");
            System.out.println("2. Sửa thông tin sản phẩm");
            System.out.println("3. Xóa sản phẩm");
            System.out.println("4. Hiển thị tất cả sản phẩm");
            System.out.println("5. Tìm theo tên");
            System.out.println("6. Tìm theo khoảng giá");
            System.out.println("0. Thoát trình quản lý");
            System.out.print("Nhập lựa chọn: ");

            choice = inputInt.nextInt();
            switch (choice) {
                case 1:
                    showMenuAddProduct();
                    break;
                case 2:
                    showMenuEditProduct();
                    break;
                case 3:
                    showMenuRemoveProduct();
                    break;
                case 4:
                    showAllProduct();
                    break;
                case 5:
                    showMenuSearchByNameProduct();
                    break;
                case 6:
                    showMenuSearchByPriceRange();
                    break;
                default:
                    if (choice != 0) {
                        System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
                    }
            }
        } while (choice != 0);
    }

    public static void showMenuAddProduct() {
        System.out.println("===== Đây là menu thêm mới =====");
        System.out.print("Nhập tên sản phẩm: ");
        String name = inputString.nextLine();
        System.out.print("Nhập giá sản phẩm: ");
        int price = inputString.nextInt();
        inputString.nextLine();
        System.out.print("Nhập loại sản phẩm: ");
        String catelory = inputString.nextLine();
        Product product = new Product(name, price, catelory);
        ProductManager.add(product);
        System.out.println("===== Thêm thành công =====");
    }


    public static void showAllProduct() {
        System.out.println("Danh sách sản phẩm là: ");
        ArrayList<Product> productList = ProductManager.getAll();
        for (Product product : productList) {
            System.out.println(product);
        }
    }

    public static void showMenuRemoveProduct() {
        System.out.println("===== Xóa sản phẩm ===== ");
        System.out.print("Nhập mã sản phẩm: ");
        int idDelete = inputInt.nextInt();
        ProductManager.delete(idDelete);
        System.out.println("===== Xóa thành công =====");
    }

    public static void showMenuEditProduct() {
        System.out.println("===== Sửa thông tin sản phẩm =====");
        System.out.print("Nhập mã sản phẩm muốn sửa: ");
        int idEdit = inputInt.nextInt();
        inputInt.nextLine(); // Consume newline
        System.out.print("Nhập tên sản phẩm: ");
        String name = inputString.nextLine();
        System.out.print("Nhập giá sản phẩm: ");
        int price = inputInt.nextInt();
        inputInt.nextLine(); // Consume newline
        System.out.print("Nhập danh mục sản phẩm: ");
        String category = inputString.nextLine();
        Product newProduct = new Product(idEdit, name, price, category);
        ProductManager.update(idEdit, newProduct);
        System.out.println("===== Sửa thành công =====");
    }

    public static void showMenuSearchByNameProduct() {
        System.out.println("===== Tìm kiếm theo tên =====");
        System.out.print("Nhập tên: ");
        String name = inputString.nextLine();
        ArrayList<Product> productList = ProductManager.searchByName(name);
        if (productList.isEmpty()) {
            System.out.println("Không tìm thấy sản phẩm nào chứa " + name);
        } else {
            System.out.println("Danh sách sản phẩm có tên chứa " + name);
            for (Product product : productList) {
                System.out.println(product);
            }
        }
    }
    public static void showMenuSearchByPriceRange(){
        System.out.println("===== Tìm kiếm sản phẩm theo khoảng giá =====");
        System.out.println("Nhập khoảng giá muốn tìm kiếm" );
        System.out.print("Giá nhỏ nhất: ");
        int lower = inputNumber.nextInt();
        System.out.print("Giá lớn nhất: ");
        int upper = inputNumber.nextInt();
        ArrayList<Product> productList = ProductManager.searchByPriceRange(lower, upper);
        if(productList.isEmpty()){
            System.out.println("Không tìm thấy sản phẩm nào");
        } else {
            System.out.println("Danh sách sản phẩm có khoảng giá từ " + lower + " đến " + upper);
            for(Product product : productList){
                System.out.println(product);
            }
        }
    }
}
