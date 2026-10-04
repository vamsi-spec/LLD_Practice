interface NotificationService {
    public void sendNotification(String recipent,String message);
}

class SMSService {
    public void sendSMS(String phoneNumber,String text) {
        System.out.println("Sending SMS to " + phoneNumber + ":" + text);
    }
}

class EmailService {
    public void sendEmail(String email,String subject,String body) {
        System.out.println("Sending Email to " + email + "subject" + subject + "body :" + body);
    }
}

class EmailAdapter implements NotificationService {
    private EmailService emailService;
    private String subject;

    public EmailAdapter(EmailService emailService, String subject) {
        this.emailService = emailService;
        this.subject = subject;
    }

    public void sendNotification(String recipient,String message) {
        emailService.sendEmail(recipient, subject, message);
    }
}

class SMSAdapter implements NotificationService {
    private SMSService smsService;

    public SMSAdapter(SMSService smsService) {
        this.smsService = smsService;
    }

    public void sendNotification(String phoneNumber,String message) {
        smsService.sendSMS(phoneNumber, message);
    }
}


class NotificationManager {
    private NotificationService notificationService;

    public NotificationManager(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void sendNotification(String recipient,String message) {
        notificationService.sendNotification(recipient,message);
    }
}

public class Adapter {
    public static void main(String[] args) {
        SMSService smsService = new SMSService();
        SMSAdapter smsAdapter = new SMSAdapter(smsService);

        NotificationManager manager = new NotificationManager(smsAdapter);
    
        manager.sendNotification("7894561230", "your OTP is 1234");

        EmailService emailService = new EmailService();
        EmailAdapter emailAdapter = new EmailAdapter(emailService, "OTP");

        NotificationManager manager2 = new NotificationManager(emailAdapter);
        manager2.sendNotification("[EMAIL_ADDRESS]","your OTP is 1234");
    }
}
