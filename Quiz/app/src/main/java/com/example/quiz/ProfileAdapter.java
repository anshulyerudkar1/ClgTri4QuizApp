package com.example.quiz;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.quiz.databinding.RowLeaderboardsBinding;

import java.util.ArrayList;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ProfileViewHolder> {

    Context context;
    ArrayList<User> profileUser;

    public ProfileAdapter(Context context,ArrayList<User> profileUser) {
        this.context = context;
        this.profileUser = profileUser;
    }

    @NonNull
    @Override
    public ProfileViewHolder onCreateViewHolder(@NonNull ViewGroup parent,int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_profile,null);
        return new ProfileViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileViewHolder holder,int position) {
        final User user = profileUser.get(position);

        holder.textView1.setText(user.getName());
        holder.textView1.setText(user.getEmail());
        holder.textView1.setText(user.getPass());
        holder.profileImage.setImageURI(Uri.parse(user.getProfileImage()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,ProfileFragment.class);
                intent.putExtra("name",user.getName());
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return profileUser.size();
    }

    public class ProfileViewHolder extends RecyclerView.ViewHolder {

        public Object binding;
        TextView textView1,textView2,textView3;
        ImageView profileImage;
        Button sOutBtn;
        public ProfileViewHolder(@NonNull View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.nameBox);
            textView2 = itemView.findViewById(R.id.emailBox);
            textView3 = itemView.findViewById(R.id.passBox);
            profileImage = itemView.findViewById(R.id.profileImage);
            sOutBtn = itemView.findViewById(R.id.signOut);
        }
    }
}
