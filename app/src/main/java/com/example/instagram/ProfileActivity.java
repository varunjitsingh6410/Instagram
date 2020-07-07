package com.example.instagram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.instagram.models.Post;
import com.parse.ParseFile;
import com.parse.ParseUser;

import org.parceler.Parcels;

public class ProfileActivity extends AppCompatActivity {

    TextView tvProfileUsername;
    ImageView ivProfilePicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        tvProfileUsername = findViewById(R.id.tvProfileUserName);
        final ParseUser user = Parcels.unwrap(getIntent().getParcelableExtra("user"));

        tvProfileUsername.setText(user.getUsername());

        ParseFile profilePicture = user.getParseFile("Profile_Picture");
        if(profilePicture != null)
        {
            Log.d("ProfileActivity", "URL FOUND: " + profilePicture.getUrl());
        }
        else
            {
            Log.e("ProfileActivity", "NO URL");
        }

        if (profilePicture != null)
        {
            Glide.with(this).load(profilePicture.getUrl()).into(ivProfilePicture);
        }
        else
        {
            //Glide.with(this).load(R.drawable.ic_person_black_24dp).apply(new RequestOptions()).into(ivProfilePicture);
        }
    }
}