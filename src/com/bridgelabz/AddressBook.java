package com.bridgelabz;

import java.util.HashSet;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;

public class AddressBook {

    public static Scanner sc = new Scanner(System.in);

    public ArrayList<Contacts> contactList = new ArrayList<>();

    public void addNewContact() {
        // adding new contacts
        System.out.println("Enter the Following Contact Details :");
        System.out.println("Enter the First Name :");
        String firstName = sc.next();
        System.out.println("Enter the Last Name :");
        String lastName = sc.next();
        System.out.println("Enter the Address :");
        String address = sc.next();
        System.out.println("Enter the City :");
        String city = sc.next();
        System.out.println("Enter the State :");
        String state = sc.next();
        System.out.println("Enter the EMail ID :");
        String email = sc.next();
        System.out.println("Enter the Phone Number :");
        String phoneNumber = sc.next();
        System.out.println("Enter the Zip Code :");
        System.out.println("Enter the Zip Code :");
        String zip = sc.next();
        Contacts contacts = new Contacts(firstName, lastName, address, city, state, email, phoneNumber, zip);
        contactList.add(contacts);

    }

    public boolean editContact(String Name) {
        int flag = 0;
        for (Contacts contact : contactList) {
            if (contact.getFirstName().equals(Name)) {
                System.out.println("Enter the Contact details which you needs to be Updated :");

                System.out.println("1 : First Name of the Contact to be Edited");
                System.out.println("2 : Last Name of the contact to be edited");
                System.out.println("3 : Address of the contact to be edited");
                System.out.println("4 : City of the contact to be edited");
                System.out.println("5 : State of the contact to be edited");
                System.out.println("6 : Email of the contact to be edited");
                System.out.println("7 : Phone Number of the contact to be edited");
                System.out.println("8 : Zip of the contact to be edited");

                System.out.println("Select the Following choices for the contact detail you want to edit ");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1 :
                        System.out.println("Enter First Name: ");
                        String firstName = sc.next();
                        contact.setFirstName(firstName);
                        break;

                    case 2 :
                        System.out.println("Enter last name: ");
                        String lastName = sc.next();
                        contact.setLastname(lastName);
                        break;

                    case 3 :
                        System.out.println("Enter Address: ");
                        String address = sc.next();
                        contact.setAddress(address);
                        break;

                    case 4 :
                        System.out.println("Enter City: ");
                        String city = sc.next();
                        contact.setCity(city);
                        break;

                    case 5 :
                        System.out.println("Enter State: ");
                        String state = sc.next();
                        contact.setState(state);
                        break;

                    case 6 :
                        System.out.println("Enter Email: ");
                        String email = sc.next();
                        contact.setZip(email);
                        break;

                    case 7 :
                        System.out.println("Enter Phone Number:");
                        String phoneNumber = sc.next();
                        contact.setPhoneNum(phoneNumber);
                        break;

                    case 8 :
                        System.out.println("Enter Zip Code: ");
                        String zip = sc.next();
                        contact.setZip(zip);
                        break;

                }

                flag = 1;
                break;
            }
        }
        return flag == 1;
    }

    //Method to Delete the Existing Contact
  /*  public void deleteContact() {
        //Get First Name to Edit the Contact
        System.out.println("Enter the First Name : ");
        String firstName = sc.next();
        //check if the Given User with First Name
        boolean isAvailable = false;
        for(Contacts contact : contactList) {
            if (firstName.equalsIgnoreCase(contact.getFirstName())) {
                isAvailable = true;
                contactList.remove(contact);
                System.out.println("Contact deleted");
                break;
            }
        }
        if(!isAvailable) {
            System.out.println("Contact number is not available");
        }
    }*/
    public boolean deleteContact(String name) {
        int flag = 0;
        for (Contacts contact : contactList) {
            if (contact.getFirstName().equals(name)) {
                contactList.remove(contact);
                flag = 1;
                break;
            }
        }
        return flag == 1;
    }

    // method created to check the Duplicate entries
    public void checkDuplicate() {
        Set<String> ContactSet = new HashSet<>();
        Set<Contacts> filterSet = contactList.stream().filter(n -> !ContactSet.add(n.getFirstName())).collect(Collectors.toSet());

        for (Contacts contact : filterSet) {
            System.out.println("The Duplicate Contact Entry is: " + contact.getFirstName() + " " + contact.getLastname());
        }
    }
}