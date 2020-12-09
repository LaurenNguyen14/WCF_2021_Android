package com.example.wcf;

public class Event {
    String eventname, description,location;

    public Event(String name, String description) {
        this.eventname = name;
        this.description = description;

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
}
