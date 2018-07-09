package com.guice.study.prac1;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class ElectricityBillingService {

    private final CreditCardProcessor creditCardProcessor;
    private final TransactionLog transactionLog;

    @Inject
    ElectricityBillingService(CreditCardProcessor creditCardProcessor, TransactionLog transactionLog) {
        this.creditCardProcessor = creditCardProcessor;
        this.transactionLog = transactionLog;
    }

    public void doBill() {
        this.creditCardProcessor.process();
        this.transactionLog.log();
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new BillingModule());
        ElectricityBillingService electricBillingService = injector.getInstance(ElectricityBillingService.class);
        electricBillingService.doBill();
    }

}
