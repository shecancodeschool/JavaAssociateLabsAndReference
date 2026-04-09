package org.eddydashcode.java_design_patterns.creational.singleton.config;

public class Application {

    public static void main(String[] args) {

        ConfigurationManager configurationManager = ConfigurationManager.getConfiguration("secret.env");

        String firstname = configurationManager.get("firstname");
        String lastname = configurationManager.get("lastname");
        String email = configurationManager.get("email");
        String sex = configurationManager.get("sex");

        System.out.println("Firstname: " + firstname);
        System.out.println("Lastname: " + lastname);
        System.out.println("Email: " + email);
        System.out.println("Sex: " + sex);
    }
}
