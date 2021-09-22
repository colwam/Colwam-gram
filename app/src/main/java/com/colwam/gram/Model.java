package com.colwam.gram;

public class Model {
    private String eventName;
    private int imageResourceId;

    public static final Model[] eventData = {
            new Model("collins visit", R.drawable.babe),
            new Model("collins love", R.drawable.babe1),
            new Model("collins wifey", R.drawable.swee),
            new Model("collins manenoz", R.drawable.swee1),

    };

    private Model(String eventName, int imageResourceId) {
        this.eventName = eventName;
        this.imageResourceId = imageResourceId;

    }

    public String getEventName() {
        return eventName;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}
