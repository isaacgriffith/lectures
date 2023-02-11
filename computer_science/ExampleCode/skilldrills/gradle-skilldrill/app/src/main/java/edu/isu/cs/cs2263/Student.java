package edu.isu.cs.cs2263;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
public class Student {

    @Getter
    @Setter
    private String firstName;
    @Getter
    @Setter
    private String lastName;
    private List<Course> courses;

    public List<Course> getCourses() {
        return Lists.newArrayList(courses);
    }

    public static void main(String[] args) {
        Student s = new Student();
        s.setFirstName("Isaac");
        s.setLastName("Griffith");
        System.out.println(s);
    }
}
