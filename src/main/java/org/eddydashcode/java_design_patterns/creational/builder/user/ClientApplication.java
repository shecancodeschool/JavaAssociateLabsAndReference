package org.eddydashcode.java_design_patterns.creational.builder.user;

public class ClientApplication {

    public static void main(String[] args) {

        // specifying all fields
        User completeUser = User.builder()
                .email("umaxcode@gmail.com")
                .phoneNumber("+23305-245-6122")
                .build();

        System.out.println(completeUser.getEmail());
        System.out.println(completeUser.getPhoneNumber());

        System.out.println(); // for spacing

        // providing optional fields
        User incompleteUser = User.builder()
                .email("umaxcode@Gmail.com")
                .build();

        System.out.println(incompleteUser.getEmail());
        System.out.println(incompleteUser.getPhoneNumber());

    }
}
