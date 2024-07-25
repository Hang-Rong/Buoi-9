package Manager;

import Model.Customer;

import java.util.ArrayList;

public class CustomerManager implements IManager<Customer> {

    private ArrayList<Customer> customers;

    public CustomerManager() {
        this.customers = new ArrayList<>();
    }

    @Override
    public void add(Customer customer) {
        customers.add(customer);
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getId() == id) {
                customers.remove(i);
                return;
            }
        }
    }

    @Override
    public int findIndexById(int id) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public ArrayList<Customer> searchByName(String name) {
        ArrayList<Customer> result = new ArrayList<>();
        for (Customer customer : customers) {
            if (customer.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(customer);
            }
        }
        return result;
    }

    @Override
    public ArrayList<Customer> searchByPriceRange(int lower, int upper) {
        return null;
    }

    @Override
    public void update(int id, Customer customer) {
        int index = findIndexById(id);
        if (index != -1) {
            customers.set(index, customer);
        }
    }

    @Override
    public ArrayList<Customer> getAll() {
        return customers;
    }
}
