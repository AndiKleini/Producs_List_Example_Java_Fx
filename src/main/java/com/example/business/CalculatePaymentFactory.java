package com.example.business;

public class CalculatePaymentFactory {
    public static ICalculatePayment getPayment() {
        return new CalculatePayment();
    }
}
