package com.example.justin.password_validator;

/**
 * Created by justin on 07/02/18.
 */

public class Validator {
    public boolean Validate(String pass){
        if(pass.equals("password")){
            return false;
        }else if(pass.length()<8){
            return false;
        }

        return true;
    }
}
