package com.zenjava.community.service.data;

public class UserRef extends AbstractIdentifiableBean<Long> {

    private String username;
    private String firstName;
    private String lastName;

    public UserRef(Long id, String username, String firstName, String lastName) {
        super(id);
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
