package com.AddressBook;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AddressBookRunner {
	
	private static Scanner scan = new Scanner(System.in);
	ArrayList<AddressBookPOJO> personList = new ArrayList<AddressBookPOJO>();
	Map<String,ArrayList<AddressBookPOJO>> addressBook = new HashMap<String, ArrayList<AddressBookPOJO>>();
	
	/** Asks the user for details of the person and storing in person List */
	public void addDetails() {
		AddressBookPOJO person = new AddressBookPOJO();
		
		System.out.print("Enter Existing Book name or New Book Name to add contact : ");
		String bookName  = scan.next();
		
		if(addressBook.containsKey(bookName)) {
			System.out.println("Contact will be added to existing '"+bookName+"' Book");
		} else {
			System.out.println("New Address Book Created with the Name '"+bookName+"'");
		}
		
		System.out.print("\nEnter First name : ");
		String firstName=scan.next();
		person.setFirstName(firstName);
		
		System.out.print("Enter Last name : ");
		String lastName=scan.next();
		person.setLastName(lastName);
		
		// Ensuring there is no Duplicate Entry of the same Person in a Address Book
		String userName = firstName+" "+lastName;
		for (int k = 0; k < personList.size(); k++) {
			String contactName = personList.get(k).getFirstName()+" "+personList.get(k).getLastName(); 
			if (userName.equals(contactName)) {
				System.out.println("Can not allow Duplicate Contact");
				addDetails();
			}
		}
		
		System.out.print("Enter Address : ");
		person.setAddress(scan.next());
		
		System.out.print("Enter City name : ");
		person.setCity(scan.next());
		
		System.out.print("Enter State name : ");
		person.setState(scan.next());
		
		System.out.print("Enter ZIP Code : ");
		person.setZipCode(scan.next());
		
		System.out.print("Enter Phone Number : ");
		person.setPhoneNumber(scan.next());
		
		System.out.print("Enter E-Mail ID : ");
		person.setEmail(scan.next());
		
		// Adding the details into list
		personList.add(person);
		addressBook.put(bookName,personList);
		System.out.println("\nGiven Details are added into the Book");
		
	}
	
	/**
	 * To search for the given name in the list 
	 * @return Index of First name
	 */
	private int searchName() {
		System.out.println("\nEnter the First name of person: ");
		String searchName=scan.next();
		for (int i=0; i<personList.size(); i++) {
			if (personList.get(i).getFirstName().equals(searchName)) {
				return i;
			} else if (i==personList.size()-1) {
				System.out.println("Given name is not found in the Book");
			}
		}
		return personList.size();
	}
	
	/** Asks the user to edit existing details using the name of the person */
	public void editDetails() {
		int index = searchName();
		if (index!=personList.size()) {
			AddressBookPOJO details = personList.get(index);
			System.out.println(details.toString());
			System.out.println("\nEnter slot number that to be edit from above");
			int slotnumber = scan.nextInt();
			while(slotnumber<10) {
				switch (slotnumber) {
				case 0: slotnumber=10;
					break;
				case 1: System.out.print("\nEnter First name : ");
					details.setFirstName(scan.next());
					System.out.println("\nEnter other slot number to Edit or Press'0' to Exit");
					slotnumber=scan.nextInt();
					break;
				case 2: System.out.print("\nEnter Last name : ");
					details.setLastName(scan.next());
					System.out.println("\nEnter other slot number to Edit or Press'0' to Exit");
					slotnumber=scan.nextInt();
					break;
				case 3: System.out.print("Enter Address : ");
					details.setAddress(scan.next());
					System.out.println("\nEnter other slot number to Edit or Press'0' to Exit");
					slotnumber=scan.nextInt();
					break;
				case 4: System.out.print("Enter City name : ");
					details.setCity(scan.next());
					System.out.println("\nEnter other slot number to Edit or Press'0' to Exit");
					slotnumber=scan.nextInt();
					break;
				case 5: System.out.println("Enter State name : ");
					details.setState(scan.next());
					System.out.println("\nEnter other slot number to Edit or Press'0' to Exit");
					slotnumber=scan.nextInt();
					break;
				case 6: System.out.println("Enter ZIP Code : ");
					details.setZipCode(scan.next());
					System.out.println("\nEnter other slot number to Edit or Press'0' to Exit");
					slotnumber=scan.nextInt();
					break;
				case 7: System.out.print("Enter Phone Number : ");
					details.setPhoneNumber(scan.next());
					System.out.println("\nEnter other slot number to Edit or Press'0' to Exit");
					slotnumber=scan.nextInt();
					break;
				case 8:	System.out.print("Enter E-Mail ID : ");
					details.setEmail(scan.next());
					System.out.println("\nEnter other slot number to Edit or Press'0' to Exit");
					slotnumber=scan.nextInt();
					break;
				default: System.out.println("Enter valid input");
				}
			}
			System.out.println("After Updating:"+details.toString());
		}
	}
	
	/** Asks the user to delete existing details using the name of the person */
	public void deleteDetails() {
		int index = searchName();
		if (index!=personList.size()) {
			personList.remove(index);
			System.out.println("Given name details were deleted from the list");
		}
	}
	
	/** To show existing details using the name of the person */
	public void showDetails() {
		int index = searchName();
		if (index!=personList.size()) {
			AddressBookPOJO person = personList.get(index);
			System.out.println(person.toString());
		}
	}
	
	/** To show list of Persons Across the city or State */
	public void contactList() {
        System.out.print("Enter Name of City or State to get Contact List : ");
        String nameCityState = scan.next();
        System.out.println("\nContact list of persons across '"+nameCityState+"'+ is");
        for (int i = 0; i < personList.size(); i++) {
        	AddressBookPOJO details = personList.get(i);
            if (details.getCity().equals(nameCityState) || details.getState().equals(nameCityState)) {
                System.out.println(details.getFirstName()+" "+details.getLastName());
            }
        }
    }
}
