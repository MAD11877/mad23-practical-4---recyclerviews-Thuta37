package com.example.week_4;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        User user = new User();
        user.setFollowed(false);

        Intent receivingEnd = getIntent();
        int randomInt = receivingEnd.getIntExtra("Random integer", 0);

        TextView myText =(TextView) findViewById(R.id.textView);
        String message = "MAD " + randomInt;
        myText.setText(message);
    }

    boolean followed = false;
    public void onFollowClick (View v){
        if (followed) {
            Toast.makeText(getBaseContext(),"Unfollowed", Toast.LENGTH_SHORT).show();
            Button button = (Button) findViewById(R.id.btnFollow);
            button.setText("Follow");
            followed = false;

        } else {
            Toast.makeText(getBaseContext(),"Followed", Toast.LENGTH_SHORT).show();
            Button button = (Button) findViewById(R.id.btnFollow);
            button.setText("Unfollow");
            followed = true;
        }
    }

    public void onMessageClick (View v) {
        Intent nextActivity = new Intent(MainActivity.this, MessageGroup.class);
        startActivity(nextActivity);
    }

}