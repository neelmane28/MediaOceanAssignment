package com.assignment.controller;

import com.assignment.model.ItemisedBill;
import com.assignment.model.ShoppingCart;
import com.assignment.service.CheckoutCounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class CheckoutCounterController {
    @Autowired
    private CheckoutCounterService checkoutCounterService;


    @RequestMapping(value = "/bill", method = POST)
    public ItemisedBill generateBill(@RequestBody ShoppingCart cart) {
        ItemisedBill bill = checkoutCounterService.calculateBill(cart);
        return bill;
    }
}
