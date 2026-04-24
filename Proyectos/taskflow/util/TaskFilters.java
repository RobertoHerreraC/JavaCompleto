package Proyectos.taskflow.util;

import Proyectos.taskflow.model.SmsNotification;

import java.util.List;

public class TaskFilters {
    public static void addDefaultSms(List<? super SmsNotification> target){
        target.add(new SmsNotification("99884645", "Mensaje por defecto"));
    }
}
