package Manager;

import Model.Customer;
import Model.Product;

import java.util.ArrayList;

public interface IManager<E> {
    void add(E e);
    void delete(int id);
    int findIndexById(int id);
    ArrayList<E> searchByName(String name);
    ArrayList<E> searchByPriceRange(int lower, int upper);
    void update(int id, E e);
    ArrayList<E> getAll();
}