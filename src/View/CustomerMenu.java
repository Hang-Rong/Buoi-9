package View;

import java.util.ArrayList;
import java.util.Scanner;
import Manager.CustomerManager;
import Model.Customer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerMenu {
    static Manager.CustomerManager CustomerManager = new CustomerManager();

    static Scanner inputInt = new Scanner(System.in);
    static Scanner inputString = new Scanner(System.in);
    static Scanner inputNumber = new Scanner(System.in);

    public static void showCustomerMenu() {
        int choice;
        do {
            System.out.println("===== Menu Khách hàng  =====");
            System.out.println("1. Thêm mới khách hàng");
            System.out.println("2. Sửa thông tin khách hàng");
            System.out.println("3. Xóa khách hàng");
            System.out.println("4. Hiển thị tds khách hàng");
            System.out.println("5. Tìm theo tên");
            System.out.println("0. Thoát trình quản lý");
            System.out.print("Nhập lựa chọn: ");

            choice = inputInt.nextInt();
            switch (choice) {
                case 1:
                    showMenuAddCustomer();
                    break;
                case 2:
                    showMenuEditCustomer();
                    break;
                case 3:
                    showMenuRemoveCustomer();
                    break;
                case 4:
                    showAllCustomer();
                    break;
                case 5:
                    showMenuSearchByNameCustomer();
                    break;
                default:
                    if (choice != 0) {
                        System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
                    }
            }
        } while (choice != 0);
    }

    private static void showMenuSearchByNameCustomer() {
        System.out.println("=========Tìm kiếm khách hàng theo tên=========");
        System.out.print("Nhập tên khách hàng muốn tìm kiếm: ");
        String name = inputString.nextLine();
        ArrayList<Customer> customers = CustomerManager.searchByName(name);
        if(((ArrayList<?>) customers).isEmpty()){
            System.out.println("Không có khách hàng nào có tên " + name);
        } else {
            System.out.println("Danh sách khách hàng có tên " + name);
            for(Customer customer : customers){
                System.out.println(customer);
            }
        }
    }

    private static void showAllCustomer() {
        System.out.println("=========Danh sách khách hàng=========");
        for(Customer customer : CustomerManager.getAll()){
            System.out.println(customer);
        }
    }

    private static void showMenuRemoveCustomer() {
        int idRemove;
        System.out.print("Nhập mã khách hàng muốn xóa: ");
        idRemove = inputNumber.nextInt();
        if(CustomerManager.findIndexById(idRemove)==-1){
            System.out.println("Không tìm thấy mã khách hàng!");
        } else {
            CustomerManager.delete(idRemove);
            System.out.println("Xóa khách hàng thành công!");
        }
    }

    private static void showMenuEditCustomer() {
        int idEdit;
        System.out.println("=========Sửa thông tin khách hàng=========");
        do{
            System.out.print("Nhập mã khách hàng muốn sửa: ");
            idEdit = inputNumber.nextInt();
            if(CustomerManager.findIndexById(idEdit)==-1){
                System.out.println("Mã khách hàng không tồn tại! Yêu cầu nhập lại.");
            }
        }while(CustomerManager.findIndexById(idEdit) ==-1);
        System.out.print("Nhập tên: ");
        String name = inputString.nextLine();
        System.out.print("Nhập tuổi: ");
        int age = inputNumber.nextInt();
        System.out.print("Nhập giới tính: ");
        String gender = inputString.nextLine();
        System.out.print("Nhập địa chỉ: ");
        String address = inputString.nextLine();
        System.out.print("Nhập số điện thoại: ");
        String phone = inputString.nextLine();
        while (isValidPhone(phone)) {
            System.out.println("Số điện thoại không hợp lệ! Vui lòng nhập lại.");
            System.out.print("Nhập số điện thoại khách hàng: ");
            phone = inputString.nextLine();
        }
        System.out.print("Nhập email: ");
        String email = inputString.nextLine();
        while (isValidEmail(email)) {
            System.out.println("Email không hợp lệ! Vui lòng nhập lại.");
            System.out.print("Nhập email khách hàng: ");
            email = inputString.nextLine();
        }
        Customer customer = new Customer(idEdit,name,age,gender,address,phone,email);
        CustomerManager.update(idEdit, customer);
        System.out.println("Sửa thông tin khách hàng thành công!");
    }

    private static void showMenuAddCustomer() {
        System.out.println("===== Đây là menu thêm mới =====");
        System.out.print("Nhập tên: ");
        String name = inputString.nextLine();
        System.out.println("Nhập tuổi: ");
        int age = inputNumber.nextInt();
        System.out.print("Giới tính: ");
        String gender = inputString.nextLine();
        System.out.print("Địa chỉ: ");
        String address = inputString.nextLine();
        inputString.nextLine();
        System.out.print("Số điện thoại: ");
        String phone = inputString.nextLine();
        while (isValidPhone(phone)) {
            System.out.println("Số điện thoại không hợp lệ! Vui lòng nhập lại.");
            System.out.print("Nhập số điện thoại khách hàng: ");
            phone = inputString.nextLine();
        }
        System.out.print("Email: ");
        String email = inputString.nextLine();
        while (isValidEmail(email)) {
            System.out.println("Email không hợp lệ! Vui lòng nhập lại.");
            System.out.print("Nhập email khách hàng: ");
            email = inputString.nextLine();
        }
        Customer customer = new Customer(name, age, gender, address, phone, email );
        CustomerManager.add(customer);
        System.out.println("===== Thêm thành công =====");
    }
    private static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return !matcher.matches();
    }

    private static boolean isValidPhone(String phone) {
        String phoneRegex = "^0\\d{9}$";
        Pattern pattern = Pattern.compile(phoneRegex);
        Matcher matcher = pattern.matcher(phone);
        return !((Matcher) matcher).matches();
    }
}
