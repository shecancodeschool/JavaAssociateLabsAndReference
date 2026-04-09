package org.eddydashcode.java_design_patterns.behavioral.template_method.data_validation;

public abstract class DataValidator {

    // Template method
    public final boolean validate(String input) {
        String sanitizedInput = sanitize(input);
        if (!checkNotEmpty(sanitizedInput)) {
            System.out.println("Validation failed: input is empty or null.");
            return false;
        }

        if (!checkFormat(sanitizedInput)) {
            System.out.println("Validation failed: input format is invalid.");
            return false;
        }

        System.out.println("Validation passed.");
        return true;
    }

    // Shared logic
    private String sanitize(String input) {
        return input == null ? "" : input.trim();
    }

    private boolean checkNotEmpty(String input) {
        return !input.isEmpty();
    }

    // Abstract step for subclasses to implement
    protected abstract boolean checkFormat(String input);
}
