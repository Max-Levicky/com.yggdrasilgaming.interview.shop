package com.yggdrasilgaming.interview.shop.data;

import com.yggdrasilgaming.interview.shop.model.Order;
import com.yggdrasilgaming.interview.shop.model.Product;

import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @author Maxim
 * @date $ {DATE}.
 */
@ApplicationScoped
public class OrderRepository {
    @Inject
    private EntityManager em;

    public List<Order> findAllOrders() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Order> criteria = cb.createQuery(Order.class);
        Root<Order> member = criteria.from(Order.class);
        criteria.select(member);
        return em.createQuery(criteria).getResultList();
    }
}
