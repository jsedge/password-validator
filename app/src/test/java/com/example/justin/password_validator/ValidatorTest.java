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
    public void validPassword(){
        assertTrue(validator.Validate("thisisagoodpassword"));
    }
}
