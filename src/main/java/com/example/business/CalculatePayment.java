package com.example.business;

import java.util.List;

class CalculatePayment implements ICalculatePayment {
    public ProductSum sum(List<Product> products) {
        int sum =
                products.stream().
                        reduce(
                                0,
                                (agg, prod) -> agg + prod.getPrice(),
                                Integer::sum);
        return new ProductSum(sum);
    }
}
