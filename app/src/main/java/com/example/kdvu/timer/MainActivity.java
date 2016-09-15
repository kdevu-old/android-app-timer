package com.example.kdvu.timer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Layout
        RelativeLayout rLayout = new RelativeLayout(this);

        //Items for ListViews + list adapators
        String[] hourList = new String[24];
        String[] minList = new String[60];
        String[] secList = new String[60];

        fillArray(hourList); //From 0 to 23
        fillArray(minList); //From 1 to 59
        fillArray(secList); //From 1 to 59

        ListAdapter listA1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, hourList);
        ListAdapter listA2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, minList);
        ListAdapter listA3 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, secList);

        //ListViews + setting adapters + ids
        ListView hourView = new ListView(this);
        ListView minView = new ListView(this);
        ListView secView = new ListView(this);

        hourView.setAdapter(listA1);
        minView.setAdapter(listA2);
        secView.setAdapter(listA3);

        hourView.setId(R.id.hourView);
        minView.setId(R.id.minView);
        secView.setId(R.id.secView);

        //TextViews
        TextView topHeading = new TextView(this);
        TextView hourHeading = new TextView(this);
        TextView minHeading = new TextView(this);
        TextView secHeading = new TextView(this);

        //Set TextView text
        topHeading.setText("Select Time");
        topHeading.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 28);
        hourHeading.setText("Hour");
        minHeading.setText("Min");
        secHeading.setText("Sec");

        //Set TextView ids
        topHeading.setId(R.id.topHeading);
        hourHeading.setId(R.id.hourHeading);
        minHeading.setId(R.id.minHeading);
        secHeading.setId(R.id.secHeading);

        //Set size of widgets
        RelativeLayout.LayoutParams topHeadingDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams hourHeadingDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams minHeadingDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams secHeadingDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams hourViewDetails = new RelativeLayout.LayoutParams(100, 200);
        RelativeLayout.LayoutParams minViewDetails = new RelativeLayout.LayoutParams(100, 200);
        RelativeLayout.LayoutParams secViewDetails = new RelativeLayout.LayoutParams(100, 200);

        //Create rules for positioning
        topHeadingDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        topHeadingDetails.setMargins(10,10,10,10);

        minHeadingDetails.addRule(RelativeLayout.BELOW, topHeading.getId());
        minHeadingDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        minHeadingDetails.setMargins(100,0,100,10);

        hourHeadingDetails.addRule(RelativeLayout.BELOW, topHeading.getId());
        hourHeadingDetails.addRule(RelativeLayout.LEFT_OF, minHeading.getId());
        hourHeadingDetails.setMargins(0,0,0,20);

        secHeadingDetails.addRule(RelativeLayout.BELOW, topHeading.getId());
        secHeadingDetails.addRule(RelativeLayout.RIGHT_OF, minHeading.getId());
        secHeadingDetails.setMargins(0,0,0,20);

        minViewDetails.addRule(RelativeLayout.BELOW, hourHeading.getId());
        minViewDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        minViewDetails.setMargins(50,0,50,0);

        hourViewDetails.addRule(RelativeLayout.BELOW, hourHeading.getId());
        hourViewDetails.addRule(RelativeLayout.LEFT_OF, minView.getId());

        secViewDetails.addRule(RelativeLayout.BELOW, secHeading.getId());
        secViewDetails.addRule(RelativeLayout.RIGHT_OF, minView.getId());

        //Add views
        rLayout.addView(topHeading, topHeadingDetails);
        rLayout.addView(minHeading, minHeadingDetails);
        rLayout.addView(hourHeading, hourHeadingDetails);
        rLayout.addView(secHeading, secHeadingDetails);

        rLayout.addView(minView, minViewDetails);
        rLayout.addView(hourView, hourViewDetails);
        rLayout.addView(secView, secViewDetails);

        setContentView(rLayout);
    }

    public void fillArray(String[] array){
        for(int i = 0; i < array.length; i++){
            array[i] = String.valueOf(i);
        }
    }
}
