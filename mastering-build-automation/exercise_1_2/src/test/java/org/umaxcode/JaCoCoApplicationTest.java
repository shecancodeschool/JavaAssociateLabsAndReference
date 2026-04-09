package org.eddydashcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JaCoCoApplicationTest {


    @Test
    public void testGreetWithName() {
        JaCoCoApplication app = new JaCoCoApplication();
        String result = app.greet("Alice");
        assertEquals("Hello, Alice!", result);
    }

    @Test
    public void testGreetWithEmptyString() {
        JaCoCoApplication app = new JaCoCoApplication();
        String result = app.greet("");
        assertEquals("Hello, Guest!", result);
    }

    @Test
    public void testGreetWithNull() {
        JaCoCoApplication app = new JaCoCoApplication();
        String result = app.greet(null);
        assertEquals("Hello, Guest!", result);
    }
}
