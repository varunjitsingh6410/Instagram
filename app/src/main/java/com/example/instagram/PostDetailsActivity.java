package com.example.instagram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Parcel;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.instagram.models.Post;
import com.parse.ParseFile;

import org.parceler.Parcels;

public class PostDetailsActivity extends AppCompatActivity {

    ImageView ivImageDetails;
    TextView tvUsernameDetails;
    TextView tvCaptionDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_details);

        ivImageDetails = findViewById(R.id.ivImageDetails);
        tvUsernameDetails = findViewById(R.id.tvUsernameDetails);
        tvCaptionDetails = findViewById(R.id.tvCaptionDetails);

        Post post = Parcels.unwrap(getIntent().getParcelableExtra("post"));

        tvUsernameDetails.setText(post.getUser().getUsername());
        tvCaptionDetails.setText(post.getDescription());

        ParseFile image = post.getImage();
        if (image != null)
        {
            Glide.with(getApplicationContext()).load(image.getUrl()).into(ivImageDetails);
        }
    }
}