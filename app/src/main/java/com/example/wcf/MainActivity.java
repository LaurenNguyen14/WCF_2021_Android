package com.example.wcf;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.wcf.presentation.HomeActivity;

public class MainActivity extends AppCompatActivity {
    //private EditText resNum;
    private Button lgButton;
    private TextView register;

    int i =0 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //resNum = (EditText) findViewById(R.id.resNum);
        lgButton = (Button) findViewById(R.id.btnSignIn);
        register = (TextView) findViewById(R.id.register);

        lgButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);

            }


        });

        register.setMovementMethod(LinkMovementMethod.getInstance());
    }

}