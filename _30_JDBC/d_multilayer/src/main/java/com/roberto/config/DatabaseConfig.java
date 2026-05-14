package com.roberto.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DatabaseConfig {
    private final String url;
    private final String user;
    private final String password;

    public DatabaseConfig(){
        Properties properties = new Properties();
        try(InputStream inputStream = DatabaseConfig.class.getClassLoader()
                .getResourceAsStream("application.properties")){
            if(inputStream==null) throw new IllegalStateException("No se encontro application.properties");

            properties.load(inputStream);
            this.url = properties.getProperty("db.url");
            this.user = properties.getProperty("db.user");
            this.password = properties.getProperty("db.password");
        }catch (IOException e){
            throw new IllegalStateException("Error leyendo configuracion",e);
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
