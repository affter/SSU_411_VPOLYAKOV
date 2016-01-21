package com.company;

import java.util.*;

/**
 * Created by ASUS on 21.01.2016.
 */
public class Busket implements IBusket {
    private List<String> products = new LinkedList<>();
    private List<Integer> prices = new LinkedList<>();
    public void addProduct(String product, int quantity) {
        products.add(product);
        prices.add(quantity);
    }
    public void removeProduct(String product){
            prices.remove(products.indexOf(product));
            products.remove(products.indexOf(product));
    }
    public void updateProductQuantity(String product, int quantity){
        prices.set(products.indexOf(product),quantity);
    }
    public void clear(){
        products.clear();
        prices.clear();
    }
    public List<String> getProducts(){
        return products;
    }
    public int getProductQuantity(String product){
        return prices.get(products.indexOf(product));
    }
}
