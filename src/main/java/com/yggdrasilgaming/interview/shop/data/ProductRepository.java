package com.yggdrasilgaming.interview.shop.data;

import com.yggdrasilgaming.interview.shop.model.Product;

import javax.enterprise.context.ApplicationScoped;
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
public class ProductRepository {
    @Inject
    private EntityManager em;

    public List<Product> findAllProducts() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Product> criteria = cb.createQuery(Product.class);
        Root<Product> member = criteria.from(Product.class);
        criteria.select(member).orderBy(cb.asc(member.get("name")));
        return em.createQuery(criteria).getResultList();
    }
}
