package customerserviceproducer;

public interface CustomerProducer {

	Customer find(String uName);
	void firstMenu();
	void secondMenu();
    void addCustomer(String name, String password);
    void removeCustomer();
}
