package com.demo.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {


    @Test
    void groupedAssertions() {
        Student student = new Student("Tom", "Harry");
        Student student1 = new Student("Lionel","Messi");

        //assertEquals(expected, actual);

        assertEquals("Tom",student.getFirstName());
        assertEquals("Harry",student.getLastName());
        assertEquals("Lionel",student1.getFirstName());
        assertEquals("Messi",student1.getLastName());

        assertAll("student",
                ()->assertEquals("Tom",student.getFirstName()),
                ()->assertEquals("Harry",student.getLastName()));

    }

    @Test
    void dependentAssertions() {
        Student student = new Student("Tom", "Harry");

        String firstName = student.getFirstName();
        assertNotNull(firstName);

        assertAll("properties",
                ()->{
                    String FN = student.getFirstName();
                    assertNotNull(FN);

                    assertAll("FirstName",
                            ()-> assertTrue(firstName.startsWith("T")),
                            ()-> assertTrue(firstName.startsWith("H")));
                },
                ()-> {
                    String lastName = student.getLastName();
                    assertNotNull(lastName);

                    assertAll("lastName",
                            ()-> assertTrue(firstName.startsWith("T")),
                            ()-> assertTrue(firstName.startsWith("H")));
                }
        );
    }

}