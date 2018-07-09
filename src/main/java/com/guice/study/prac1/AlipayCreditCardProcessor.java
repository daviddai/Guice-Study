package com.guice.study.prac1;

public class AlipayCreditCardProcessor implements CreditCardProcessor {

    public void process() {
        System.out.println("It is paid by Ali Pay Credit Card Processor");
    }
}
