package com.guice.study.prac1;

public class WechatPayCreditCardProcessor implements CreditCardProcessor {

    public void process() {
        System.out.println("It is paid by Wechat Pay Credit Card Processor");
    }

}
