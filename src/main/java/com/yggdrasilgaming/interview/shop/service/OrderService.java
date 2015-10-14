package com.yggdrasilgaming.interview.shop.service;

import com.yggdrasilgaming.interview.shop.model.Order;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * @author Maxim
 * @date $ {DATE}.
 */
@Stateless
public class OrderService {
    @Inject
    private EntityManager em;
    @Inject
    private Event<Order> orderEvent;

    public void saveOrder(Order order) {
        em.persist(order);
        orderEvent.fire(order);
    }
}
