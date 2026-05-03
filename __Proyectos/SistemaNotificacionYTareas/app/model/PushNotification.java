package __Proyectos.SistemaNotificacionYTareas.app.model;

public final class PushNotification extends Notification {
    private final String appnName;
    public PushNotification(String recipient, String message, String appnName) {
        super(recipient, message);
        this.appnName = appnName;
    }

    public String getAppnName() {
        return appnName;
    }
}
