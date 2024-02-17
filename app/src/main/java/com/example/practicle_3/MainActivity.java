package com.example.practicle_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText u1,p1;
    @Override
    // (u1.getText().toString().contains("@gmail.com"))
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        u1 = (EditText) findViewById(R.id.username);
        p1 = (EditText) findViewById(R.id.password);
        Button b = (Button) findViewById(R.id.submit);
        b.setEnabled(false);

        String email_pattern = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        String validPassword = "vidhi";

        p1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                String username = u1.getText().toString();
                boolean isValidUsername = username.matches(email_pattern);
                boolean isValidPassword = p1.getText().toString().equals(validPassword);
                b.setEnabled(isValidUsername && isValidPassword);
            }
        });

        u1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                String username = u1.getText().toString();
                boolean isValidUsername = username.matches(email_pattern);
                boolean isValidPassword = p1.getText().toString().equals(validPassword);
                b.setEnabled(isValidUsername && isValidPassword);
            }
        });

        u1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    if(u1.getText().toString().equals(""))
                    {
                        u1.setBackgroundColor(Color.parseColor("#FF0000"));
                    }
                    else
                    {
                        if(u1.getText().toString().matches(email_pattern)) {
                            u1.setBackgroundColor(Color.parseColor("#008000"));

                        }
                        else {
                            u1.setBackgroundColor(Color.parseColor("#FF0000"));
                            Toast.makeText(getApplicationContext(),"Email Pattern is wrong",Toast.LENGTH_LONG).show();
                        }
                    }
                }else{
                    u1.setBackgroundColor(Color.parseColor("#FFFFFF"));
                }
            }
        });

        p1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    if(p1.getText().toString().equals(""))
                    {
                        p1.setBackgroundColor(Color.parseColor("#FF0000"));
                    }
                    else
                    {
                        if(p1.getText().toString().equals("vidhi")) {
                            p1.setBackgroundColor(Color.parseColor("#008000"));

                        }
                        else {
                            p1.setBackgroundColor(Color.parseColor("#FF0000"));
                        }
                    }
                }else{
                    p1.setBackgroundColor(Color.parseColor("#FFFFFF"));
                }
            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String un = u1.getText().toString();
                String ps = p1.getText().toString();
                if(un.equals("vidhi@gmail.com") && (ps.equals("vidhi"))){
                    Toast.makeText(MainActivity.this,"Login Successfully",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                    intent.putExtra("Username", u1.getText().toString());
                    startActivity(intent);
                }
                else{
                    Toast.makeText(MainActivity.this,"Enter Valid Username and Password",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}