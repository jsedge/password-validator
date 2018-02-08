package com.example.justin.password_validator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void checkPassword(View view){
        EditText input = findViewById(R.id.passBox);
        String password = input.getText().toString();
        TextView output = findViewById(R.id.output);

        Validator validator = new Validator();

        if(validator.Validate(password)){
            output.setText("Valid Password");
        }else{
            output.setText("Invalid Password");
        }


    }
}
