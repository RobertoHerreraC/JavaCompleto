package com.roberto.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {
    private UserService userService;

    @BeforeEach
    void setUp(){
        userService = new UserService();
    }

    @Test
    void shouldReturnTrueWhenIsValid(){
        String name = "Roberto";
        boolean result = userService.isValidName(name);

        assertTrue(result, "El nombre deberia ser valido");
    }

    @Test
    void shouldReturnFalseWhenNameIsNull(){
        String name = null;
        boolean result = userService.isValidName(name);

        assertFalse(result, "Un nombre null no deberia ser valido");
    }

    @Test
    void shouldReturnFalseWhenNameIsEmpty(){
        String name = "  ";
        boolean result = userService.isValidName(name);
        assertFalse(result, "Un nombre vacio no deberia ser valido");
    }

    @Test
    void shouldReturnTrueWhenAgeIsEighteen(){
        int age = 18;
        boolean result = userService.isAdult(age);
        assertTrue(result, "Una persona de 18 años deberia ser adulta");
    }

    @Test
    void shouldReturnFalseWhenAgeIsLessThanEighteen(){
        int age = 17;
        boolean result = userService.isAdult(age);
        assertFalse(result, "Una persona menor de 18 no deberia ser adulta");
    }

    @Test
    void shouldThrowExceptionWhenAgeIsNegative(){
        int age = -1;
        assertThrows(IllegalArgumentException.class,()->
                userService.isAdult(age),
                "Una edad negativa deberia lanzar exception");
    }

    @Test
    void shouldCreateUsernameCorrectly(){
        String name = "Roberto";
        int age = 28;

        String result = userService.createUsername(name, age);

        assertEquals("roberto_28",result);
    }

    @Test
    void shouldThrowExceptionWhenCreatingUsernameWithInvalidName(){
        String name = "A";
        int age = 28;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,()->
                userService.createUsername(name, age));

        assertEquals("El nombre no es valido",exception.getMessage());
    }
}
