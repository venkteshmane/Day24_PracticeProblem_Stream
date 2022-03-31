package com.bridgelabz;

import java.util.*;

class AddressBookMain {

    public static Scanner sc = new Scanner(System.in);
    private static AddressBook addressBook = new AddressBook();
    public Map<String,AddressBook> addressBookListMap = new HashMap<>();

    public void addAddressBook(String addressBookName){
        AddressBookMain addBookMain = new AddressBookMain();
        boolean flag = true;

        while(flag) {

            System.out.println("1.Add Contact");
            System.out.println("2.Edit Contact");
            System.out.println("3.Delete");
            System.out.println("4.Exit");
            System.out.println("Enter Choice: ");

            int option = sc.nextInt();

            switch (option)
            {
                case 1:
                    System.out.println("Enter the number of Contacts to be added");
                    int numOfContacts = sc.nextInt();
                    for(int i = 0; i < numOfContacts; i++) {
                        addressBook.addNewContact();
                    }
                    break;

                case 2:
                    System.out.println("Enter the Person First name to edit details: ");
                    String firstName = sc.next();

                    boolean listEdited = addressBook.editContact(firstName);
                    if (listEdited) {
                        System.out.println("List Edited Successfully");
                    } else {
                        System.out.println("List Cannot be Edited");
                    }
                    break;

                case 3:
                    System.out.println("Enter the Contact to be deleted:");
                    String lastName = sc.next();
                    boolean listDeleted = addressBook.deleteContact(lastName);
                    if (listDeleted) {
                        System.out.println("Deleted Contact from the List");
                    } else {
                        System.out.println("List Cannot be Deleted");
                    }
                    break;

                case 4:
                    flag =false;
                    break;
            }
            addressBookListMap.put(addressBookName, addressBook);
            System.out.println("Address Book Added Successfully");
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Address Book Management System");
        AddressBookMain addressBookMain = new AddressBookMain();
        boolean flag =true;
        while(flag)
        {
            System.out.println("1.Add New Address Book");
            System.out.println("2.Find Duplicate Entry in Address Book");
            System.out.println("3.Exit");
            System.out.println("Enter choice: ");
            int option = sc.nextInt();
            switch (option){
                case 1:
                    System.out.println("Enter the Name of Address Book: ");
                    String addressBookName = sc.next();
                    if(addressBookMain.addressBookListMap.containsKey(addressBookName)){
                        System.out.println("The Address book Already Exists");
                        break;
                    } else {
                        addressBookMain.addAddressBook(addressBookName);
                        break;
                    }

                case 2:
                    for (Map.Entry<String, AddressBook> entry : addressBookMain.addressBookListMap.entrySet()) {
                        AddressBook value = entry.getValue();
                        System.out.println("Address Book Name: " + entry.getKey());
                        value.checkDuplicate();
                    }

                case 3:
                    flag = false;
                    break;
            }
        }
    }
}