//interface Notification {
//    public void send(String message);
//}
//
//class EmailNotification implements Notification {
//    @java.lang.Override
//    public void send(String message) {
//        System.out.println("Sending email : " + message);
//    }
//}
//
//class SMSNotification implements Notification {
//    @java.lang.Override
//    public void send(String message) {
//        System.out.println("Sending sms : " + message);
//    }
//}
//
//class PUSHNotification implements Notification {
//    @java.lang.Override
//    public void send(String message) {
//        System.out.println("Sending push : " + message);
//    }
//}
//
//class NotificationFactory {
//    public static Notification createNotification(String type) {
//        if(type.equals("email")) {
//            return new EmailNotification();
//        }
//        else if(type.equals("sms")) {
//            return new SMSNotification();
//        }
//        else if(type.equals("push")) {
//            return new PUSHNotification();
//        }
//        else {
//            throw new IllegalArgumentException("unknown type notification : " + type);
//        }
//    }
//}
//
//class NotificationService {
//    public static Notification send(String type) {
//        Notification notification = NotificationFactory.createNotification(type);
//    }
//}
//
//class Factory {
//    public static void main(String[] args) {
//        Notification n1 = NotificationService.send("email");
//        Notification n2 = NotificationService.send("sms");
//        n1.send("send to vamai");
//        n2.send("send to kottapalli");
//    }
//}

interface Payment {
    void pay(double amount);
}

class CreditcardPayment implements Payment {
    @java.lang.Override
    public void pay(double amount) {
        System.out.println("Payment using credit card : " + amount);
    }
}

class UPIPayment implements Payment {
    @java.lang.Override
    public void pay(double amount) {
        System.out.println("Payemnt using upi : " + amount) ;
    }
}

class PayPalPayment implements Payment {
    @java.lang.Override
    public void pay(double amount) {
        System.out.println("Payment using paypal : " + amount);
    }
}

class PaymentFactory {
    public static Payment CreatePayment(String type) {
        if(type.equals("credit")) {
            return new CreditcardPayment();
        }
        else if(type.equals("upi")) {
            return new UPIPayment();
        }
        else return  new PayPalPayment();
    }
}

class PaymentService {
    public static Payment pay(String type) {
        return PaymentFactory.CreatePayment(type);
    }
}

class Factory {
    public static void main(String[] args) {
        Payment p1 = PaymentService.pay("credit");
        p1.pay(2000);
        Payment p2 = PaymentService.pay("upi");
        p2.pay(1000);
    }
}