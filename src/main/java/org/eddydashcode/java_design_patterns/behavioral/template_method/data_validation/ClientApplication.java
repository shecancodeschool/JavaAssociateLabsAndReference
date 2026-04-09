package org.eddydashcode.java_design_patterns.behavioral.template_method.data_validation;

public class ClientApplication {

    public static void main(String[] args) {
        DataValidator emailValidator = new EmailValidator();
        DataValidator phoneValidator = new PhoneNumberValidator();

        System.out.println("Email Test:");
        emailValidator.validate(" test@example.com ");

        System.out.println("\nPhone Number Test:");
        phoneValidator.validate(" +12345678901 ");
    }
}
