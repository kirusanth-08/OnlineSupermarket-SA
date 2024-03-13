package orderserviceproducer;

import java.util.ArrayList;
import java.util.Scanner;



public class OrderServiceImpl implements OrderService {

	ArrayList<Product> products = new ArrayList<Product>();
	ArrayList<OrderItems> orderItems = new ArrayList<OrderItems>();
	
	public OrderServiceImpl() {
		products.add(new Product( 01, "Book\t", 1000.00));
		products.add(new Product( 02, "Pen\t", 25.00));
		products.add(new Product( 03, "Pencil", 15.00));
		products.add(new Product( 04, "Book Cover", 50.00));
		products.add(new Product( 05, "Ruler\t", 30.00));
	}
	
	public void orderItem() {
		System.out.println("==========================================\n");
		System.out.println("Product\t\t" + "price");
		for(Product product: products) {
			System.out.println("| " + product.id + ")" + product.getName() + "\t\t" + product.getPrice() + "\t | ");
		}
		System.out.println("==========================================");
		addItems();
	}
	
	public Product findItem(int id) {
		for(Product product: products) {
			if(product.id == id) {
				return product;
			}
		}
		return null;
	}
	
	
	@Override
	public void addItems() {
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("[-1] Completed.");
			System.out.print("Enter product id: ");
			int check = scan.nextInt();
			if(check == -1) {
				bill();
				break;
			}
			while(findItem(check) == null) {
				System.out.print("Enter valid product id: ");
				check = scan.nextInt();
			}

			System.out.print("Enter quantity: ");
			int qty = scan.nextInt();
			orderItems.add(new OrderItems(check, qty));
		}
	}
	

	@Override
	public void bill() {
		System.out.println("==========================================\n");
		for(OrderItems orderItem: orderItems) {
			Product p = findItem(orderItem.id);
			System.out.println( "| " + p.getName() + " " + orderItem.qty + " " + p.calculatePrice(orderItem.qty) + "\t |" );
		}
		System.out.println("==========================================\n");
	}
	
}
