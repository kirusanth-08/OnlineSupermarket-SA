package customerserviceproducer;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerProducerImpl implements CustomerProducer {
	private ArrayList<Customer> customers = new ArrayList<Customer>();
	private Customer current = null;
	
	public CustomerProducerImpl() {
		customers.add(new Customer("kirusanth", "kirusanth2001"));
		customers.add(new Customer("loshan", "losh"));
	}
	
	public void firstMenu() {
		System.out.println("Hello there, Welcome!");
		System.out.println("[1]Login(Account exists?)");
		System.out.println("[2]Register(New here?)");
		Scanner select = new Scanner(System.in);
		int selection = select.nextInt();
		if(selection == 1) {
			login();
		}else if(selection == 2) {
			register();
		}else {
			System.out.println("Invalid selection!");
		}
	}
	
	public void login() {
		Scanner scanner = new Scanner(System.in);
		String iUser = "";
		while(find(iUser) == null) {
			System.out.println("[X]-Main menu");
			System.out.print("Enter username:");
			iUser = scanner.next();
			if(iUser.equalsIgnoreCase("x")) {
				firstMenu();
				break;
			}else if(find(iUser) == null) {
				System.out.println("Invalid username, correct your name.");
				continue;
			} else {
				if(find(iUser).checkPassword()) {
//					this.current = find(iUser);
//					secondMenu();
//					break;
//				}else {
					firstMenu();
				}
			}
		}
	}
	
	public void register() {
		Scanner scanner = new Scanner(System.in);
		String iUser;
		while(true) {
			System.out.println("[X]-Main menu");
			System.out.print("Enter username:");
			iUser = scanner.next();
			if(iUser.equalsIgnoreCase("X")) {
				firstMenu();
				break;
			}else if(find(iUser) == null) {
				System.out.print("Enter password: ");
				addCustomer(iUser, scanner.next());
				secondMenu();
				break;
			}else if(find(iUser) != null){
				System.out.print("Username already exists, Try another one!");	
			}
		}
	}

	@Override
	public void addCustomer(String name, String password) {
		customers.add(new Customer( name, password));
		System.out.println("User registration success!!");
	}
	
	public Customer find(String uName) {
		for(Customer customer: customers) {
			if(customer.getUserName().equals(uName)) {
				return customer;
			}
		}
		return null;
	}
		
	
	public void secondMenu() {
		Scanner scan = new Scanner(System.in);
		int res = scan.nextInt();
		System.out.println("Welcome back, " + this.current.getUserName());
		System.out.println("[1]View Products");
		System.out.println("[2]Change username");
		System.out.println("[3]Change password");
		System.out.println("[4]Delete Account");
		
		if(res == 1) {
			System.out.println("Products not found!");
		}else if(res == 2) {
			customers.remove(current);
			System.out.print("Enter new username: ");
			current.changeUsername(scan.next());
			customers.add(current);
			System.out.print("Username is changed!, new username: " + current.getUserName());
		}else if(res == 3) {
			customers.remove(current);
			System.out.print("Enter new password: ");
			current.changePassword(scan.next());
			customers.add(current);
			System.out.print("Password is changed! ");
		}else if(res == 4) {
			System.out.println("Account deleted, You were logged out!");
			customers.remove(current);
			firstMenu();
		}
	}
	
	

	@Override
	public void removeCustomer() {
		
	}
	
}
