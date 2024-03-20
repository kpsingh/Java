package com.java.multithreading.V3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrintNumberClient {
    public static void main(String[] args) {

        System.out.println("Available Processor : " + Runtime.getRuntime().availableProcessors());
        ExecutorService service = Executors.newFixedThreadPool(10);
        for(int i = 1; i <= 100; i++){
            if (i == 60){
                System.out.println("Stop");
            }
            PrintNumber pn = new PrintNumber(i);
            service.execute(pn);

        }
        System.out.println("After submitting all the Job");
        service.shutdown();
    }
}
