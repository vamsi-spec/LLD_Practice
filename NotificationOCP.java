interface NotificationService {
    String sendNotification(String message);
}

class EmailService implements NotificationService {
    @Override
    public String sendNotification(String message) {
        System.out.println("Send Email : " + message);
        return "Email sent";
    }
}

class SMSService implements NotificationService {
    @Override
    public String sendNotification(String message) {
        System.out.println("Send SMS : " + message);
        return "SMS sent";
    }
}

class PUSHService implements NotificationService {
    @Override
    public String sendNotification(String message) {
        System.out.println("Send PUSH : " + message);
        return "PUSH sent";
    }
}

class Service {
    private String message;
    private NotificationService notificationService;

    Service(String message, NotificationService notificationService) {
        this.message = message;
        this.notificationService = notificationService;
    }

    public String send() {
        return notificationService.sendNotification(message);
    }
}

public class NotificationOCP {
    public static void main(String[] args) {

        String message = "Your recharge successful";

        Service emailService =
                new Service(message, new EmailService());

        Service smsService =
                new Service(message, new SMSService());

        Service pushService =
                new Service(message, new PUSHService());

        emailService.send();
        smsService.send();
        pushService.send();
    }
}
