package com.roberto.service;

public class UserService {

    public boolean isValidName(String name){
        if(name==null) return false;

        String cleanName = name.trim();

        return cleanName.length()>=3;
    }

    public boolean isAdult(int age){
        if(age<0) throw new IllegalArgumentException("La edad no puede ser negativo");
        return age>=18;
    }

    public String createUsername(String name, int age){
        if(!isValidName(name)) throw new IllegalArgumentException("El nombre no es valido");

        if(age<0) throw new IllegalArgumentException("La edad no puede ser nagativa");

        return name.trim().toLowerCase()+"_"+age;
    }
}
