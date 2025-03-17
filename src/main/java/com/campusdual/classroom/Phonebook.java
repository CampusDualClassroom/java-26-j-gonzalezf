package com.campusdual.classroom;

import java.util.HashMap;
import java.util.Map;

public class Phonebook {

    private Map<String, Contact> data = new HashMap<>();

    public Phonebook() {
    }

    public Phonebook(Map<String, Contact> data) {
        this.data = data;
    }

    public Map<String, Contact> getData() {
        return data;
    }

    public void setData(Map<String, Contact> data) {
        this.data = data;
    }

    public void addContact(Contact contact) {
        this.data.put(contact.getCode(), contact);
    }

    public void deleteContact(String code) {
        this.data.remove(code);
    }

    public void showPhonebook() {
        this.data.forEach((code, contact) -> contact.showContactDetails());
    }

}
