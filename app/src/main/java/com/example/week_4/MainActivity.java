package com.example.week_4;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        User user1 = new User();
        user1.setFollowed(false);

        Intent receivingEnd = getIntent();
        int randomInt = receivingEnd.getIntExtra("Random integer", 0);

        TextView myText =(TextView) findViewById(R.id.textView);
        String message = "MAD " + randomInt;
        myText.setText(message);

        findViewById(R.id.btnFollow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user1.getFollowed()) {
                    Toast.makeText(getBaseContext(),"Unfollowed", Toast.LENGTH_SHORT).show();
                    Button button = (Button) findViewById(R.id.btnFollow);
                    button.setText("Follow");
                    user1.setFollowed(false);
                }

                else {
                    Toast.makeText(getBaseContext(),"Followed", Toast.LENGTH_SHORT).show();
                    Button button = (Button) findViewById(R.id.btnFollow);
                    button.setText("Unfollow");
                    user1.setFollowed(true);
                }
            }
        });

        findViewById(R.id.btnMessage).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextActivity = new Intent(MainActivity.this, MessageGroup.class);
                startActivity(nextActivity);
            }
        });
    }

}