package com.demo.model;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ContactManagerTest {

    private static ContactManager contactManager;

    @BeforeAll
    public static void setUpAll(){
        System.out.println("Running before all Test cases");
    }

    @BeforeEach
    public void setUp(){
        contactManager = new ContactManager();
    }

    @Test
    @DisplayName("Should Add Contact - Checking with length")
    void shouldAddContact(){
//        ContactManager contactManager = new ContactManager();
        contactManager.addContact("Shiv","Patel","0987789765");
        assertEquals(1,contactManager.getAllContacts().size());
    }

    @Test
    @DisplayName("Should Throw RunTimeException when firstName is not null")
    void shouldthrowRunTimeExceptionWhenfirstNameisNotNull() {
//        ContactManager contactManager = new ContactManager();
        assertThrows(RuntimeException.class,()-> {
            contactManager.addContact(null, "Henry", "0123456789");
        });
    }

    @Test
    @DisplayName("Should Throw RunTimeException when lastName is not null")
    void shouldthrowRunTimeExceptionWhenlastNameisNotNull() {
//        ContactManager contactManager = new ContactManager();
        assertThrows(RuntimeException.class,()-> {
            contactManager.addContact("John", null, "0123456789");
        });
    }

    @Test
    @DisplayName("Should Throw RunTimeException when Phone Number is not null")
    void shouldthrowRunTimeExceptionWhenphoneNumberisNotNull() {
//        ContactManager contactManager = new ContactManager();
        assertThrows(RuntimeException.class,()-> {
            contactManager.addContact("John", "Henry", null);
        });
    }

    @Test
    @DisplayName("Testing Conditional Executions")
    @EnabledOnOs(value = OS.WINDOWS )
    void testingConditionalExecutions() {
//        ContactManager contactManager = new ContactManager();
        contactManager.addContact("John", "Henry", "0123456789");
        assertEquals(1,contactManager.getAllContacts().size());

    }

    @Test
    @DisplayName("Testing Assumptions ")
    void  assumptionsTesting() {
        //ContactManager contactManager = new ContactManager();
        Assumptions.assumeTrue("DEV".equals(System.getProperty("ENV")));
        contactManager.addContact("John", "Henry", "0123456789");
        assertEquals(1,contactManager.getAllContacts().size());
    }

    @Test
    @DisplayName("Repeated Test Creations  ")
    @RepeatedTest(value = 5,
            name = "Repetation Test Creation  {currentRepetition} of {totalRepetitions}")
    void repeatedTestExecution() {
        contactManager.addContact("John", "Henry", "0123456789");
        assertEquals(1,contactManager.getAllContacts().size());

    }

    @Test
    @DisplayName(" Paramerterized vlaues using Value Source ")
    @ParameterizedTest
    @ValueSource(strings = {"0123456789","0234512345","0234562345"})
    void parameterizedValuesUsingValueSource(String phoneNumber) {
        //ContactManager contactManager = new ContactManager();
        contactManager.addContact("John", "Henry", phoneNumber);
        assertEquals(1,contactManager.getAllContacts().size());

    }

    @Test
    @DisplayName(" Paramerterized vlaues using Method Source  ")
    @ParameterizedTest
    @MethodSource("phoneNumberList")
    void parameterizedValuesUsingMethodSource(String phoneNumber) {
        //ContactManager contactManager = new ContactManager();
        contactManager.addContact("John", "Henry", phoneNumber);
        assertEquals(1,contactManager.getAllContacts().size());
    }

    private static List<String> phoneNumberList(){
        return Arrays.asList("0123456789","0234512345","0234562345");
    }


    @AfterEach
    public void tearDown() {
        System.out.println("Print after Each test");
    }

    @AfterAll
    public static void tearDownAll() {
        System.out.println("Print after All test");
    }

}