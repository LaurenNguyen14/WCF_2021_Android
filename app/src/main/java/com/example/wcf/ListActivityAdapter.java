package com.example.wcf;

import android.content.Context;

import java.util.List;

public class ListActivityAdapter {
    //the activity list that will be displayed
    private List<DayActivityModel> activitiesList;

    //the context object
    private Context mCtx;

    //here we are getting the activitylist and context
    //so while creating the object of this adapter class we need to give activity list and context
    public ListActivityAdapter(List<DayActivityModel> activitiesList, Context mCtx) {
        super();
        this.activitiesList = activitiesList;
        this.mCtx = mCtx;
    }

}
