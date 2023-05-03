package org.dromakin;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("John", "+09539655123");
        int count = phoneBook.add("John", "+09523655954");
        System.out.println(count);
        phoneBook.printAllNames();
    }
}