package com.example.week_4;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    User user = new User();
    boolean followed = user.getFollowed();

    public void onFollowClick(View v) {
        if (followed) {
            Toast.makeText(getBaseContext(), "Unfollowed", Toast.LENGTH_SHORT).show();
            Button button = (Button) findViewById(R.id.btnFollow);
            button.setText("FOLLOW");
            followed = false;
        } else {
            Toast.makeText(getBaseContext(), "Followed", Toast.LENGTH_SHORT).show();
            Button button = (Button) findViewById(R.id.btnFollow);
            button.setText("UNFOLLOW");
            followed = true;
        }

    }

    public void onMessageClick(View v) {
        // MainActivity to MessageGroup
        Intent intent = new Intent(MainActivity.this, MessageGroup.class);
        startActivity(intent);
    }

    protected void onResume() {
        super.onResume();
        // receive data from ListActivity
        Intent intent = getIntent();
        String name = intent.getStringExtra("USERNAME");
        String description = intent.getStringExtra("DESCRIPTION");
        TextView nametext = findViewById(R.id.textView);
        TextView descriptiontext = findViewById(R.id.textView2);
        nametext.setText(name);
        descriptiontext.setText(description);

    }
}