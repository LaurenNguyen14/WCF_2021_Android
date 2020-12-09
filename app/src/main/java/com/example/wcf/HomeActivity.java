package com.example.wcf;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {
   /** JSONParser jsonParser = new JSONParser();
    ArrayList<HashMap<String,String>> eventsList;
    private static String url = "http://192.168.64.2//test_android/event.php";

    JSONArray events = null;
    // JSON Node names
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";
    private static final String TAG_ID = "id";
    private static final String TAG_NAME = "eventName";
    private static final String TAG_DESCRIPTION = "description";
    private static final String TAG_LOCATION = "location";
    private static final String TAG_DATE = "eventDate";
    private static final String TAG_DAY = "dayOfEvent";

    private static final String TAG_EVENTS = "eventlist";*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_map, R.id.navigation_profile)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        //


    }
   /* class getEventList extends AsyncTask<String,String,String>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected String doInBackground(String... strings) {
            //building parameters
            List<NameValuePair> param = new ArrayList<>();
            //getting Json string from URL
            JSONObject json = jsonParser.makeHttpRequest(url, "GET", (ArrayList) param);
            //check log or response
            Log.d("All events: ", json.toString());
            try{
                //checking success
                int success = json.getInt(TAG_SUCCESS);
                if(success==1) {
                    events = json.getJSONArray(TAG_EVENTS);
                    //loop through all events
                    for (int i = 0; i < events.length(); i++) {
                        JSONObject c = events.getJSONObject(i);
                        //store json item in variable
                        String id = c.getString(TAG_ID);
                        String eventName = c.getString(TAG_NAME);
                        String eventDescription = c.getString(TAG_DESCRIPTION);
                        String eventDate = c.getString(TAG_DATE);
                        String eventLocation = c.getString(TAG_LOCATION);
                        String eventDay = c.getString(TAG_DAY);
                        //create hashmap
                        HashMap<String, String> map = new HashMap<String, String>();

                        map.put(TAG_ID, id);
                        map.put(TAG_NAME, eventName);
                        map.put(TAG_DESCRIPTION, eventDescription);
                        map.put(TAG_DATE, eventDate);
                        map.put(TAG_LOCATION, eventLocation);
                        map.put(TAG_DAY, eventDay);

                        eventsList.add(map);
                    }
                    return json.getString(TAG_MESSAGE);
                }
                else{
                    return json.getString(TAG_MESSAGE);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            if(s!=null){
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ListAdapter adapter = new SimpleAdapter(HomeActivity.this, eventsList,R.layout.activity_home, new String[]{
                                TAG_NAME}, new int[]  {R.id.textView});
                        //setListAdapter(adapter);
                        }

                });
            }
        }
    }*/

}