package com.roberto;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DatabaseConfig {
    private final String url;
    private final String user;
    private final String password;

    public DatabaseConfig(){
        Properties properties = new Properties();
        try (
                InputStream input = DatabaseConfig.class.getClassLoader().getResourceAsStream("application.properties");
                ){
            if(input==null) throw new IllegalStateException("No se encontro aplication.properties");

            properties.load(input);
            this.url = properties.getProperty("db.url");
            this.user = properties.getProperty("db.user");
            this.password = properties.getProperty("db.password");
        }catch (IOException e){
            throw new IllegalArgumentException("Error leyendo configuracion: ",e);
        }
    }

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}
