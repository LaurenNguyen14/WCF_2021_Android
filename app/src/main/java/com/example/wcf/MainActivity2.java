package com.example.wcf;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()) {
            case R.id.event:
                Intent intent1 = new Intent(MainActivity2.this,EventsActivity.class);
                startActivity(intent1);
                finish();
                return true;
            case R.id.connect:
                Intent intent2 = new Intent(MainActivity2.this, CheckConn.class);
                startActivity(intent2);
                finish();
                return true;
            case R.id.main:
                Intent intent3 = new Intent(MainActivity2.this,MainActivity2.class);
                startActivity(intent3);
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}