package com.assignment.model;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<Integer, Integer> itemsInShoppingCart = new HashMap<Integer, Integer>();

    public Map<Integer, Integer> getItemsInShoppingCart() {
        return itemsInShoppingCart;
    }

    public void setItemsInShoppingCart(Map<Integer, Integer> itemsInShoppingCart) {
        this.itemsInShoppingCart = itemsInShoppingCart;
    }
}
