package com.guice.study.prac1;

public class PaypalCreditCardProcessor implements CreditCardProcessor {

    public void process() {
        System.out.println("It is paid by Paypal Credit Card Processor");
    }
}
