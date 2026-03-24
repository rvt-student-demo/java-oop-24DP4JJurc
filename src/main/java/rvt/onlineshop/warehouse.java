package rvt.onlineshop;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class warehouse {

    private Map<String, Integer> prices;
    private Map<String, Integer> stock;

    public warehouse() {
        this.prices = new HashMap<>();
        this.stock = new HashMap<>();
    }

    public void addProduct(String product, int price, int stock) {
        this.prices.put(product, price);
        this.stock.put(product, stock);
    }

    public int price(String product) {
        return this.prices.getOrDefault(product, -99);
    }

    public int stock(String product) {
        return this.stock.getOrDefault(product, 0);
    }

    public boolean take(String product) {
        if (!this.stock.containsKey(product)) {
            return false;
        }

        int currentStock = this.stock.get(product);

        if (currentStock > 0) {
            this.stock.put(product, currentStock - 1);
            return true;
        }

        return false;
    }

    public Set<String> products() {
        return this.prices.keySet();
    }
}
