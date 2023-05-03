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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {

    private int countContacts;

    private final Map<String, Contact> contactsByNumber;

    public PhoneBook() {
        countContacts = 0;
        contactsByNumber = new HashMap<>();
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

        return ++countContacts;
    }


    public Contact findByNumber(String number) {
        if (number.matches("\\+?[0-9]+")) {
            return contactsByNumber.get(number);
        } else {
            throw new IllegalArgumentException("Number is not name!");
        }
    }

    public List<Contact> findByName(String name) {
        return null;
    }

}
