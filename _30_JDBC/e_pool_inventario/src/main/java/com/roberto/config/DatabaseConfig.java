package com.roberto.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DatabaseConfig {

    private final Properties properties = new Properties();

    public DatabaseConfig(){
        try(InputStream input = DatabaseConfig.class.getClassLoader().getResourceAsStream("application.properties")){
            if(input==null) throw new IllegalArgumentException("No se encontro application.properties");

            properties.load(input);
        }catch (IOException e){
            throw new IllegalArgumentException("Erro leyendo application.properties",e);
        }
    }

    public String url(){
        return properties.getProperty("db.url");
    }

    public String user(){
        return properties.getProperty("db.user");
    }

    public String password(){
        return properties.getProperty("db.password");
    }

    public int poolSize(){
        return Integer.parseInt(properties.getProperty("db.pool.size","10"));
    }

}
