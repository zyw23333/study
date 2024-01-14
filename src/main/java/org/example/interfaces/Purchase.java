package org.example.interfaces;

public interface Purchase {
    Integer price();
    
    default String name() {
        return "default";
    }

    public static void main(String[] args) {
        Purchase shop = () -> 1;
        System.out.println(shop.price() + shop.name());
    }
}
