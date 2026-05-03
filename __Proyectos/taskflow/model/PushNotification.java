package __Proyectos.taskflow.model;

public final class PushNotification extends Notification{
    private final String appName;
    public PushNotification(String recipient, String message, String appName) {
        super(recipient, message);
        this.appName = appName;
    }
    public String getAppName() {
        return appName;
    }
}
