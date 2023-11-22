package com.bridgeLabz;

import java.util.ArrayList;
import java.util.List;

public class AddressBookMain extends Methods{

    public static void main(String[] args) {
        ArrayList<Contact> contactList = new ArrayList<>();
        selectOption(contactList);
    }

    public static void selectOption(List<Contact> contact){

        System.out.println("Choose number of the given option if you want to :\n1. Add Contact \n2. Edit Contact \n3. Show Contacts \n4. Delete Contact \n5. Exit");
        int number = sc.nextInt();
        switch(number){
            case 1:  addContact();
                break;
            case 2:  editContact();
                break;
            case 3:  showContacts();
                break;
            case 4:  deleteContact();
                break;
            case 5:  exitFromAddressBook();
                break;
            default : System.out.println("Choose valid number.");
        }
    }

}
