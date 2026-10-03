interface PaymentGateway {
    public void processPayment(double amount);
}

interface Invoice {
    public void generateInvoice();
}

class RazorPayGateway implements PaymentGateway {
    public void processPayment(double amount) {
        System.out.println("Razor Pay processing : " + amount);
    }
}

class PayUGateway implements PaymentGateway {
    @Override
    public void processPayment(double amount) {
        System.out.println("PayU processing : " + amount);
    }
}

class GSTInvoice implements Invoice {
    public void generateInvoice() {
        System.out.println("Generating GST Invoice : ");
    }
}

class PayPalGateway implements PaymentGateway {
    @Override
    public void processPayment(double amount) {
        System.out.println("PayPal Processing : " + amount);
    }
}

class StripeGateway implements PaymentGateway {
    @Override
    public void processPayment(double amount) {
        System.out.println("Stripe Processing : ");
    }
}

class USInvoice implements Invoice {
    public void generateInvoice() {
        System.out.println("Generating US Invoice");
    }
}

//Abstract Factory
interface RegionFactory {
    PaymentGateway createPaymentGateway(String gatewayType);
    Invoice createInvoice();
}

class IndiaFactory implements RegionFactory {
    public PaymentGateway createPaymentGateway(String gatewayType) {
        if(gatewayType.equalsIgnoreCase("razorpay")) {
            return new RazorPayGateway();
        }
        else if(gatewayType.equals("payu")) {
            return new PayUGateway();
        }
        throw new IllegalArgumentException("Invalid payment gateway");
}

    public Invoice createInvoice() {
            return new GSTInvoice();
        }
}

class USFactory implements RegionFactory {
    public PaymentGateway createPaymentGateway(String gatewayType) {
        if(gatewayType.equalsIgnoreCase("stripe")) {
            return new StripeGateway();
        }
        else if(gatewayType.equalsIgnoreCase("paypal")) {
            return new PayPalGateway();
        }
        throw new IllegalArgumentException("Invalid payment gateway");
    }

    public Invoice createInvoice() {
        return new USInvoice();
    }
}

class FactoryProducer {
    private PaymentGateway paymentGateway;
    private Invoice invoice;

    FactoryProducer(RegionFactory factory, String gatewayType) {
        this.paymentGateway = factory.createPaymentGateway(gatewayType);
        this.invoice = factory.createInvoice();
    }

    public void completeOrder(double amount) {
        paymentGateway.processPayment(amount);
        invoice.generateInvoice();
    }
}


public class AbsFactory {
    public static void main(String[] args) {
        FactoryProducer factory = new FactoryProducer(new IndiaFactory(), "razorpay");
        factory.completeOrder(1000.00);
    }
}
