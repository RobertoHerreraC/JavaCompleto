package __Proyectos._09_JobTrackAsincrona.service;

import __Proyectos._09_JobTrackAsincrona.annotation.Auditable;

import java.lang.reflect.Method;
import java.util.Arrays;

public class AuditService {
    public void printAuditableMethods(Object service){
        Class<?> clazz = service.getClass();
        System.out.println("Auditando clases: "+clazz.getSimpleName());

        Arrays.stream(clazz.getDeclaredMethods())
                .filter(method -> method.isAnnotationPresent(Auditable.class))
                .forEach(this::printAuditInfo);
    }

    private void printAuditInfo(Method method){
        method.setAccessible(true);
        Auditable auditable = method.getAnnotation(Auditable.class);

        System.out.println(
                "Metodo auditable: "+
                        method.getName() +
                        " | action="+
                        auditable.action()
        );
    }
}
