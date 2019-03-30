package com.java8.test;


import java.util.function.Consumer;
public class TestConsumer {
    public static void main(String[] args) {
    	//String arg = "my string";
        Consumer < String > consumer1 = (arg) -> {
            System.out.println(arg + "OK");
        };
        
        consumer1.accept("TestConsumerAccept - ");
        
        Consumer < String > consumer2 = (x) -> {
            System.out.println(x + "OK!!!");
        };
        
        
        consumer1.andThen(consumer2).accept("TestConsumerAfterThen - ");
    }
}