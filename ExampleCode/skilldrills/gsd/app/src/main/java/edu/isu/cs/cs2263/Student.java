package edu.isu.cs.cs2263;

import com.google.common.collect.Lists;

import java.util.List;

public class Student {

    private String firstName;
    private String lastName;
    private List<Course> courses;

    public Student() {
        courses = Lists.newArrayList();
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

    public void addCourse(Course c) {
        if (c != null) {
            courses.add(c);
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s", firstName, lastName);
    }
}
