package com.bridgeLabz;

import java.util.ArrayList;
import java.util.Scanner;

public class Contact {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private int zip;
    private long phoneNumber;
    private String email;

    public void setFirstName(String firstName) { this.firstName = firstName;}

    public String getFirstName() { return firstName;}

    public String getLastName() { return lastName; }

    public String getAddress() { return address;}

    public String getCity() { return city; }

    public String getState() { return state; }

    public int getZip() { return zip; }

    public long getPhoneNumber() { return phoneNumber;}

    public String getEmail() { return email; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public void setAddress(String address) { this.address = address;}

    public void setCity(String city) { this.city = city; }

    public void setState(String state) { this.state = state;}

    public void setZip(int zip) { this.zip = zip;}

    public void setPhoneNumber(long phoneNumber) { this.phoneNumber = phoneNumber;}

    public void setEmail(String email) { this.email = email;}

    @Override
    public String toString() {
        return "Contact{" +
                "firstName='" + getFirstName() + '\'' +
                ", lastName='" +getLastName() + '\'' +
                ", address='" + getAddress() + '\'' +
                ", city='" + getCity() + '\'' +
                ", state='" + getState() + '\'' +
                ", zip=" + getZip() +
                ", phoneNumber=" + getPhoneNumber() +
                ", email='" + getEmail()
                + '\'' +
                '}';
    }

    Scanner sc = new Scanner(System.in);

    public  Contact addContactDetails(ArrayList<Contact> contact){
        // create object of create contact to set details
        Contact contacts = new Contact();

        // take contact detail from console and set
        System.out.print("Enter first name : ");
        String firstName = sc.next();
        System.out.print("Enter last name : ");
        String lastName = sc.next();
        boolean check = findContact(contact,firstName,lastName);
        if(!check) {
            contacts.setLastName(lastName);
            contacts.setFirstName(firstName);
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
        }
        else System.out.println("Contact already exist.");
        return contacts;
    }

    public  void editContact(ArrayList<Contact> contacts) {
        System.out.println("Enter the first name : ");
        String firstName = sc.next();
        System.out.println("Enter the second name : ");
        String lastName = sc.next();
        boolean isValid = findContact(contacts,firstName,lastName);
        if(isValid) {
            for (int i = 0; i < contacts.size(); i++) {
                if (contacts.get(i).getFirstName().equalsIgnoreCase(firstName) && contacts.get(i).getLastName().equalsIgnoreCase(lastName)) {
                    System.out.println("what do you want to edit('address','city','state','zipcode','phoneNum','email') choose anyone:");
                    String changes = sc.next();
                    changeContactDetail(contacts,changes, i);
                    System.out.println("Your contact is changes successfully.");
                    showContacts(contacts);
                }
            }
        }
        else System.out.println("Contact not found.");
    }

    public  boolean findContact(ArrayList<Contact> contacts,String firstName, String lastName) {
        if(contacts.stream().anyMatch(name->name.getFirstName().equals(firstName) && name.getLastName().equals(lastName)))
            return true;
        return false;
    }

    public  void changeContactDetail(ArrayList<Contact> contacts,String option, Integer index){
        switch (option){
            case "address" :
                System.out.println("Enter new address :");
                contacts.get(index).setAddress(sc.next());
                break;

            case "city" :
                System.out.println("Enter city name :");
                contacts.get(index).setCity(sc.next());
                break;

            case "state" :
                System.out.println("Enter state name :");
                contacts.get(index).setState(sc.next());
                break;

            case "zipcode" :
                System.out.println("Enter new zipcode :");
                contacts.get(index).setZip(sc.nextInt());
                break;

            case "phoneNum" :
                System.out.println("Enter new phone number :");
                contacts.get(index).setPhoneNumber(sc.nextLong());
                break;

            case "email" :
                System.out.println("Enter new email id :");
                contacts.get(index).setEmail(sc.next());
                break;
            default:
                System.out.println("Enter valid word");
        }

    }

    public  void showContacts(ArrayList<Contact> contact) {
        for(Contact contacts : contact){
            System.out.println("First Name: '" + contacts.getFirstName() +"'  "+ "Last Name: '" + contacts.getLastName() +"'\n"+ "Address : '"+contacts.getAddress()+ "'  City : " + contacts.getCity() +"  "+ "State : " + contacts.getState()+" "
                    + "zip : '" + contacts.getZip() +"'\n"+"Phone Number : '" + contacts.getPhoneNumber() +"'\n"+ "Email Id: '" + contacts.getEmail()+"'\n");
        }
    }

    public  void deleteContact(ArrayList<Contact> contacts) {
        System.out.println("Enter the first name : ");
        String fName = sc.next();
        System.out.println("Enter the last name : ");
        String lName = sc.next();
        boolean isValid = findContact(contacts,fName,lName);
        if (isValid)
            for (int i = 0; i < contacts.size(); i++) {
                if (contacts.get(i).getFirstName().equals(fName) && contacts.get(i).getLastName().equals(lName)) {
                    contacts.remove(i);
                    System.out.println("Contact successfully deleted");
                }
            }
        else
            System.out.println("contact not exist");
    }

    public  void exitFromAddressBook() {
        System.out.println("Thank you for coming in Address Book");
    }

}
