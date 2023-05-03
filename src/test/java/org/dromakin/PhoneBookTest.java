package org.dromakin;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PhoneBookTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    void add() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("John", "+09539655123");
        int count = phoneBook.add("John", "+09523655954");
        assertEquals(count, 2);
    }

    @Test
    void addTestInput1() {
        PhoneBook phoneBook = new PhoneBook();

        Throwable exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    phoneBook.add("John", "John");
                }
        );
    }

    @Test
    void addTestInput2() {
        PhoneBook phoneBook = new PhoneBook();

        Throwable exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    phoneBook.add("+09539655123", "John");
                }
        );
    }

    @Test
    void findByNumber() {
        PhoneBook phoneBook = new PhoneBook();
        int count = phoneBook.add("John", "+09539655123");
        Contact contact = phoneBook.findByNumber("+09539655123");
        assertNotNull(contact);
    }

    @Test
    void findByNumberNull() {
        PhoneBook phoneBook = new PhoneBook();
        Object object = phoneBook.findByNumber("+09539655123");
        assertNull(object);
    }

    @Test
    void findByName() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("John", "+09539655123");
        phoneBook.add("John", "+09523655954");
        List<Contact> contacts = phoneBook.findByName("John");
        assertNotNull(contacts);
        assertEquals(contacts.size(), 2);
    }

    @Test
    void findByNameNull() {
        PhoneBook phoneBook = new PhoneBook();
        List<Contact> contacts = phoneBook.findByName("John");
        assertNull(contacts);
    }

    @Test
    void printAllNames() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("John", "+09539655123");
        phoneBook.printAllNames();
        assertEquals("John\n", outContent.toString());
    }

    @Test
    void printAllNamesMultiLine() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("John", "+09539655123");
        phoneBook.add("John", "+09523655954");
        phoneBook.printAllNames();
        assertEquals("John\n", outContent.toString());
    }
}