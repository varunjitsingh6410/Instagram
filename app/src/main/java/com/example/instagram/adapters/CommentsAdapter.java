package com.example.instagram.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.instagram.R;
import com.example.instagram.models.Comment;
import com.example.instagram.models.Post;

import java.util.List;

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.ViewHolder> {
    private Context context;
    private List<Comment> comments;

    public CommentsAdapter(Context context, List<Comment> comments)
    {
        this.context = context;
        this.comments = comments;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_comment, parent, false);
        return new CommentsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Comment comment = comments.get(position);
        holder.bind(comment);
    }

    @Override
    public int getItemCount() {
        //return comments.size();
        return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder
    {
        RelativeLayout commentsContainer;
        ImageView ivCommenterAvatar;
        TextView tvComment;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            commentsContainer = itemView.findViewById(R.id.commentsContainer);
            ivCommenterAvatar = itemView.findViewById(R.id.ivCommenterAvatar);
            tvComment = itemView.findViewById(R.id.tvComment);
        }

        public void bind(Comment comment) {
            tvComment.setText("Potato");
        }
    }
}
