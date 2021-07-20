package com.AddressBook;

import java.util.Scanner;

/**
 * @author BALU
 * Main Class for AddressBook
 */
public class AddressBookMain {
	
	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		// Displaying Welcome Message
		System.out.println("Welcome to Address Book Program");
		// Creating an object of Class AddressBook
		AddressBookRunner addressBook = new AddressBookRunner();
		// Calling methods from class AddressBookRunner 
		boolean choice=true;
		while (choice) {
			System.out.println("\nChoose the option:\nPress '1' for Add\nPress '2' for Edit"
					+ "\nPress '3' for Delete\nPress '4' for Show\nPress '5' for Contact list by City State"
					+ "\nPress '0' for Exit");
			int option=scan.nextInt();
			switch (option) {
			case 0: choice=false;
				System.out.println("Exited out of AddressBook");
				break;
			case 1: addressBook.addDetails();
				break;
			case 2: addressBook.editDetails();
				break;
			case 3: addressBook.deleteDetails();
				break;
			case 4: addressBook.showDetails();
				break;
			case 5: addressBook.contactList();
				break;
			default: 
				System.out.println("Please enter valid input");
			}
		}
	}

}