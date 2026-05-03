package __Proyectos.taskflow.model;

public sealed abstract class Notification permits EmailNotification,SmsNotification,PushNotification{
    private final String recipient;
    private final String message;

    public Notification(String recipient, String message) {
        this.recipient = recipient;
        this.message = message;
    }

    public String getRecipient() {
        return recipient;
    }
    public String getMessage() {
        return message;
    }
}
