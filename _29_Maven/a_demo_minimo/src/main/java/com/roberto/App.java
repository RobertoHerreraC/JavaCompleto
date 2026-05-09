package com.roberto;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class App {
    static void main()  {
        Properties properties = new Properties();
        try(InputStream inputStream = App.class.getClassLoader().getResourceAsStream("application.properties")){
            if(inputStream ==null) throw new IllegalStateException("No se encontro application.properties");

            properties.load(inputStream);
            String appName = properties.getProperty("app.name");
            String appVersion = properties.getProperty("app.version");

            System.out.println("Aplicacion:"+appName);
            System.out.println("Version:"+appVersion);
        }catch (IOException e){
            throw new RuntimeException("Error leyendo configuracion: "+e);
        }
    }
}
