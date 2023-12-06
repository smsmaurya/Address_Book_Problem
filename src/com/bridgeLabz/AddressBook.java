package com.bridgeLabz;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook{

    private  String addressBookName ;

    public AddressBook() {
    }

    public String getAddressBookName() {return addressBookName; }

    public void setAddressBookName(String addressBookName) {
        this.addressBookName = addressBookName;
    }

    @Override
    public String toString() {
        return "{" +
                "addressBookName='" + getAddressBookName() + '\'' +
                ", contactsList=" + contactList +
                '}';
    }

    ArrayList<Contact> contactList = new ArrayList<>();

    public  void selectOption(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose number of the given option if you want to :\n1. Add Contact \n2. Edit Contact \n3. Show Contacts \n4. Delete Contact \n5. Exit");
        int number = sc.nextInt();
        Contact contact = new Contact();
        switch(number){
            case 1:
                contactList.add(contact.addContactDetails(contactList));selectOption();
                break;
            case 2:  contact.editContact(contactList);selectOption();
                break;
            case 3:  contact.showContacts(contactList);selectOption();
                break;
            case 4:  contact.deleteContact(contactList);selectOption();
                break;
            case 5:  contact.exitFromAddressBook();
                break;
            default : System.out.println("Choose valid number.");
                selectOption();
        }
    }
}