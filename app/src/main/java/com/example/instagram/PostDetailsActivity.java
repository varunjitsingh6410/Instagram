package com.example.instagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.instagram.adapters.CommentsAdapter;
import com.example.instagram.models.Comment;
import com.example.instagram.models.Post;
import com.parse.ParseFile;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

public class PostDetailsActivity extends AppCompatActivity {

    ImageView ivImageDetails;
    TextView tvUsernameDetails;
    TextView tvCaptionDetails;

    TextView tvTimeStampDetails;

    Button btnComment;
    EditText etWriteComment;

    RecyclerView rvComments;

    CommentsAdapter commentsAdapter;
    protected List<Comment> allComments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_details);

        ivImageDetails = findViewById(R.id.ivImageDetails);
        tvUsernameDetails = findViewById(R.id.tvUsernameDetails);
        tvCaptionDetails = findViewById(R.id.tvCaptionDetails);

        tvTimeStampDetails = findViewById(R.id.tvTimeStampDetails);

        btnComment = findViewById(R.id.btnComment);
        etWriteComment = findViewById(R.id.etWriteComment);
        rvComments = findViewById(R.id.rvComments);

        commentsAdapter = new CommentsAdapter(getApplicationContext(), allComments);
        rvComments.setAdapter(commentsAdapter);
        rvComments.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        allComments = new ArrayList<>();

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
                i.putExtra("user", Parcels.wrap(post.getUser()));
                startActivity(i);
            }
        });
    }
}