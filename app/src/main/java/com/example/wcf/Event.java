package com.example.wcf;

//information of big event
public class Event {
    String eventname, description,location,date;

    public Event(String name, String description, String date) {
        this.eventname = name;
        this.description = description;
        this.date=date;
    }

    public String getEventname() {
        return eventname;
    }

    public String getDescription() {
        return description;
    }
    public  String getLocation(){
        return location;
    }
    public String getDate(){return date;}
}
