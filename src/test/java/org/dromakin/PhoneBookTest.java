package org.dromakin;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        int count = phoneBook.add("John", "+09539655123");
        assertEquals(count, 1);
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
        Object object = phoneBook.findByNumber("+09539655123");
        assertNotNull(object);
    }

    @Test
    void findByNumberNull() {
        PhoneBook phoneBook = new PhoneBook();
        Object object = phoneBook.findByNumber("+09539655123");
        assertNull(object);
    }
}