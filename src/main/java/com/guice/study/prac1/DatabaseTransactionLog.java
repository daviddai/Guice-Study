package com.guice.study.prac1;

public class DatabaseTransactionLog implements TransactionLog {

    public void log() {
        System.out.println("Database is making a transaction log");
    }
}
