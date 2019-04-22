package com.example.functionInterface;

public class AppTest {

    public static void main(String[] args){
        LogInterfaceTest logInterfaceTest = new LogInterfaceTest();
        logInterfaceTest.logBiz(new LogInterface() {
            @Override
            public void log() {
                System.out.println("do biz log in anonymous type");
            }
        });

        logInterfaceTest.logBiz(() -> System.out.println("do biz log in Lambda type"));
    }
}
