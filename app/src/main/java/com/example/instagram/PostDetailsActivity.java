package com.example.instagram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.view.View;
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

    TextView tvTimeStampDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_details);

        ivImageDetails = findViewById(R.id.ivImageDetails);
        tvUsernameDetails = findViewById(R.id.tvUsernameDetails);
        tvCaptionDetails = findViewById(R.id.tvCaptionDetails);

        tvTimeStampDetails = findViewById(R.id.tvTimeStampDetails);

        final Post post = Parcels.unwrap(getIntent().getParcelableExtra("post"));

        tvUsernameDetails.setText(post.getUser().getUsername());
        tvCaptionDetails.setText(post.getDescription());

        String date = post.getCreatedAt().toString();
        StringBuilder dateFormat = new StringBuilder(date);
        tvTimeStampDetails.setText(dateFormat.delete(10, 23).toString());

        ParseFile image = post.getImage();
        if (image != null)
        {
            Glide.with(getApplicationContext()).load(image.getUrl()).into(ivImageDetails);
        }

        tvUsernameDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ProfileActivity.class);
                i.putExtra("post2", Parcels.wrap(post));
                startActivity(i);
            }
        });
    }
}