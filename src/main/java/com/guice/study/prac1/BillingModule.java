package com.guice.study.prac1;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Names;

public class BillingModule extends AbstractModule {

    @Override
    protected void configure() {
        // linked binding
        bind(TransactionLog.class).to(DatabaseTransactionLog.class);
        bind(CreditCardProcessor.class).to(PaypalCreditCardProcessor.class);

        // @Named binding
        bind(CreditCardProcessor.class).annotatedWith(Names.named("Alipay")).to(AlipayCreditCardProcessor.class);

        // annotation binding
        bind(CreditCardProcessor.class).annotatedWith(WechatPay.class).to(WechatPayCreditCardProcessor.class);
    }

    @Provides
    public MailProcessor provideAsyncMailProcessor() {
        return new AsyncMailProcessor();
    }
}