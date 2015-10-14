package com.yggdrasilgaming.interview.shop.data;

import com.google.common.collect.ConcurrentHashMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multiset.Entry;
import com.yggdrasilgaming.interview.shop.model.Order;
import com.yggdrasilgaming.interview.shop.model.OrderItem;
import com.yggdrasilgaming.interview.shop.model.Product;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Set;

/**
 * @author Maxim
 * @date $ {DATE}.
 */
@SessionScoped
public class BasketProducer implements Serializable {
    private Multiset<Product> products = ConcurrentHashMultiset.create();

    public void addProduct(Product product) {
        products.add(product, 1);
    }

    @Produces
    @Named
    public Set<Entry<Product>> getBasket() {
        return products.entrySet();
    }

    public Order getOrder() {
        Order order = new Order();
        for (Entry<Product> productEntry : products.entrySet()) {
            order.getItems().add(new OrderItem(productEntry.getCount(), productEntry.getElement()));
        }
        return order;
    }

    public void clear() {
        products.clear();
    }
}
