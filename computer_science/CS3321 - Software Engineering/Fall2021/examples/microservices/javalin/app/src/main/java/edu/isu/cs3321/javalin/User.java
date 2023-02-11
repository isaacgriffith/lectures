package edu.isu.cs3321.javalin;

import com.google.common.base.Objects;

public class User {

    private String firstName;
    private String lastName;
    private String email;

    public User() {}

    public User(String fname, String lname, String email) {
        this.firstName = fname;
        this.lastName = lname;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equal(getFirstName(), user.getFirstName()) && Objects.equal(getLastName(), user.getLastName()) && Objects.equal(getEmail(), user.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getFirstName(), getLastName(), getEmail());
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("New User:\n");
        builder.append("\tName: " + firstName + " " + lastName + "\n");
        builder.append("\tEmail: " + email);
        return builder.toString();
    }
}
