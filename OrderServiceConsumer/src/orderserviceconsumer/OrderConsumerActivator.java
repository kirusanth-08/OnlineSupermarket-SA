package orderserviceconsumer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import orderserviceproducer.OrderService;

public class OrderConsumerActivator implements BundleActivator {
	
	ServiceReference serviceReference;

    public void start(BundleContext context) throws Exception {
    	System.out.println("Customer service Consumer started");
		serviceReference = context.getServiceReference(OrderService.class.getName());
		OrderService producer = (OrderService) context.getService(serviceReference);
		producer.orderItem();
    }

    public void stop(BundleContext context) throws Exception {
        System.out.println("Customer service consumer Stopped");
		context.ungetService(serviceReference);
    }

}
