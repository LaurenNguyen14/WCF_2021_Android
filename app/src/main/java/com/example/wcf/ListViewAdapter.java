package com.example.wcf;


import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class ListViewAdapter extends ArrayAdapter<Event> {
    //the event list that will be displayed
    private List<Event> eventList;

    //the context object
    private Context mCtx;

    //here we are getting the eventList and context
    //so while creating the object of this adapter class we need to give eventList and context
    public ListViewAdapter(List<Event> eventList, Context mCtx) {
        super(mCtx, R.layout.list_items, eventList);
        this.eventList = eventList;
        this.mCtx = mCtx;
    }

    //this method will return the list item
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //getting the layoutinflater
        LayoutInflater inflater = LayoutInflater.from(mCtx);

        //creating a view with our xml layout
        View listViewItem = inflater.inflate(R.layout.list_items, null, true);

        //getting text views
        TextView textViewName = listViewItem.findViewById(R.id.textViewEventName);
        TextView textViewDescription = listViewItem.findViewById(R.id.textViewDescription);
        TextView textViewDate = listViewItem.findViewById(R.id.textViewEventDate);

        RelativeLayout imageHolder = (RelativeLayout) listViewItem.findViewById(R.id.image_view_holder);
        //mageView img = new ImageView();

        //Getting the event for the specified position
        Event event = eventList.get(position);
        if(position==0){
            listViewItem.setBackgroundResource(R.color.colorInviteOnly);
            textViewDescription.setText(event.getDescription());
            textViewDescription.setTextColor(Color.rgb(255,255,255));
        }
        else if(position ==1){
           listViewItem.setBackgroundResource(R.color.colorEnvironmentDay);
        }
        else if(position==2){
           listViewItem.setBackgroundResource(R.color.colorCreativityDay);
        }
        else if(position==3){
           listViewItem.setBackgroundResource(R.color.colorPeaceDay);
        }
        else if(position==4){
            listViewItem.setBackgroundResource(R.color.colorInviteOnly);
            textViewDescription.setText(event.getDescription());
            textViewDescription.setTextColor(Color.rgb(255,255,255));
        }
        //setting event values to textviews
        textViewName.setText(event.getEventname());

        textViewName.setTextColor(Color.rgb(255,255,255));

        textViewDate.setText(event.getDate());
        textViewDate.setTextColor(Color.rgb(255,255,255));

        //textViewDescription.setText(event.getDescription());
        //textViewDescription.setTextColor(Color.rgb(255,255,255));

        //returning the listitem

        return listViewItem;
    }
    public Event getItem(int position){

        return eventList.get(position);
    }
}

