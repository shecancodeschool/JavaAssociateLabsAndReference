package org.eddydashcode.reflection.exec_time_logger;

public class MyService {

    @LogExecutionTime
    public void doSomething() {
        try {
            Thread.sleep(500);
        }catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void notLogged() {
        System.out.println("This won't be logged.");
    }
}
