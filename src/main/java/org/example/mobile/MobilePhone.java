package org.example.mobile;

import java.util.ArrayList;
import java.util.List;

public class MobilePhone {
    private String myNumber;
    private List<Contact> myContacts;

    //
    public MobilePhone(String myNumber, List<Contact> initialContacts) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>(initialContacts);
    }


    public String getMyNumber() {
        return myNumber;
    }


    public List<Contact> getMyContacts() {
        return myContacts;
    }


    public boolean addNewContact(Contact contact) {
        if (findContact(contact.getName()) >= 0) {
            System.out.println("Contact already exists.");
            return false;
        }
        myContacts.add(contact);
        return true;
    }


    public boolean updateContact(Contact oldContact, Contact newContact) {
        int foundPosition = findContact(oldContact);
        if (foundPosition < 0) {
            System.out.println("Contact not found.");
            return false;
        }
        if (findContact(newContact.getName()) >= 0 && !oldContact.getName().equalsIgnoreCase(newContact.getName())) {
            System.out.println("Contact with name " + newContact.getName() + " already exists.");
            return false;
        }
        myContacts.set(foundPosition, newContact);
        System.out.println(oldContact.getName() + " was replaced with " + newContact.getName());
        return true;
    }


    public boolean removeContact(Contact contact) {
        int foundPosition = findContact(contact);
        if (foundPosition < 0) {
            System.out.println("Contact not found.");
            return false;
        }
        myContacts.remove(foundPosition);
        System.out.println(contact.getName() + " was removed.");
        return true;
    }


    public int findContact(Contact contact) {
        return myContacts.indexOf(contact);
    }


    public int findContact(String name) {
        for (int i = 0; i < myContacts.size(); i++) {
            Contact contact = myContacts.get(i);
            if (contact.getName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }


    public Contact queryContact(String name) {
        int position = findContact(name);
        if (position >= 0) {
            return myContacts.get(position);
        }
        return null;
    }


    public void printContacts() {
        System.out.println("Contact List:");
        for (Contact contact : myContacts) {
            System.out.println(contact.getName() + " -> " + contact.getPhoneNumber());
        }
    }
}
