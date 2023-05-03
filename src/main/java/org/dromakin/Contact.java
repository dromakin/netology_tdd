/*
 * File:     Contact
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

import java.util.Objects;

public class Contact {

    private String name;
    private String number;

    public Contact(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(name, contact.name) && Objects.equals(number, contact.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, number);
    }
}
