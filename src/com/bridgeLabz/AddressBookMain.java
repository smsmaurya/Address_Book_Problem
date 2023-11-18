package com.bridgeLabz;

import java.util.Scanner;

public class AddressBookMain extends AddressBookMethods{

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("********************Welcome in Address Book problem..************************\n");

        System.out.println("Enter how many contacts you want to add :");
        int totalContact = sc.nextInt();

        // make a 1Contact type array
        Contact[] contacts = new Contact[totalContact];

        // add contacts in an array
        for(int i=0;i<totalContact;i++){
            contacts[i] = addContactDetails();
            System.out.println(" contact added successfully\n");
        }


        // display contacts
        for (Contact contact : contacts){
            System.out.println(contact+"\n");
        }

        System.out.println("did you want to edit any contact 'yes' or 'no'?");
        String ans = sc.next();
        editContact(ans,contacts);

    }
}
