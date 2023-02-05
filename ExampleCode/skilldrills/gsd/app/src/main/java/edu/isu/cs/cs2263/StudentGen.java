package edu.isu.cs.cs2263;

import com.google.common.collect.Lists;

public class StudentGen {

    public static void main(String[] args) {
        Student s = new Student();
        s.setLastName("Griffith");
        s.setFirstName("Isaac");

        Course c = new Course();
        c.setNumber(1181);
        c.setSubject("CS");
        c.setTitle("Intro to Programming");

        s.addCourse(c);

        new IOManager().writeData(Lists.newArrayList(s));
    }
}
