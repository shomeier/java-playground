package org.sho.typeinference;

import java.util.List;
import java.util.stream.Collectors;

class Product {

    private final int stock;
    private final int value;
    private final String name;

    public Product(int stock, int value, String name) {
        this.stock = stock;
        this.value = value;
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}


public class IterimObjects {

    public static void main(String[] args) {
        var products = List.of(
                new Product(10, 3, "Apple"),
                new Product(5, 2, "Banana"),
                new Product(17, 5, "Pear"));
        var productInfos = products
                .stream()
                // using interim objects with anonymous classes here...
                .map(product -> new Object() {
                    String name = product.getName();
                    int total = product.getStock() * product.getValue();
                })
                .collect(Collectors.toList());

        // ... thx to local variable type inference we can access the attributes
        productInfos.forEach(prod -> System.out.println("name = " + prod.name + ", total = " +
                prod.total));

        // This outputs:
        // name = Apple, total = 30
        // name = Banana, total = 10
        // name = Pear, total = 85
    }
}
