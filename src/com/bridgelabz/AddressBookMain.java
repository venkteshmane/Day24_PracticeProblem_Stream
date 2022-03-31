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

    // UC8- method to search a person by city name
    private void searchPersonByState(String stateName) {
        for(Map.Entry<String,AddressBook> entry: addressBookListMap.entrySet()){
            AddressBook value = entry.getValue();
            System.out.println("The Address Book: "+entry.getKey());
            value.getPersonNameByState(stateName);
        }
    }
    // UC8- method to search a person by state name
    private void searchPersonByCity(String cityName) {
        for(Map.Entry<String,AddressBook> entry: addressBookListMap.entrySet()){
            AddressBook value = entry.getValue();
            System.out.println("The Address Book: "+entry.getKey());
            value.getPersonNameByCity(cityName);
        }
    }

    // UC9- method to view a person by state name
    private void viewPersonByStateUsingHashmap(String stateName) {
        for (Map.Entry<String, AddressBook> entry : addressBookListMap.entrySet()) {
            AddressBook value = entry.getValue();
            ArrayList<Contacts> contacts = value.personByState.entrySet().stream().filter(findState -> findState.getKey().equals(stateName)).map(Map.Entry::getValue).findFirst().orElse(null);
            for(Contacts contact: contacts){
                System.out.println("First Name: "+contact.getFirstName()+" Last Name: "+ contact.getLastname());
            }
        }
    }

    // UC9- method to view a person by city name
    private void viewPersonByCityUsingHashMap(String cityName) {
        for (Map.Entry<String, AddressBook> entry : addressBookListMap.entrySet()) {
            AddressBook value = entry.getValue();
            ArrayList<Contacts> contacts = value.personByCity.entrySet().stream().filter(findCity -> findCity.getKey().equals(cityName)).map(Map.Entry::getValue).findFirst().orElse(null);
            for(Contacts contact: contacts){
                System.out.println("First Name: "+contact.getFirstName()+" Last Name: "+ contact.getLastname());
            }
        }
    }

    // UC10- method to count no.of persons by state name
    public void CountByState(String state) {
        int count = 0;
        for(Map.Entry<String, AddressBook> entry: addressBookListMap.entrySet()){
            for(int i=0;i<(entry.getValue()).contactList.size();i++) {
                Contacts contact= entry.getValue().contactList.get(i);
                if(state.equals(contact.getState()))
                {
                    count++;
                }
            }
        }
        System.out.println("Total Person Count in state "+state+": "+count);
    }

    // UC10- method to count no.of persons by city name
    public void CountByCity(String city) {
        int countPersonInCity=0;
        for(Map.Entry<String, AddressBook> entry: addressBookListMap.entrySet()) {
            for(int i=0;i<(entry.getValue()).contactList.size();i++) {
                Contacts d= (Contacts) entry.getValue().contactList.get(i);
                if(city.equals(d.getCity())) {
                    countPersonInCity++;
                }
            }
        }
        System.out.println("Total number of people in this city "+city+": "+countPersonInCity);
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Address Book Management System");
        AddressBookMain addressBookMain = new AddressBookMain();
        boolean flag =true;
        while(flag) {
            System.out.println("1.Add New Address Book");
            System.out.println("2.Find Duplicate Entry in Address Book");
            System.out.println("3.Search Contact from a city");
            System.out.println("4.Search Contact from a State");
            System.out.println("5.View contact By State Using State and Person HashMap");
            System.out.println("6.View Contact by city Using City and Person HashMap");
            System.out.println("7.Count Contact By State");
            System.out.println("8.Count Contact By City");
            System.out.println("9.Exit");

            System.out.println("Enter choice: ");
            int option = sc.nextInt();
            switch (option){
                case 1:
                    System.out.println("Enter the Name of Address Book: ");
                    String addressBookName = sc.next();
                    if(addressBookMain.addressBookListMap.containsKey(addressBookName)){
                        System.out.println("The Address Book is Already Exists");
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
                    break;
                case 3:
                    System.out.println("Enter Name of City: ");
                    String cityName = sc.next();
                    addressBookMain.searchPersonByCity(cityName);
                    break;

                case 4:
                    System.out.println("Enter Name of State: ");
                    String stateName = sc.next();
                    addressBookMain.searchPersonByState(stateName);
                    break;

                case 5:
                    System.out.println("Enter Name of State: ");
                    String stateName1 = sc.next();
                    addressBookMain.viewPersonByStateUsingHashmap(stateName1);
                    break;

                case 6:
                    System.out.println("Enter Name of City: ");
                    String cityName1 = sc.next();
                    addressBookMain.viewPersonByCityUsingHashMap(cityName1);
                    break;

                case 7:
                    System.out.println("Enter Name of State: ");
                    String stateName2 = sc.next();
                    addressBookMain.CountByState(stateName2);
                    break;

                case 8:
                    System.out.println("Enter Name of City: ");
                    String cityName2 = sc.next();
                    addressBookMain.CountByCity(cityName2);
                    break;

                case 9:
                    flag = false;
                    break;
            }
        }
    }
}