package org.eddydashcode.java_design_patterns.creational.builder.user;

public class User {

    private final String email;
    private final String phoneNumber;

    private User(UserBuilder builder) {
        this.email = builder.email;
        this.phoneNumber = builder.phoneNumber;
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public static class UserBuilder {

        private String email;
        private String phoneNumber;

        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public User build() {
            return new User(this);
        }

    }

}
