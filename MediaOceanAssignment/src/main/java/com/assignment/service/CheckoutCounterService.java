package com.assignment.service;

import com.assignment.dao.ShoppingCartDao;
import com.assignment.model.Category;
import com.assignment.model.ItemisedBill;
import com.assignment.model.Product;
import com.assignment.model.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Random;


@Service
public class CheckoutCounterService {

    @Autowired
    ShoppingCartDao shoppingCartDao;

    public ItemisedBill calculateBill(ShoppingCart cart) {
        Map<Integer, Integer> cartDetails = cart.getItemsInShoppingCart();
        ItemisedBill bill = new ItemisedBill();
        bill.setBillId(new Random().nextInt());
        double price = 0;
        double taxPrice = 0;
        for (Integer item : cartDetails.keySet()) {
            Product product = shoppingCartDao.getProduct(item);
            Category category = shoppingCartDao.getCategory(product.getCategory().getCategoryId());
            int taxPercent = category.getTaxPercent();
            taxPrice += product.getProductCost() + ((product.getProductCost() * cartDetails.get(item)) * (taxPercent / 100));
            price += (category.getTaxPercent() * cartDetails.get(item) * product.getProductCost());
            bill.getProducts().add(product);
        }

        bill.setTotalBillAmount(price);
        bill.setTotalTaxes(taxPrice);


        return bill;

    }
}
