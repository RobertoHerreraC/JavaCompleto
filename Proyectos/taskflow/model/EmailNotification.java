package Proyectos.taskflow.model;

public final class EmailNotification extends Notification {
    private final String subject;

    public EmailNotification(String recipient, String message, String subject) {
        super(recipient, message);
        this.subject = subject;
    }
    public String getSubject() {
        return subject;
    }
}
