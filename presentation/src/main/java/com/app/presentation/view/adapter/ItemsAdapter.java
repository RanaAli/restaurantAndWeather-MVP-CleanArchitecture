package com.app.presentation.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.app.presentation.R;
import com.app.presentation.component.ImageHelper;
import com.app.presentation.model.restaurants.RestaurantUIModel;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Adaptar that manages item collection of {@link RestaurantUIModel }.
 */
public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ItemViewHolder> {

    public interface OnItemClickListener {
        void onItemClicked();
    }

    private List<RestaurantUIModel> itemDetailModels;
    private final LayoutInflater layoutInflater;

    private OnItemClickListener onItemClickListener;

    @Inject
    ItemsAdapter(Context context) {
        this.layoutInflater =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.itemDetailModels = Collections.emptyList();
    }

    @Override
    public int getItemCount() {
        return (this.itemDetailModels != null) ? this.itemDetailModels.size() : 0;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = this.layoutInflater.inflate(R.layout.row_item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, final int position) {
        final RestaurantUIModel model = this.itemDetailModels.get(position);
        holder.tvTitle.setText(model.getName());
        holder.tvLocation.setText(Html.fromHtml(model.getLocation()));
        holder.tvCuisine.setText(model.getCuisine());
        holder.tvRating.setText(model.getRating());
        holder.tvReviewNumber.setText(model.getRating());
        holder.ratingBar.setRating(Float.parseFloat(model.getRating()));
        holder.tvReviewNumber.setText(model.getNumberOfReviews());
        ImageHelper.setImage(holder.view.getContext(), model.getImageUrl(), holder.ivImage);

        holder.itemView.setOnClickListener(v -> {
            if (ItemsAdapter.this.onItemClickListener != null) {
                ItemsAdapter.this.onItemClickListener.onItemClicked();
            }
        });
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void setSearchResults(List<RestaurantUIModel> restaurantUIModels) {
        this.validateCollection(restaurantUIModels);
        this.itemDetailModels = restaurantUIModels;
        this.notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    private void validateCollection(List<RestaurantUIModel> restaurantUIModels) {
        if (restaurantUIModels == null) {
            throw new IllegalArgumentException("The list cannot be null");
        }
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        View view;

        @BindView(R.id.title)
        TextView tvTitle;
        @BindView(R.id.des)
        TextView tvDes;
        @BindView(R.id.location)
        TextView tvLocation;
        @BindView(R.id.cuisine)
        TextView tvCuisine;
        @BindView(R.id.rating)
        TextView tvRating;
        @BindView(R.id.reviewNumber)
        TextView tvReviewNumber;
        @BindView(R.id.review)
        TextView tvReview;
        @BindView(R.id.ratingBar)
        RatingBar ratingBar;
        @BindView(R.id.image)
        ImageView ivImage;

        ItemViewHolder(View itemView) {
            super(itemView);
            this.view = itemView;
            ButterKnife.bind(this, itemView);
        }
    }
}
