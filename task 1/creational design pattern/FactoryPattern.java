// Notification interface
interface Notification {
    void send();
}

// Concrete classes
class EmailNotification implements Notification {
    @Override
    public void send() {
        System.out.println("Sending Email Notification...");
    }
}

class SMSNotification implements Notification {
    @Override
    public void send() {
        System.out.println("Sending SMS Notification...");
    }
}

// Factory class
class NotificationFactory {
    public static Notification createNotification(String type) {
        if (type.equalsIgnoreCase("email")) {
            return new EmailNotification();
        } else if (type.equalsIgnoreCase("sms")) {
            return new SMSNotification();
        }
        return null;
    }
}

// Main class to demonstrate Factory Pattern
public class FactoryPattern {
    public static void main(String[] args) {
        Notification notification = NotificationFactory.createNotification("email");
        if (notification != null) {
            notification.send();
        }
    }
}
