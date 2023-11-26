package com.bridgeLabz;

import java.util.*;

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
            System.out.println("Select \n1. for creating Address Book\n2. for show address book\n3. Exit");
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
                    System.out.println("Thank you to visit here.");
                    check = false;
                    break;
                default:  {System.out.println("Enter or select valid number");
                    multipleAddressBooks();}
            }
        }
    }

    public void displayAddressBook(Object key) {
        System.out.println(addressBookMap.get(key));
    }

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
}
