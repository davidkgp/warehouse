package org.example.domain.catalog.core.model;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Catalog {

    private static Catalog INSTANCE;

    private final Set<ProductStock> productStocks;

    public static Catalog initializeEmptyCatalog() {
        if (INSTANCE == null) {
            INSTANCE = new Catalog(new HashSet<ProductStock>());
        }
        return INSTANCE;
    }

    private Catalog(Set<ProductStock> productStock) {
        this.productStocks = productStock;
    }

    public Catalog addStock(final ProductStock productStock) {
        this.productStocks.add(productStock);
        return this;
    }


    public Catalog addStocks(final ProductStock... productStock) {
        this.productStocks.addAll(Arrays.asList(productStock));
        return this;
    }

    public Catalog sellProduct(final String name, final int amount) {
        return this;
    }

    public Catalog sellProducts() {
        return this;
    }
}
