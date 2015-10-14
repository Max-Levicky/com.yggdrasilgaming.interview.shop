package com.yggdrasilgaming.interview.shop.data;

import com.yggdrasilgaming.interview.shop.model.Product;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * @author Maxim
 * @date $ {DATE}.
 */
@RequestScoped
public class ProductProducer {
    @Inject
    private ProductRepository productRepository;
    private List<Product> products;

    @PostConstruct
    public void fillProductList() {
        products = productRepository.findAllProducts();
    }

    @Produces
    @Named
    public List<Product> getProducts() {
        return products;
    }
}
