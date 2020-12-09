package com.example.wcf;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText resNum;
    private Button lgButton;
    private TextView register;

   /* static DBConnection db = new DBConnection();
    static Connection con = db.loadDB();
*/
    //php db
    String URL= "http://192.168.64.2//test_android/index.php";
    JSONParser jsonParser = new JSONParser();

    int i =0 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resNum = (EditText) findViewById(R.id.resNum);
        lgButton = (Button) findViewById(R.id.btnSignIn);
        register = (TextView) findViewById(R.id.register);

        lgButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                AttemptLogin attemptLogin = new AttemptLogin();
               // validate(resNum.getText().toString());
                attemptLogin.execute(resNum.getText().toString());
            }


        });

        register.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private class AttemptLogin extends AsyncTask<String, String, JSONObject>{
        public AttemptLogin() {
            super();
        }

        @Override
        protected void onPreExecute(){
            super.onPreExecute();
        }

        @Override
        protected JSONObject doInBackground(String... strings) {
            String resNum = strings[0];
            ArrayList params = new ArrayList();
            if(resNum.length()>0){
                params.add(new BasicNameValuePair("RegistrationNumber", resNum));
            }

            JSONObject json = jsonParser.makeHttpRequest(URL, "POST", params);
            return json;
        }

        protected void onPostExecute(JSONObject result){
            // dismiss the dialog once product deleted
            //Toast.makeText(getApplicationContext(),result,Toast.LENGTH_LONG).show();

            try {
                if (result != null) {
                    Toast.makeText(getApplicationContext(),result.getString("message"),Toast.LENGTH_LONG).show();
                    if(result.getInt("success")==1){
                        Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                        startActivity(intent);
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Unable to retrieve any data from server", Toast.LENGTH_LONG).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }


    }

}