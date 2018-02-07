package com.example.justin.password_validator;

/**
 * Created by justin on 07/02/18.
 */

public class Validator {
    public boolean Validate(String pass){
        if(pass.equals("password")){//rule 1: can not be "password"
            return false;
        }else if(pass.length()<8){//rule 2: must be at least 8 characters
            return false;
        }else if(pass.toLowerCase().equals(pass)||pass.toUpperCase().equals(pass)){
            //rule 3: must contain at least one upper and lower case
            return false;
        }else if(!pass.matches(".*[0-9].*")){
            //rule 4: must contain at least one number
            return false;
        }else if(pass.length()>32){
            //rule 5: must be less than 33 characters
            return false;
        }

        return true;
    }
}
