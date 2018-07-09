package com.guice.study.prac1;

public class AsyncMailProcessor implements MailProcessor {

    public void send() {
        System.out.println("Send mail in async");
    }
}
