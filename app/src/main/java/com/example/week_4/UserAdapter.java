package com.example.week_4;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<User> userList;
    private Context context;
    private final int VIEW_TYPE_NORMAL = 0;
    private final int VIEW_TYPE_7 = 1;

    public UserAdapter(ArrayList<User> userList, Context context){

        this.userList = userList;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position){
        if (userList.get(position).getName().endsWith("7")){
            return VIEW_TYPE_7;
        } else return VIEW_TYPE_NORMAL;
    }

    //private View.OnClickListener mOnClickListener;
    //@NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        switch(viewType) {
            case VIEW_TYPE_NORMAL: {
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
                return new NormalViewHolder(view);
            }
            case VIEW_TYPE_7: {
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user7, parent, false);
                return new SpecialViewHolder(view);
            }

        }

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch(holder.getItemViewType()){
            case VIEW_TYPE_NORMAL: {
                NormalViewHolder normalViewHolder = (NormalViewHolder) holder;
                String name = userList.get(position).getName();
                String description = userList.get(position).getDescription();
                normalViewHolder.name.setText(name);
                normalViewHolder.description.setText(description);
                break;
            }

            case VIEW_TYPE_7:{
                SpecialViewHolder specialViewHolder = (SpecialViewHolder) holder;
                String name = userList.get(position).getName();
                String description = userList.get(position).getDescription();
                specialViewHolder.name.setText(name);
                specialViewHolder.description.setText(description);
                break;
            }

        }

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    // end with 7 layout
    class SpecialViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView name;
        public TextView description;
        public SpecialViewHolder(View itemView){
            super(itemView);
            name = itemView.findViewById(R.id.textName);
            description= itemView.findViewById(R.id.textDescription);
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                User user = userList.get(position);
                showAlertDialog(user);
            }
        }
    }

    // normal layout
    class NormalViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView name;
        public TextView description;
        public NormalViewHolder(View itemView){
            super(itemView);
            name = itemView.findViewById(R.id.textName);
            description= itemView.findViewById(R.id.textDescription);
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                User user = userList.get(position);
                showAlertDialog(user);
            }
        }
    }

    private void showAlertDialog(User user) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Profile")
                .setMessage(user.getName())
                .setPositiveButton("View", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Open user profile activity
                        // Replace UserProfileActivity.class with your actual activity class
                        Intent intent = new Intent(context, MainActivity.class);
                        // Pass any necessary data to the profile activity using intent extras
                        intent.putExtra("USERNAME", user.getName());
                        intent.putExtra("DESCRIPTION", user.getDescription());
                        context.startActivity(intent);
                    }
                })
                .setNegativeButton("Close", null)
                .show();
    }
}
