package orderserviceproducer;

public class Product {
	int id;
	public String name;
	public double price;
	
	public Product( int id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public String getName() {
		return this.name;
	}
	
	public double calculatePrice(int qty) {
		return qty * this.price;
	}
	
	
}
