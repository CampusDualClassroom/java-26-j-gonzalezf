package com.campusdual.classroom;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

public class Contact implements ICallActions {

    private String name;
    private String surnames;
    private String phone;
    private List<String> phones = new ArrayList<>();
    private String code;

    public Contact() {
    }

    public Contact(String name, String surnames, String phone) {
        this.name = name;
        this.surnames = surnames;
        this.phone = phone;
        this.phones.add(phone);
        this.code = generateCode(name, surnames);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurnames() {
        return surnames;
    }

    public void setSurnames(String surname) {
        this.surnames = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<String> getPhones() {
        return phones;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public void callMyNumber() {
        System.out.println("Se está llamando a sí mismo.");
        System.out.println("Nombre: " + this.name);
        System.out.println("Apellidos: " + this.surnames);
        System.out.println("Número de teléfono: " + this.phone);
    }

    @Override
    public void callOtherNumber(String number) {
        System.out.println("Marcando número: " + number);
        System.out.println("Llamando a " + this.name + " " + this.surnames);
    }

    @Override
    public void showContactDetails() {
        System.out.println("Detalles del contacto " + this.code);
        System.out.println("Nombre: " + this.name);
        System.out.println("Apellidos: " + this.surnames);
        System.out.println("Número de teléfono: " + this.phone);
    }

    public void addPhone(String phone) {
        if (!phones.contains(phone)) {
            phones.add(phone);
        } else {
            System.out.println("Este teléfono ya está en la lista.");
        }
    }

    public void setMainPhone(String phone) {
        if (phones.contains(phone)) {
            this.phone = phone;
        } else {
            System.out.println("El teléfono no está en la lista.");
        }
    }

    private static String generateCode(String name, String surnames) {

        String[] surnamesArray = surnames.split(" ");
        StringBuilder codeBuilder = new StringBuilder();

        codeBuilder.append(firstLower(name));

        if (surnamesArray.length > 1) {
            codeBuilder.append(firstLower(surnamesArray[0]));
            for (int i = 1; i < surnamesArray.length; i++) {
                codeBuilder.append(surnamesArray[i]);
            }
        } else {
            codeBuilder.append(surnames);
        }

        return removeDiacritics(codeBuilder.toString().toLowerCase());
    }

    private static String firstLower(String str) {
        return String.valueOf(str.toLowerCase().charAt(0));
    }

    private static String removeDiacritics(String str) {
        return Normalizer.normalize(str, Normalizer.Form.NFD)
                .replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
    }

}
