package org.dromakin;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PhoneBookTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
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
        Set<Contact> contacts = phoneBook.findByName("John");
        assertNotNull(contacts);
        assertEquals(contacts.size(), 2);
    }

    @Test
    void findByNameNull() {
        PhoneBook phoneBook = new PhoneBook();
        Set<Contact> contacts = phoneBook.findByName("John");
        assertNull(contacts);
    }
}