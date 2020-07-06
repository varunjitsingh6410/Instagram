package com.example.instagram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.instagram.models.Post;

import org.parceler.Parcels;

public class ProfileActivity extends AppCompatActivity {

    TextView tvProfileUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        tvProfileUsername = findViewById(R.id.tvProfileUserName);
        final Post post = Parcels.unwrap(getIntent().getParcelableExtra("post2"));
        tvProfileUsername.setText(post.getUser().getUsername());
    }
}