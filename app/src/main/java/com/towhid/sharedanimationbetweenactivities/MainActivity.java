package com.towhid.sharedanimationbetweenactivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    CardView cardView;
    ImageView image;
    TextView title,desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cardView = findViewById(R.id.cardview);

        image = findViewById(R.id.image);
        title = findViewById(R.id.title);
        desc = findViewById(R.id.desc);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,SharedActivity.class);
                Pair[] pairs = new Pair[3];

                pairs[0]=new Pair<View,String>(image,"imageTransition");
                pairs[1]=new Pair<View,String>(title,"titleTransition");
                pairs[2]=new Pair<View,String>(desc,"deseTransition");

                ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,pairs);
                startActivity(intent,activityOptions.toBundle());

            }
        });
    }
}