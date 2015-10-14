package com.yggdrasilgaming.interview.shop.data;

import com.yggdrasilgaming.interview.shop.model.Order;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * @author Maxim
 * @date $ {DATE}.
 */
@RequestScoped
public class OrderProducer {
    @Inject
    private OrderRepository orderRepository;
    private List<Order> orders;

    @PostConstruct
    public void fillOrdersList() {
        orders = orderRepository.findAllOrders();
    }

    @Named
    @Produces
    public List<Order> getOrders() {
        return orders;
    }

    public void onOrdersChange(@Observes(notifyObserver = Reception.IF_EXISTS) final Order order) {
        fillOrdersList();
    }
}
