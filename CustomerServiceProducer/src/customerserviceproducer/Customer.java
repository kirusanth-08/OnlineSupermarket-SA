package customerserviceproducer;

import java.util.Scanner;

public class Customer {
	private String username;
	private String password;
	
	public Customer(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public String getUserName() {
		return username;
	}
	
	public boolean checkPassword() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter your password: ");
		String pwd = scan.next();
		
		while(!this.password.equals(pwd)) {
			System.out.println("[X] Go back");
			System.out.print("Invalid password, Enter again: ");
			pwd = scan.next();
			if(pwd.equalsIgnoreCase("x")) {
				scan.close();
				return false;
			}
		}
		scan.close();
		return true;
	}
	
	public void changeUsername(String username) {
		this.username = username;
	}
	
	public void changePassword(String pass) {
		this.password = pass;
	}
	
}
