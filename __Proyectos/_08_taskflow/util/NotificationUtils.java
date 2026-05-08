package __Proyectos._08_taskflow.util;

import __Proyectos._08_taskflow.model.Notification;

import java.util.List;

public class NotificationUtils {
    public static void printRecipient(List<? extends Notification> notifications){
        notifications.forEach( n ->
                System.out.println(n.getRecipient()+ " -> "+n.getMessage()));
    }
}
