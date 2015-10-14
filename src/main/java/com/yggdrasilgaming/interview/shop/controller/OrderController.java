package com.yggdrasilgaming.interview.shop.controller;

import com.yggdrasilgaming.interview.shop.data.BasketProducer;
import com.yggdrasilgaming.interview.shop.model.Order;
import com.yggdrasilgaming.interview.shop.model.Product;
import com.yggdrasilgaming.interview.shop.service.OrderService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author Maxim
 * @date $ {DATE}.
 */
@Named
@RequestScoped
public class OrderController {
    @Inject
    private BasketProducer basket;
    @Inject
    private OrderService orderService;
    public void addProductToBasket(Product product) {
        basket.addProduct(product);
    }

    public void purchaseOrder() {
        Order order = basket.getOrder();
        orderService.saveOrder(order);
        basket.clear();
    }

    public void clearBasket() {
        basket.clear();
    }
}
