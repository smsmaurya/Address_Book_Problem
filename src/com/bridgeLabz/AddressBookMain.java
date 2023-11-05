package com.bridgeLabz;

import java.util.Scanner;

public class AddressBookMain {

    static Scanner sc = new Scanner(System.in);

    public static CreateContact addContactDetails(){
        // create object of create contact to set details
        CreateContact person = new CreateContact();
        System.out.print("Enter first name : ");
        person.setFirstName(sc.next());
        System.out.print("Enter last name : ");
        person.setLastName(sc.next());
        System.out.print("Enter address : ");
        person.setAddress(sc.next());
        System.out.print("Enter city : ");
        person.setCity(sc.next());
        System.out.print("Enter state : ");
        person.setState(sc.next());
        System.out.print("Enter the zip code : ");
        person.setZip(sc.nextInt());
        System.out.print("Enter phone number : ");
        person.setPhoneNumber(sc.nextLong());
        System.out.print("Enter email id : ");
        person.setEmail(sc.next());

        return person;
    }

    public static void main(String[] args) {
        System.out.println("********************Welcome in Address Book problem..************************\n");

        System.out.println("Enter how many contacts you want to add :");
        int totalContact = sc.nextInt();

        // make a CreateContact type array
        CreateContact[] contacts = new CreateContact[totalContact];

        // add contacts in an array
        for(int i=0;i<totalContact;i++){
            contacts[i] = addContactDetails();
            System.out.println();
        }

        // display contacts
        for (CreateContact contact : contacts){
            System.out.println(contact+"\n");
        }

    }
}
