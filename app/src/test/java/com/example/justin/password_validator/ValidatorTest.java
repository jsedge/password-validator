package com.example.justin.password_validator;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by justin on 07/02/18.
 */

public class ValidatorTest {

    static Validator validator;

    @BeforeClass
    public static void init() {
        validator = new Validator();
    }

    @Test
    public void notPassword() {
        assertFalse(validator.Validate("password"));
    }

    @Test
    public void checkLength(){
        assertFalse(validator.Validate("a"));
    }

    @Test
    public void tooShort(){
        assertFalse(validator.Validate("Short1"));
    }
    @Test
    public void validPassword(){
        assertTrue(validator.Validate("Thisisagoodpassword123"));
    }

    @Test
    public void allUpper(){
        assertFalse(validator.Validate("AAAAAAAAA"));
    }

    @Test
    public void allLower(){
        assertFalse(validator.Validate("aaaaaaaaaaaaaa"));
    }

    @Test
    public void noNumbers(){
        assertFalse(validator.Validate("ThisShouldHaveNumbers"));
    }

    @Test
    public void tooLong(){
        assertFalse(validator.Validate("ThisHasWayTooManyCharactersForItToBeAUsablePassword4000"));
    }
}
