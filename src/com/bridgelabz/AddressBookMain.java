package com.bridgelabz;

import java.util.*;
import java.util.stream.Collectors;

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
            System.out.println("3.Delete Contact");
            System.out.println("4.Exit");
            System.out.println("Enter Choice: ");

            int option = sc.nextInt();

            switch (option)
            {
                case 1 -> {
                    System.out.println("Enter the number of Contacts to be added");
                    int numOfContacts = sc.nextInt();
                    for (int i = 0; i < numOfContacts; i++) {
                        addressBook.addNewContact();
                    }
                }
                case 2 -> {
                    System.out.println("Enter the Person First name to edit details: ");
                    String firstName = sc.next();

                    boolean listEdited = addressBook.editContact(firstName);
                    if (listEdited) {
                        System.out.println("List Edited Successfully");
                    } else {
                        System.out.println("List Cannot be Edited");
                    }
                }
                case 3 -> {
                    System.out.println("Enter the Contact to be deleted:");
                    String lastName = sc.next();
                    boolean listDeleted = addressBook.deleteContact(lastName);
                    if (listDeleted) {
                        System.out.println("Deleted Contact from the List");
                    } else {
                        System.out.println("List Cannot be Deleted");
                    }
                }
                case 4 -> flag =false;
            }
            addressBookListMap.put(addressBookName, addressBook);
            System.out.println("Address Book Added Successfully");
        }
    }

    // UC8- method to search a person by State name
    private void searchPersonByState(String stateName) {
        for(Map.Entry<String,AddressBook> entry: addressBookListMap.entrySet()) {
            AddressBook value = entry.getValue();
            System.out.println("The Address Book: "+entry.getKey());
            value.getPersonNameByState(stateName);
        }
    }
    // UC8- method to search a person by City name
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
        int countPersonInState = 0;
        for(Map.Entry<String, AddressBook> entry: addressBookListMap.entrySet()){
            for(int i=0;i<(entry.getValue()).contactList.size();i++) {
                Contacts contact= entry.getValue().contactList.get(i);
                if(state.equals(contact.getState()))
                   countPersonInState++;
            }
        }
        System.out.println("Total Count of Persons in state "+state+": "+countPersonInState);
    }

    // UC10- method to count no.of persons by city name
    public void CountByCity(String city) {
        int countPersonInCity=0;
        for(Map.Entry<String, AddressBook> entry: addressBookListMap.entrySet()) {
            for(int i=0;i<(entry.getValue()).contactList.size();i++) {
                Contacts contacts= (Contacts) entry.getValue().contactList.get(i);
                if(city.equals(contacts.getCity()))
                    countPersonInCity++;
                }
        }
        System.out.println("Total Count of Persons in City "+city+": "+countPersonInCity);
    }

    // UC11- Sorting the Contacts by Name
    private void sortContactByName() {
        for (Map.Entry<String,AddressBook>entry:addressBookListMap.entrySet()){
            AddressBook value = entry.getValue();
            List<Contacts> sortedList = value.contactList.stream().sorted(Comparator.comparing(Contacts::getFirstName)).collect(Collectors.toList());

            for(Contacts contact:sortedList){
                System.out.println("First Name: "+contact.getFirstName());
                System.out.println("Last Name: "+contact.getLastname());
            }
        }
    }

    //UC12- Sorting the Contacts by City name
    private void sortContactByCity() {
        for (Map.Entry<String,AddressBook>entry:addressBookListMap.entrySet()){
            AddressBook value = entry.getValue();
            List<Contacts> sortedList = value.contactList.stream().sorted(Comparator.comparing(Contacts::getCity)).collect(Collectors.toList());

            for(Contacts contact:sortedList){
                System.out.println("First Name: "+contact.getFirstName());
                System.out.println("Last Name: "+contact.getLastname());
            }
        }
    }

    //UC12- Sorting the Contacts by State name
    private void sortContactByState() {
        for (Map.Entry<String,AddressBook>entry:addressBookListMap.entrySet()){
            AddressBook value = entry.getValue();
            List<Contacts> sortedList = value.contactList.stream().sorted(Comparator.comparing(Contacts::getState)).collect(Collectors.toList());

            for(Contacts contact:sortedList){
                System.out.println("First Name: "+contact.getFirstName());
                System.out.println("Last Name: "+contact.getLastname());
            }
        }
    }

    //UC12- Sorting the Contacts by Zip code
    private void sortContactByZipCode() {
        for (Map.Entry<String,AddressBook>entry:addressBookListMap.entrySet()){
            AddressBook value = entry.getValue();
            List<Contacts> sortedList = value.contactList.stream().sorted(Comparator.comparing(Contacts::getZip)).collect(Collectors.toList());

            for(Contacts contact:sortedList){
                System.out.println("First Name: "+contact.getFirstName());
                System.out.println("Last Name: "+contact.getLastname());
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("**********Welcome to the Address Book Management System********");
        AddressBookMain addressBookMain = new AddressBookMain();
        boolean flag =true;
        while(flag) {
            System.out.println("Select the Following Operations to Perform on AddressBook:: ");
            System.out.println("1.Add New Address Book");
            System.out.println("2.Find Duplicate Entry in Address Book");
            System.out.println("3.Search Contact by City Name");
            System.out.println("4.Search Contact by State Name");
            System.out.println("5.View contact by State Using State and Person");
            System.out.println("6.View Contact by City Using City and Person");
            System.out.println("7.Count No. of Contacts By State Name");
            System.out.println("8.Count No.of Contacts By City Name");
            System.out.println("9.Sort Contacts in Alphabetically Order by Person Name");
            System.out.println("10.Sort Contact By City Name");
            System.out.println("11.Sort Contact By State Name");
            System.out.println("12.Sort Contact By Zip Code");
            System.out.println("13.Exit");

            System.out.println("Enter the Choice: ");
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
                    System.out.println("Sort Contact by Person Name");
                    addressBookMain.sortContactByName();
                    break;

                case 10:
                    System.out.println("Sort Contact by City Name");
                    addressBookMain.sortContactByCity();
                    break;

                case 11:
                    System.out.println("Sort Contact by State Name");
                    addressBookMain.sortContactByState();
                    break;

                case 12:
                    System.out.println("Sort Contact by Zip Code");
                    addressBookMain.sortContactByZipCode();
                    break;

                case 13:
                    flag = false;
                    break;
            }
        }
    }
}