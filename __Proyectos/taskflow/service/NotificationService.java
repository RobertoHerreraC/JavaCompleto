package __Proyectos.taskflow.service;

import __Proyectos.taskflow.dto.NotificationResultDTO;
import __Proyectos.taskflow.model.EmailNotification;
import __Proyectos.taskflow.model.Notification;
import __Proyectos.taskflow.model.PushNotification;
import __Proyectos.taskflow.model.SmsNotification;

public class NotificationService {

    public NotificationResultDTO send(Notification notification) {
        if(notification instanceof EmailNotification emil){
            return new NotificationResultDTO(
                    "EMAIL",
                    emil.getRecipient(),
                    "Asunto enviado: "+ emil.getSubject()
            );
        }else if(notification instanceof SmsNotification sms){
            return new NotificationResultDTO(
                    "SMS",
                    sms.getRecipient(),
                    "SMS enviado correctamente"
            );
        }else if(notification instanceof PushNotification push){
            return new NotificationResultDTO(
                    "PUSH",
                    push.getRecipient(),
                    "PUSH enviado desde: "+ push.getAppName()
            );
        }
        throw new RuntimeException("Tipo de notificacion no soportado");
    }
}
