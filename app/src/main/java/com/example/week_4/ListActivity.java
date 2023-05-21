package com.example.week_4;

import static android.content.ContentValues.TAG;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);


    }


    public void onImageClick (View v) {
        showAlertDialog("MADness");
    }

    public void showAlertDialog(String message) {
        AlertDialog dialog = new AlertDialog.Builder(ListActivity.this)
                .setTitle("Profile")
                .setMessage(message)

                .setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();
                    }
                })

                .setPositiveButton("View", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Random random = new Random();
                        int randomNumber = random.nextInt();
                        Log.i(TAG, String.valueOf(randomNumber));
                        Intent nextActivity = new Intent(ListActivity.this, MainActivity.class);
                        nextActivity.putExtra("Random integer", randomNumber);
                        startActivity(nextActivity);
                        dialog.dismiss();
                    }
                })
               .create();
        dialog.show();
    }
}