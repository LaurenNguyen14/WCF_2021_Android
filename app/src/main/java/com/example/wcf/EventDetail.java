package com.example.wcf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Calendar;

public class EventDetail extends AppCompatActivity {
    TextView actName;
    Button addCal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);



        actName = (TextView) findViewById(R.id.actName);
        addCal=(Button) findViewById(R.id.buttonCalendar);

        Bundle bundle = getIntent().getExtras();
        if (bundle!=null){
            actName.setText(bundle.getString("EventName"));
        }

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
                    intent.putExtra("rrule", "FREQ=YEARLY");
                    intent.putExtra("endTime", cal.getTimeInMillis()+60*60*1000);
                    intent.putExtra("title", actName.getText().toString());
                    startActivity(intent);
                }

            }
        });

    }
}