package org.eddydashcode.java_design_patterns.creational.singleton;

import org.eddydashcode.java_design_patterns.creational.singleton.logger.Logger;

public class Main {

    public static void main(String[] args) {

        for(int i = 0; i< 4; i++){
            Logger logger = Logger.getLogger("MD");
            System.out.println(logger);

        }
    }
}
