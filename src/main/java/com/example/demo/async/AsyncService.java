package com.example.demo.async;


import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Service
public class AsyncService {

    @Async
    public Future<Integer> doBiz(){
        System.out.println("Execute method asynchronously - " + Thread.currentThread().getName());

        int i;
        for ( i = 0 ; i < 3; i++
             ) {
            try {

                Thread.sleep(50);

            } catch (InterruptedException e) {
                    e.printStackTrace();
            }
        }
        System.out.println("Execute method asynchronously - " + Thread.currentThread().getName() + "end");
        return new AsyncResult<Integer>(i);
    }
}
