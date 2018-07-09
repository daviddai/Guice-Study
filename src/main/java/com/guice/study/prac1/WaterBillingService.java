package com.guice.study.prac1;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.name.Named;

public class WaterBillingService {

    private final CreditCardProcessor creditCardProcessor;
    private final TransactionLog transactionLog;

    @Inject
    public WaterBillingService(@Named("Alipay") CreditCardProcessor creditCardProcessor, TransactionLog transactionLog) {
        this.creditCardProcessor = creditCardProcessor;
        this.transactionLog = transactionLog;
    }

    public void doBill() {
        this.creditCardProcessor.process();
        this.transactionLog.log();
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new BillingModule());
        WaterBillingService waterBillingService = injector.getInstance(WaterBillingService.class);
        waterBillingService.doBill();
    }
}
