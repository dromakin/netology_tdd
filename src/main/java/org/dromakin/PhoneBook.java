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

public class PhoneBook {

    private int countContacts;

    public PhoneBook() {
        countContacts = 0;
    }

    public int add(String name, String number) {
        if (name.matches("[0-9]+")) {
            throw new IllegalArgumentException("Name is not number!");
        }

        if (number.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("Number is not name!");
        }

        // save in db
        // code here

        return ++countContacts;
    }
}
