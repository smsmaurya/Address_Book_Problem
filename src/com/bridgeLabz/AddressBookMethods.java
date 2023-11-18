package com.bridgeLabz;


import java.util.Scanner;

public class AddressBookMethods {

    static Scanner sc = new Scanner(System.in);

    public static Contact addContactDetails(){
        // create object of create contact to set details
        Contact contact = new Contact();

        // take contact detail from console and set
        System.out.print("Enter first name : ");
        contact.setFirstName(sc.next());
        System.out.print("Enter last name : ");
        contact.setLastName(sc.next());
        System.out.print("Enter address : ");
        contact.setAddress(sc.next());
        System.out.print("Enter city : ");
        contact.setCity(sc.next());
        System.out.print("Enter state : ");
        contact.setState(sc.next());
        System.out.print("Enter the zip code : ");
        contact.setZip(sc.nextInt());
        System.out.print("Enter phone number : ");
        contact.setPhoneNumber(sc.nextLong());
        System.out.print("Enter email id : ");
        contact.setEmail(sc.next());

        // return contact
        return contact;
    }

    public static void editContact(String ans, Contact[] contacts){
        if(ans.equalsIgnoreCase("yes")){
            System.out.println("Enter then first name of person :");
            String fName = sc.next();
            System.out.println("Enter then last name of person :");
            String lName = sc.next();

            for(Contact contact : contacts){
                // take contact object as string and check contact is present or not
                String edContact = String.valueOf(contact);
                if(edContact.contains(fName) || edContact.contains(lName)){

                    System.out.println("contact is exist");
                    System.out.println("what do you want to edit('address','city','state','zipcode','phoneNum','email') choose anyone:");
                    String changes = sc.next();
                    changeContactDetail(changes, contact);

                    for (Contact modifyContact : contacts){
                        String editedContact = String.valueOf(contact);
                        if(editedContact.contains(fName) || editedContact.contains(lName)) {
                            System.out.println(modifyContact + "\n");
                        }
                    }
                }
                else{
                    System.out.println("Contact does not exist");
                }
            }

        }

    }

    public static void changeContactDetail(String option, Contact contact){
        switch (option){
            case "address" :
                System.out.println("Enter new address :");
                contact.setAddress(sc.next());
                break;

            case "city" :
                System.out.println("Enter city name :");
                contact.setCity(sc.next());
                break;

            case "state" :
                System.out.println("Enter state name :");
                contact.setState(sc.next());
                break;

            case "zipcode" :
                System.out.println("Enter new zipcode :");
                contact.setZip(sc.nextInt());
                break;

            case "phoneNum" :
                System.out.println("Enter new phone number :");
                contact.setPhoneNumber(sc.nextLong());
                break;

            case "email" :
                System.out.println("Enter new email id :");
                contact.setEmail(sc.next());
                break;
        }
    }

}
