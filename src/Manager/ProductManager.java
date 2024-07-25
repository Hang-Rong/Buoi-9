package Manager;

import Model.Product;

import java.util.ArrayList;


public class ProductManager implements IManager<Product> {
    ArrayList<Product> productList;

    public ProductManager(){
        this.productList = new ArrayList<>();
    }
    @Override
    public void add(Product product) {
        productList.add(product);
    }

    @Override
    public void delete(int id) {
        int index = findIndexById(id);
        productList.remove(index);
    }

    @Override
    public int findIndexById(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if(productList.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }


    public ArrayList<Product> searchByName(String name) {
        ArrayList<Product> productList = new ArrayList<>();
        for(int i = 0; i < productList.size(); i++) {
            if(productList.get(i).getName().toLowerCase().contains(name.toLowerCase())) {
                productList.add(productList.get(i));
            }
        }
        return productList;
    }


    @Override
    public ArrayList<Product> searchByPriceRange(int lower, int upper) {
        ArrayList<Product> product = new ArrayList<>();
        for(int i = 0; i < productList.size(); i++) {
            if(productList.get(i).getPrice() >= lower && productList.get(i).getPrice() <= upper) {
                product.add(productList.get(i));
            }
        }
        return product;
    }

    @Override
    public void update(int id, Product product) {

    }

    @Override
    public ArrayList<Product> getAll() {
        return productList;
    }
}

