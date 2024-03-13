package customerserviceconsumer;

import customerserviceproducer.CustomerProducer;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class CustomerActivator implements BundleActivator {
	
	ServiceReference serviceReference;

    public void start(BundleContext context) throws Exception {
    	System.out.println("Customer service Consumer started");
		serviceReference = context.getServiceReference(CustomerProducer.class.getName());
		CustomerProducer producer = (CustomerProducer) context.getService(serviceReference);
		producer.firstMenu();
    }

    public void stop(BundleContext context) throws Exception {
        System.out.println("Customer service consumer Stopped");
		context.ungetService(serviceReference);
    }
}


