package com.example.wcf;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

//home page with festival in 3 days

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //the URL having the json data
   // private static final String JSON_URL = "http://192.168.86.69:7777/wcf/event.php";

    private static final String JSON_URL = "http://192.168.64.2//test_android/event.php";
    //listview object
    ListView listView;

    //the hero list where we will store all the hero objects after parsing json
    List<Event> heroList;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        //initializing listview and hero list
        listView = (ListView) findViewById(R.id.listView);

        // whenever each item is clicked
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Getting listview click value into String variable.
                //Object listItem = listView.getItemAtPosition(position);
                //String selected = ((TextView) view.findViewById(R.id.textViewEventName)).getText().toString();


                //put item clicked id to Day Schedule class
                Intent intent = new Intent(HomeActivity.this, DayScheduleActivity.class);
                //based on item add info to intent
                intent.putExtra("ListViewClickedValue", position);

                startActivity(intent);


            }
        });
        heroList = new ArrayList<>();

        //this method will fetch and parse the data
        loadHeroList();

        Toolbar toolbar = findViewById(R.id.toolbar);
        
        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navmenu);
        navigationView.setItemIconTintList(null);
        toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(true);
        navigationView.setNavigationItemSelectedListener(this);
        toggle.syncState();

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
                            for (int i = 0; i < heroArray.length(); i++) {
                                //getting the json object of the particular index inside the array
                                JSONObject heroObject = heroArray.getJSONObject(i);

                                //creating a hero object and giving them the values from json object
                                Event hero = new Event(
                                        heroObject.getString("EventName"),
                                        heroObject.getString("Description"),
                                        heroObject.getString("EventDate")
                                );

                                //adding the hero to herolist
                                heroList.add(hero);
                            }

                            //creating custom adapter object
                            ListViewAdapter adapter = new ListViewAdapter(heroList, getApplicationContext());

                            //adding the adapter to listview
                            listView.setAdapter(adapter);

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

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.event:
                Intent intent1 = new Intent(HomeActivity.this, HomeActivity.class);
                startActivity(intent1);
                break;
            case R.id.connect:
                Intent intent2 = new Intent(HomeActivity.this, CheckConn.class);
                startActivity(intent2);
                break;
            case R.id.main:
                Intent intent3 = new Intent(HomeActivity.this, HomeActivityTest.class);
                startActivity(intent3);
                break;
        }
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}