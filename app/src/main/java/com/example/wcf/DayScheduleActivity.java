package com.example.wcf;

//this class represent the activity schedule of a day

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DayScheduleActivity extends AppCompatActivity {
    //ListView eventsView;
    //List events = new ArrayList<>();
    //ArrayAdapter adapter;
    private static final String JSON_URL = "http://192.168.64.2//test_android/activityIndex.php";

    //listview object
    ListView activityListView;

    //the hero list where we will store all the hero objects after parsing json
    List<DayActivityModel> heroList;
    int EventId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Receiving clicked value from home activity into activity using intent.
        EventId = getIntent().getIntExtra("ListViewClickedValue",-1);

        //check event day position, event position + 1 = event id in database
        System.out.println("clicked: " + EventId);

        setContentView(R.layout.activity_day_schedule);

        heroList = new ArrayList<>();

        //this method will fetch and parse the data
       loadHeroList();

    }

    private void loadHeroList() {
        //getting the progressbar
        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);

        //making the progressbar visible
        progressBar.setVisibility(View.VISIBLE);

        //creating a string request to send request to the url
        StringRequest stringRequest = new StringRequest(Request.Method.GET, JSON_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //hiding the progressbar after completion
                        progressBar.setVisibility(View.INVISIBLE);


                        try {
                            //getting the whole json object from the response

                            //we have the array named hero inside the object
                            //so here we are getting that json array
                            JSONArray heroArray = new JSONArray(response);

                            //now looping through all the elements of the json array
                            // only retrieve information if match event id
                            for (int i = 0; i < heroArray.length(); i++) {
                                //getting the json object of the particular index inside the array
                                JSONObject heroObject = heroArray.getJSONObject(i);

                                //creating a hero object and giving them the values from json object
                                DayActivityModel hero = new DayActivityModel(
                                        heroObject.getString("Name"),
                                        heroObject.getString("Description"),
                                        heroObject.getString("FromTime"),
                                        heroObject.getString("ToTime")
                                );

                                //adding the hero to herolist
                                heroList.add(hero);
                            }

                            //creating custom adapter object
                            ListActivityAdapter adapter = new ListActivityAdapter(heroList, getApplicationContext());

                            //adding the adapter to listview
                            //activityListView.setAdapter(adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //displaying the error in toast if occurrs
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

        //creating a request queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        //adding the string request to request queue
        requestQueue.add(stringRequest);
    }

}