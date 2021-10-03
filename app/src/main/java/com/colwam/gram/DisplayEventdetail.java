package com.colwam.gram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.widget.ImageView;

public class DisplayEventdetail extends AppCompatActivity {
    public static final String EXTRA_DATA_ID = "data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_eventdetail);

        //grab the content
        int picId = (Integer) getIntent().getExtras().get(EXTRA_DATA_ID);
        int testImage = Model.eventData[picId].getImageResourceId();
        ImageView imageView = (ImageView) findViewById(R.id.fullImage);
        imageView.setImageDrawable(ContextCompat.getDrawable(this,testImage));
        imageView.setContentDescription("cool image");
    }
}