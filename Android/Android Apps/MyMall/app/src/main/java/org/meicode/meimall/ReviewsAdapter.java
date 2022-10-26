package org.meicode.meimall;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ReviewsAdapter extends RecyclerView.Adapter<ReviewsAdapter.ViewHolder> {

    private ArrayList<Review> reviews = new ArrayList<>();

    public ReviewsAdapter() {
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.reviews_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtReview.setText(reviews.get(position).getText());
        holder.txtDate.setText(reviews.get(position).getDate());
        holder.txtUserName.setText(reviews.get(position).getUserName());
    }

    @Override
    public int getItemCount() {
        return reviews.size();
    }

    public void setReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView txtUserName, txtReview, txtDate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtReview = itemView.findViewById(R.id.txtReview);
            txtUserName = itemView.findViewById(R.id.txtUserName);
            txtDate = itemView.findViewById(R.id.txtDate);
        }
    }
}
