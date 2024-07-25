package Model;

public class Customer {
    private int id;
    private String name;
    private String address;
    private String phone;
    private String email;
    private String gender;
    private int age;
    private static int idIncrement = 1;
    public Customer(String name,int age, String gender, String address, String phone, String email) {
        this.id = idIncrement++;
        this.name = name;
        this.age = age;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
    }
    public Customer (int id, String name, int age ,String gender, String address, String phone, String email ) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public static int getIdIncrement() {
        return idIncrement;
    }

    public static void setIdIncrement(int idIncrement) {
        Customer.idIncrement = idIncrement;
    }
    @Override
    public String toString() {
        return "- Khách hàng số: " + id + " , Tên: " + name + " , Giới tính: " + gender + " , Số điện thoại: " + phone +" , Email: " + email + " -";
    }
}
