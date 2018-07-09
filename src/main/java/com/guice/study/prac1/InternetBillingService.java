package com.guice.study.prac1;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class InternetBillingService {

    private final CreditCardProcessor creditCardProcessor;
    private final MailProcessor mailProcessor;
    private final TransactionLog transactionLog;

    @Inject

    public InternetBillingService(@WechatPay CreditCardProcessor creditCardProcessor,
                                  MailProcessor mailProcessor,
                                  TransactionLog transactionLog) {
        this.creditCardProcessor = creditCardProcessor;
        this.mailProcessor = mailProcessor;
        this.transactionLog = transactionLog;
    }

    public void doBill() {
        this.creditCardProcessor.process();
        this.mailProcessor.send();
        this.transactionLog.log();
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new BillingModule());
        InternetBillingService internetBillingService = injector.getInstance(InternetBillingService.class);
        internetBillingService.doBill();
    }
}
