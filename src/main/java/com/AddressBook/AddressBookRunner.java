package com.AddressBook;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class AddressBookRunner {
	
	private static Scanner scan = new Scanner(System.in);
	List<AddressBookPOJO> personList = new ArrayList<AddressBookPOJO>();
	
	/** Asks the user for details of the person and storing in person List */
	public void addDetails() {
		AddressBookPOJO person = new AddressBookPOJO();
		
		System.out.print("\nEnter First name : ");
		person.setFirstName(scan.next());
		
		System.out.print("Enter Last name : ");
		person.setLastName(scan.next());
		
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
		
		System.out.println("\nGiven Details are added into the Book");
		
	}
	
}
