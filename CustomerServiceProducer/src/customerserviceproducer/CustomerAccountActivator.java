package customerserviceproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;


public class CustomerAccountActivator implements BundleActivator {

	ServiceRegistration publishServiceRegistration;
	
	
	public void start(BundleContext context) throws Exception {
		
		System.out.println("Customer accout service Started");
		CustomerProducer publishService = new CustomerProducerImpl();
		
		publishServiceRegistration = context.registerService(CustomerProducer.class.getName(), publishService , null);
		
		
	}

	
	public void stop(BundleContext context) throws Exception {
		
		System.out.println("Customer account service Stopped");
		publishServiceRegistration.unregister();
	}
}
