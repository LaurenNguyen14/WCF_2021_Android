package com.example.wcf;

//this class represent the activity schedule of a day

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DayScheduleActivity extends AppCompatActivity {
    //ListView eventsView;
    //List events = new ArrayList<>();
    //ArrayAdapter adapter;
    private static final String JSON_URL = "http://192.168.64.2//test_android/activities.php";

    //listview object
    ListView activityListView;

    //the hero list where we will store all the hero objects after parsing json
    List<DayActivityModel> heroListActivities;

    Integer EventId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_schedule);

        activityListView = findViewById(R.id.listviewActivity);

        // Receiving clicked value from home activity into activity using intent.
        EventId = getIntent().getIntExtra("ListViewClickedValue",-1) +1;

        //check event day position, event position + 1 = event id in database
        System.out.println("clicked: " + EventId);



        heroListActivities = new ArrayList<>();

        //this method will fetch and parse the data
        loadHeroList();


    }
    private void loadHeroList() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, JSON_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    System.out.println(response);
                    JSONArray jsonArray = new JSONArray(response);

                    //now looping through all the elements of the json array
                    for (int i = 0; i < jsonArray.length(); i++) {
                        //getting the json object of the particular index inside the array
                        JSONObject heroObject =jsonArray.getJSONObject(i);

                        //creating a hero object and giving them the values from json object
                        DayActivityModel hero = new DayActivityModel(
                                heroObject.getString("Name"),
                                heroObject.getString("Description"),
                                heroObject.getString("FromTime"),
                                heroObject.getString("ToTime")
                        );

                        //adding the hero to herolist
                        heroListActivities.add(hero);
                        System.out.println("herolist activities size: "+ heroListActivities.size());
                    }

                    //creating custom adapter object
                    ListActivityAdapter activityAdapter = new ListActivityAdapter(heroListActivities, getApplicationContext());

                    //adding the adapter to listview
                    activityListView.setAdapter(activityAdapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(DayScheduleActivity.this, error.toString(), Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("EventId", EventId.toString());
                return params;
            }
        };


        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}