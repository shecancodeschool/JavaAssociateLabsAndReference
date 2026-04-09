package org.eddydashcode.reflection.exec_time_logger;

import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws Exception {

        var myService = new MyService();

        Class<?> clazz = MyService.class;

        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {

                long start = System.currentTimeMillis();

                method.setAccessible(true);
                method.invoke(myService);

                long end = System.currentTimeMillis();
                System.out.println(method.getName() + " took " + (end - start) + " ms");
            }
        }
    }
}
