/*
 * File:     PhoneBook
 * Package:  org.dromakin
 * Project:  netology_tdd
 *
 * Created by dromakin as 03.05.2023
 *
 * author - dromakin
 * maintainer - dromakin
 * version - 2023.05.03
 * copyright - ORGANIZATION_NAME Inc. 2023
 */
package org.dromakin;

import java.util.*;

public class PhoneBook {

    private int countContacts;

    private final Map<String, Contact> contactsByNumber; // one to one
    private final Map<String, Set<Contact>> contactsByName; // one to many

    public PhoneBook() {
        countContacts = 0;
        contactsByNumber = new HashMap<>();
        contactsByName = new HashMap<>();
    }

    public int add(String name, String number) {
        if (name.matches(".?[0-9]+")) {
            throw new IllegalArgumentException("Name is not number!");
        }

        if (number.matches(".?[a-zA-Z]+")) {
            throw new IllegalArgumentException("Number is not name!");
        }

        // save in db
        contactsByNumber.put(number, new Contact(name, number));

        if (contactsByName.containsKey(name)) {
            contactsByName.get(name).add(new Contact(name, number));
        } else {
            Set<Contact> setContacts = new HashSet<>();
            setContacts.add(new Contact(name, number));
            contactsByName.put(name, setContacts);
        }

        return ++countContacts;
    }


    public Contact findByNumber(String number) {
        if (number.matches("\\+?[0-9]+")) {
            return contactsByNumber.get(number);
        } else {
            throw new IllegalArgumentException("Number is not name!");
        }
    }

    public Set<Contact> findByName(String name) {
        if (name.matches("[a-zA-Z]+")) {
            return contactsByName.get(name);
        } else {
            throw new IllegalArgumentException("Number is not name!");
        }
    }

}
