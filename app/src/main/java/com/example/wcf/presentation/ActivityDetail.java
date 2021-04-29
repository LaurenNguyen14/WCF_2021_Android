package com.example.wcf.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.wcf.R;

import java.util.Calendar;

//this class let user add activity to their calendar, needs to be refactor later

public class ActivityDetail extends AppCompatActivity {
    TextView actName;
    Button addCal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);



        actName = (TextView) findViewById(R.id.actName);
        addCal=(Button) findViewById(R.id.buttonCalendar);

        String name = getIntent().getStringExtra("ListViewClickedName");
        actName.setText(name);

        addCal.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                //change later with time of the event
                if(!actName.getText().toString().isEmpty()){
                    Calendar cal = Calendar.getInstance();
                    Intent intent = new Intent(Intent.ACTION_EDIT);
                    intent.setType("vnd.android.cursor.item/event");
                    intent.putExtra("beginTime", cal.getTimeInMillis());
                    intent.putExtra("allDay", true);
                    intent.putExtra("rule", "FREQ=YEARLY");
                    intent.putExtra("endTime", cal.getTimeInMillis()+60*60*1000);
                    intent.putExtra("title", actName.getText().toString());
                    startActivity(intent);
                }

            }
        });

    }
}