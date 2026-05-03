package __Proyectos.SistemaNotificacionYTareas.app.service;

import __Proyectos.SistemaNotificacionYTareas.app.dto.NotificationResponseDTO;
import __Proyectos.SistemaNotificacionYTareas.app.model.EmailNotification;
import __Proyectos.SistemaNotificacionYTareas.app.model.Notification;
import __Proyectos.SistemaNotificacionYTareas.app.model.PushNotification;
import __Proyectos.SistemaNotificacionYTareas.app.model.SmsNotification;

public class NotificationService {
    public NotificationResponseDTO process(Notification notification) {
        if(notification instanceof EmailNotification email){
            return new NotificationResponseDTO("EMAIL",email.getRecipient(),"Asunto: "+email.getSubject());
        }else if(notification instanceof  SmsNotification sms){
            return new NotificationResponseDTO("SMS",sms.getRecipient(),"SMS enviado correctamente");
        }else if(notification instanceof PushNotification push){
            return new NotificationResponseDTO("PUSH",push.getRecipient(),"Push enviado desde app: "+push.getAppnName());
        }
        throw new RuntimeException("Tipo de notificacion no soportado");
    }
}
