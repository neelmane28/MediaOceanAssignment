package com.assignment.controller;

import com.assignment.model.Category;
import com.assignment.model.ItemisedBill;
import com.assignment.model.Product;
import com.assignment.model.ShoppingCart;
import com.assignment.service.CheckoutCounterService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CheckoutCounterControllerTest {
    private static final int ANY_INT = 1;
    private static final String ANY_CATEGORY = "Grossary";
    private ShoppingCart cart;
    @Mock
    private CheckoutCounterService checkoutCounterService;
    @InjectMocks
    private CheckoutCounterController checkoutCounterController;

    @Before
    public void setUp() throws Exception {
        Map<Integer, Integer> itemsInShoppingCart = new HashMap<Integer, Integer>();
        cart = new ShoppingCart();
        itemsInShoppingCart.put(1, 1);
        itemsInShoppingCart.put(2, 1);
        itemsInShoppingCart.put(3, 4);
        cart.setItemsInShoppingCart(itemsInShoppingCart);
    }

    @Test
    public void generateBill() {
        ItemisedBill expectedBill = expectedItemisedBill();
        when(checkoutCounterService.calculateBill(cart)).thenReturn(expectedBill);
        ItemisedBill actualBill = checkoutCounterController.generateBill(cart);

        assertNotNull(actualBill.getBillId());
        assertEquals(expectedBill.getProducts().size(), actualBill.getProducts().size());
        assertEquals(expectedBill.getTotalTaxes(), actualBill.getTotalTaxes());
        assertEquals(expectedBill.getTotalBillAmount(), actualBill.getTotalBillAmount());

    }

    private ItemisedBill expectedItemisedBill() {
        ItemisedBill expectedBill = new ItemisedBill();
        List<Product> productsList = new ArrayList<Product>();
        Category category = getCategory(ANY_INT, ANY_CATEGORY, 10);
        Category category2 = getCategory(ANY_INT, ANY_CATEGORY, 20);
        Category category3 = getCategory(ANY_INT, ANY_CATEGORY, 0);
        Product product = getProduct(1, category, 1, 10, "Soap");
        Product secondProduct = getProduct(2, category2, 1, 15, "Sugar");
        Product thirdProduct = getProduct(3, category3, 1, 5, "Oil");
        productsList.add(product);
        productsList.add(secondProduct);
        productsList.add(thirdProduct);
        expectedBill.setProducts(productsList);
        expectedBill.setTotalBillAmount(9500d);
        expectedBill.setTotalTaxes(350d);
        return expectedBill;
    }

    private Category getCategory(int categoryId, String categoryName, int taxPercent) {
        Category category = new Category();
        category.setCategoryId(categoryId);
        category.setCategoryName(categoryName);
        category.setTaxPercent(taxPercent);
        return category;
    }

    private Product getProduct(int productId, Category category, int productCost, int quantityOfProduct, String productName) {
        Product product = new Product();
        product.setProductId(productId);
        product.setProductName(productName);
        product.setCategory(category);
        product.setProductCost(productCost);
        product.setQuantityOfProduct(quantityOfProduct);
        return product;
    }


}