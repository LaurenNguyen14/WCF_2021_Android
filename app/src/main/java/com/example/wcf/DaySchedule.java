package com.example.wcf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.wcf.ui.home.HomeFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DaySchedule extends AppCompatActivity {
    ListView eventsView;
    List events = new ArrayList<>();
    ArrayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_schedule);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        eventsView = (ListView)findViewById(R.id.listview);
        Intent i = getIntent();
        Bundle bundle = getIntent().getExtras();
        if (bundle!=null){
            events = bundle.getStringArrayList("listactivities1");
            //actName.setText(bundle.getString("EventName"));
        }

        adapter = new ArrayAdapter(DaySchedule.this ,android.R.layout.simple_list_item_1,events);
        eventsView.setAdapter(adapter);
/*
        events.add("Culkin Irish Dancers");
        events.add("Lucas Taleshi Stratman");
        events.add("Latin American Youth Center");
        events.add("Tree Theater Group (Malaysia)");
        events.add("Minor Kings (Virginia)");
        events.add("Stephanie Marie Hanvey (New Jersey)");
        events.add("Morgan Book (Kentucky)");
        events.add("Ant Hill Live! (Georgia)");
        events.add("My Favorite Sport: Music, Dance, and Drama (Uganda)");
        events.add("The Change Makers (Nigeria)");
        events.add("Tajikistan National Dance (Tajikistan)");
        events.add("Minor Kings (Virginia)");
        events.add("Peace Mission Dance Group (Korea)");
        events.add("South Shore Drill Team & Performing Arts Ensemble (Illinois)");
        events.add("Fraternidad Tinkus San Simon (Bolivia)");
        events.add("Think out loud, Grace Yang (New York)");
        events.add("Latvian Ceramics, Elita Teilane, Balvi Art Schools (Latvia)");
        events.add("Kids4Peace Paper Beading Workshop, Nereus Patrick Cheo (Cameroon)");
        events.add("World Child Symbol, Marijn Van Oosten (Netherlands)");
        events.add("Postcards from Space: The Legacy of NASA’s Space Shuttle, Rebecca Jamilla (Virginia)");
        events.add("Children Around The World, Rabab Nawar (Egypt)");
        events.add("ICAF Creation App, Look-Listen, Kit Hughes (Georgia)");


        HomeFragment.adapter = new ArrayAdapter(DaySchedule.this ,android.R.layout.simple_list_item_1,HomeFragment.events);
        eventsView.setAdapter(HomeFragment.adapter);
*/

        eventsView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(DaySchedule.this, EventDetail.class);
                intent.putExtra("EventName", eventsView.getItemAtPosition(position).toString());
                startActivity(intent);
            }
        });



    }
}