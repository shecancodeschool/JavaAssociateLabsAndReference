package org.eddydashcode;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class SpotBugsApplication {

    public static final String NAME = "Name";

    public SpotBugsApplication() {

    }

    public static String readName() {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8.displayName());
        String input = scanner.next();
        return NAME.concat(input);
    }
}
