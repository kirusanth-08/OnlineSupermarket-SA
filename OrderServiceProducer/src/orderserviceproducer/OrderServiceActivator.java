package orderserviceproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;


public class OrderServiceActivator implements BundleActivator {

	ServiceRegistration publishServiceRegistration;
	
	
	public void start(BundleContext context) throws Exception {
		
		System.out.println("Order Service Started");
		OrderService publishService = new OrderServiceImpl();
		
		publishServiceRegistration = context.registerService(OrderService.class.getName(), publishService , null);
		
		
	}

	
	public void stop(BundleContext context) throws Exception {
		
		System.out.println("Order Service Stopped");
		publishServiceRegistration.unregister();
	}

}
