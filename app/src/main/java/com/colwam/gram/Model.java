package com.colwam.gram;

public class Model {
    private String eventName;
    private int imageResourceId;

    public static final Model[] eventData = {
            new Model("at Kisii", R.drawable.babe),
            new Model("baby's birthday", R.drawable.babe1),
            new Model("collins wifey", R.drawable.wambo),
            new Model("collins babes", R.drawable.rose),
            new Model("colwam", R.drawable.colwam),
            new Model("hunnie", R.drawable.hunnie),
            new Model("sweery", R.drawable.hunnie),
            new Model("babes", R.drawable.hunnie)

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
