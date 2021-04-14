package com.example.wcf.presentation.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.wcf.R;
import com.example.wcf.models.DayActivity;

import java.util.List;

public class ListActivityAdapter extends ArrayAdapter<DayActivity> {
    //the activity list that will be displayed
    private List<DayActivity> activitiesList;

    //the context object
    private Context mCtx;

    //here we are getting the activitylist and context
    //so while creating the object of this adapter class we need to give activity list and context
    public ListActivityAdapter(List<DayActivity> activitiesList, Context mCtx) {
        super(mCtx, R.layout.list_activities, activitiesList);
        this.activitiesList = activitiesList;
        this.mCtx = mCtx;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //getting the layoutinflater
        LayoutInflater inflater = LayoutInflater.from(mCtx);

        //creating a view with our xml layout
        View listViewActivities = inflater.inflate(R.layout.list_activities, null, true);

        //getting text views
        TextView textViewName = listViewActivities.findViewById(R.id.textViewActivityName);
        TextView textViewDescription = listViewActivities.findViewById(R.id.textViewActivityDescription);
        TextView textViewFromTime = listViewActivities.findViewById(R.id.textViewFromTime);
        TextView textViewToTime = listViewActivities.findViewById(R.id.textViewToTime);

        //RelativeLayout imageHolder = (RelativeLayout) listViewItem.findViewById(R.id.image_view_holder);
        //mageView img = new ImageView();

        DayActivity activity = activitiesList.get(position);

        textViewName.setText(activity.getActivityName());
        textViewName.setTextColor(Color.rgb(0,0,0));

        textViewDescription.setText(activity.getDescription());
        textViewName.setTextColor(Color.rgb(0,0,0));

        textViewFromTime.setText(activity.getTimeFrom());
        textViewName.setTextColor(Color.rgb(0,0,0));

        textViewToTime.setText(activity.getTimeTo());
        textViewName.setTextColor(Color.rgb(0,0,0));




        return listViewActivities;

    }
}
