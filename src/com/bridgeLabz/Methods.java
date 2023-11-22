package com.bridgeLabz;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import static com.bridgeLabz.AddressBookMain.selectOption;

public class Methods {

    static Scanner sc = new Scanner(System.in);

    AddressBookMain addressBook = new AddressBookMain();

    static ArrayList<Contact> contact=  new ArrayList<>();

    public static Contact addContactDetails(){
        // create object of create contact to set details
        Contact contacts = new Contact();

        // take contact detail from console and set
        System.out.print("Enter first name : ");
        contacts.setFirstName(sc.next());
        System.out.print("Enter last name : ");
        contacts.setLastName(sc.next());
        System.out.print("Enter address : ");
        contacts.setAddress(sc.next());
        System.out.print("Enter city : ");
        contacts.setCity(sc.next());
        System.out.print("Enter state : ");
        contacts.setState(sc.next());
        System.out.print("Enter the zip code : ");
        contacts.setZip(sc.nextInt());
        System.out.print("Enter phone number : ");
        contacts.setPhoneNumber(sc.nextLong());
        System.out.print("Enter email id : ");
        contacts.setEmail(sc.next());

                return contacts;
    }

    public static void addContact(){
        contact.add(addContactDetails());
        selectOption(contact);
    }

    public static void editContact() {
        System.out.println("Enter the first name : ");
        String firstName = sc.next();
        System.out.println("Enter the second name : ");
        String lastName = sc.next();
        boolean isValid = findContact(firstName,lastName);
        if(isValid) {
            for (int i = 0; i < contact.size(); i++) {
                if (contact.get(i).getFirstName().equalsIgnoreCase(firstName) && contact.get(i).getLastName().equalsIgnoreCase(lastName)) {
                    System.out.println("what do you want to edit('address','city','state','zipcode','phoneNum','email') choose anyone:");
                    String changes = sc.next();
                    changeContactDetail(changes, i);
                    System.out.println("Your contact is changes successfully.");
                    System.out.println(contact.get(i).toString() + "\n");
                    selectOption(contact);
                }
            }
        }
        else
            System.out.println("Contact not found.");

    }

    private static boolean findContact(String firstName, String lastName) {
        for(int i=0;i<contact.size();i++) {
            if (contact.get(i).getFirstName().equalsIgnoreCase(firstName) && contact.get(i).getLastName().equalsIgnoreCase(lastName))
                return true;
        }
        return false;
    }

    public static void changeContactDetail(String option, Integer index){
        //Contacts contacts = new Contacts();
        switch (option){
            case "address" :
                System.out.println("Enter new address :");
                contact.get(index).setAddress(sc.next());
                break;

            case "city" :
                System.out.println("Enter city name :");
                contact.get(index).setCity(sc.next());
                break;

            case "state" :
                System.out.println("Enter state name :");
                contact.get(index).setState(sc.next());
                break;

            case "zipcode" :
                System.out.println("Enter new zipcode :");
                contact.get(index).setZip(sc.nextInt());
                break;

            case "phoneNum" :
                System.out.println("Enter new phone number :");
                contact.get(index).setPhoneNumber(sc.nextLong());
                break;

            case "email" :
                System.out.println("Enter new email id :");
                contact.get(index).setEmail(sc.next());
                break;
            default:
                System.out.println("Enter valid word");
        }

    }

    public static void showContacts() {
        Iterator<Contact> iterator =  contact.iterator();
        System.out.println("All contacts :");
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        selectOption(contact);
    }

    public static void deleteContact() {
        System.out.println("Enter the first name : ");
        String fName = sc.next();
        System.out.println("Enter the last name : ");
        String lName = sc.next();
        boolean isValid = findContact(fName,lName);

        if (isValid) {
            for (int i = 0; i < contact.size(); i++) {
                if (contact.get(i).getFirstName().equals(fName) && contact.get(i).getLastName().equals(lName)) {
                    contact.remove(i);
                    System.out.println("Contact successfully deleted");
                }
            }
        }
        else {
            System.out.println("contact not exist");
        }
        selectOption(contact);
    }

    public static void exitFromAddressBook() {
        System.out.println("Thank you for coming in Address Book");
    }


}
