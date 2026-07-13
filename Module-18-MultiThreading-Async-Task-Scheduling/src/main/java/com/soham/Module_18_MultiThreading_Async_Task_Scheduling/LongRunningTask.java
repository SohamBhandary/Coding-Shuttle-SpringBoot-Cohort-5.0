package com.soham.Module_18_MultiThreading_Async_Task_Scheduling;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LongRunningTask implements Runnable {


    @Override
    public void run() {


                log.info("Executing task....{}",Thread.currentThread().getName());
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
//                log.info("Ending Task {}",Thread.currentThread().getName());

            }



    }

