package com.bridgeLabz;

import java.util.*;
import java.util.stream.Collectors;

public class AddressBookMain{

    static Scanner sc = new Scanner(System.in);
    static Map<String,AddressBook> addressBookMap = new HashMap<>();

    public static void main(String[] args) {

        AddressBook adBook = new AddressBook();
        addressBookMap.equals(adBook);
        AddressBookMain addressBookMain = new AddressBookMain();
        addressBookMain.multipleAddressBooks();
    }

    public void multipleAddressBooks() {
        boolean check = true;
        while (check){
            System.out.println("Select \n1. for creating Address Book\n2. for show address book\n3. search Person State And City\n4.Search person in AddressBook System\n5.Exit");
            int select = sc.nextInt();
            switch (select){
                case 1: createAddressBook();
                    break;
                case 2:
                    Iterator itr = addressBookMap.keySet().iterator();
                    while(itr.hasNext()) {
                        displayAddressBook(itr.next());
                    }
                    break;
                case 3:
                    System.out.println("Enter city or state to search: ");
                    String cityOrState = sc.next();
                    List<Contact> searchResults = searchPersonInCityOrState(cityOrState);
                    searchResults.addAll(searchPersonInCityOrState(cityOrState));

                    if (searchResults.isEmpty()) {
                        System.out.println("No matching contacts found in the specified city or state.");
                    } else {
                        System.out.println("Your Search Results:");
                        for (Contact contact : searchResults) {
                            System.out.println(contact.toString());
                        }
                    }
                    break;
                case 4:
                    System.out.println("Enter city or state to search: ");
                    String city_Or_State = sc.next();
                    searchPersonByCityOrStateInWholeAddressBook(city_Or_State);
                    break;
                case 5:
                    System.out.println("Thank you to visit here.");
                    check = false;
                    break;
                default:  {System.out.println("Enter or select valid number");
                    multipleAddressBooks();}
            }
        }
    }

    public void displayAddressBook(Object key) { System.out.println(addressBookMap.get(key).getAddressBookName()); }

    public void createAddressBook(){
        System.out.println("Enter the address book name:");
        String addressBookName = sc.next();
        if(!addressBookMap.keySet().contains(addressBookName)){
            AddressBook addressBook = new AddressBook();
            addressBook.setAddressBookName(addressBookName);
            addressBook.selectOption();
            addressBookMap.put(addressBookName,addressBook);
        }else System.out.println("Address Book already exist.");
    }

    public List<Contact> searchPersonInCityOrState(String cityOrStateName) {
        System.out.println("enter the name of the addressbook from which you want to find person by city: ");
        String ab = sc.next();
        return addressBookMap.get(ab).contactList.stream()
                .filter(contact -> contact.getCity().equalsIgnoreCase(cityOrStateName)|| contact.getState().equalsIgnoreCase(cityOrStateName))
                .collect(Collectors.toList());
    }

    public void searchPersonByCityOrStateInWholeAddressBook(String cityOrStateName){

        Iterator itr = addressBookMap.keySet().iterator();
        while(itr.hasNext()) {
            ArrayList<Contact> persons = (ArrayList<Contact>) addressBookMap.get(itr.next()).contactList.stream()
                    .filter(contact -> contact.getCity().equalsIgnoreCase(cityOrStateName)|| contact.getState().equalsIgnoreCase(cityOrStateName))
                    .collect(Collectors.toList());
            System.out.println(persons);
        }
    }
}