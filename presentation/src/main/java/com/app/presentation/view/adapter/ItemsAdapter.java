package com.app.presentation.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.presentation.R;
import com.app.presentation.component.ImageHelper;
import com.app.presentation.model.ItemDetailModel;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Adaptar that manages item collection of {@link ItemDetailModel }.
 */
public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ItemViewHolder> {

    public interface OnItemClickListener {
        void onItemClicked();
    }

    private List<ItemDetailModel> itemDetailModels;
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
        final ItemDetailModel model = this.itemDetailModels.get(position);
        holder.tvTitle.setText(model.getTitle());
        holder.tvDes.setText(Html.fromHtml(model.getDescription()));
        holder.tvPrice.setText(model.getPrice().toString());
        ImageHelper.setImage(holder.view.getContext(), model.getImageUrl(), holder.ivImage);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ItemsAdapter.this.onItemClickListener != null) {
                    ItemsAdapter.this.onItemClickListener.onItemClicked();
                }
            }
        });
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void setSearchResults(List<ItemDetailModel> itemDetailModels) {
        this.validateCollection(itemDetailModels);
        this.itemDetailModels = itemDetailModels;
        this.notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    private void validateCollection(List<ItemDetailModel> itemDetailModels) {
        if (itemDetailModels == null) {
            throw new IllegalArgumentException("The list cannot be null");
        }
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        View view;

        @BindView(R.id.title)
        TextView tvTitle;
        @BindView(R.id.des)
        TextView tvDes;
        @BindView(R.id.price)
        TextView tvPrice;
        @BindView(R.id.image)
        ImageView ivImage;

        ItemViewHolder(View itemView) {
            super(itemView);
            this.view = itemView;
            ButterKnife.bind(this, itemView);
        }
    }
}
