package com.example.wcf;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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
        TextView textViewImageUrl = listViewItem.findViewById(R.id.textViewDescription);

        //Getting the event for the specified position
        Event event = eventList.get(position);

        //setting event values to textviews
        textViewName.setText(event.getEventname());
        textViewImageUrl.setText(event.getDescription());

        //returning the listitem
        return listViewItem;
    }
}

