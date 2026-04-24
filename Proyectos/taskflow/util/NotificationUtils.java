package Proyectos.taskflow.util;

import Proyectos.taskflow.model.Notification;

import java.util.List;

public class NotificationUtils {
    public static void printRecipient(List<? extends Notification> notifications){
        notifications.forEach( n ->
                System.out.println(n.getRecipient()+ " -> "+n.getMessage()));
    }
}
