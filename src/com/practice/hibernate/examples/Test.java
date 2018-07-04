package com.practice.hibernate.examples;

import java.util.Scanner;

public class Test {

	private static void getUserMenu() {

		System.out.println("Save) Save User");
		System.out.println("Get) Get User");
		System.out.println("Update) Update User");
		System.out.println("Remove) Remove User");

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Your Choice:");
		String YourChoice = scanner.next();
		ICustomer iCustomer = new CustomerImpl();

		switch (YourChoice) {
		case "Save":

			Customer customer = new Customer();
			customer.setCustomerId(5);
			customer.setCustomerCity("Ahmedabad");
			customer.setCustomerName("Dhruv Patel");
			iCustomer.saveCustomer(customer);

			break;
		case "Get":

			System.out.println("Enter The Customer ID You Want to Load:");
			int customerId = scanner.nextInt();
			iCustomer.getCustomer(customerId);
			break;

		case "Update":

			Customer customer1 = new Customer();
			customer1.setCustomerId(6);
			customer1.setCustomerCity("NJ");
			customer1.setCustomerName("Parth");
			iCustomer.updateCustomer(customer1);

			break;
		case "Remove":

			Customer customer2 = new Customer();
			customer2.setCustomerId(2);

			iCustomer.removeCustomer(customer2);

			break;

		default:
			System.out.println("Enter Correct Choice:");
			System.exit(0);
			break;
		}
		scanner.close();

	}

	public static void main(String[] args) {

		getUserMenu();

	}

}
