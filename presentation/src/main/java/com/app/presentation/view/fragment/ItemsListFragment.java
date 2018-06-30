package com.app.presentation.view.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.app.presentation.R;
import com.app.presentation.internal.di.components.AppComponent;
import com.app.presentation.model.ItemDetailModel;
import com.app.presentation.model.Restaurants.RestaurantUIModel;
import com.app.presentation.presenter.ItemsListPresenter;
import com.app.presentation.view.ItemsListView;
import com.app.presentation.view.adapter.ItemsAdapter;
import com.app.presentation.view.adapter.ItemsLayoutManager;
import com.app.presentation.view.listeners.EndlessRecyclerViewScrollListener;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Fragment that shows list of Items
 */
public class ItemsListFragment extends BaseFragment implements ItemsListView {

    /**
     * Interface for listening item list events.
     */
    public interface ListListener {
        void onItemClicked();
    }

    @Inject
    ItemsListPresenter itemsListPresenter;
    @Inject
    ItemsAdapter itemsAdapter;

    @BindView(R.id.rv_items)
    RecyclerView rv_items;
    @BindView(R.id.rl_progress)
    RelativeLayout rl_progress;
    @BindView(R.id.rl_retry)
    RelativeLayout rl_retry;
    @BindView(R.id.bt_retry)
    Button bt_retry;
    @BindView(R.id.swipe_container)
    SwipeRefreshLayout swipeRefreshLayout;

    private ListListener listListener;
    private ItemsLayoutManager itemsLayoutManager;

    private Unbinder unbinder;

    public ItemsListFragment() {
        setRetainInstance(true);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof ListListener) {
            this.listListener = (ListListener) activity;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getComponent(AppComponent.class).inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View fragmentView = inflater.inflate(R.layout.fragment_items_list, container, false);
        unbinder = ButterKnife.bind(this, fragmentView);
        setupRecyclerView();
        return fragmentView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.itemsListPresenter.setView(this);
        if (savedInstanceState == null) {
            this.loadItemsList();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        this.itemsListPresenter.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        this.itemsListPresenter.pause();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        rv_items.setAdapter(null);
        unbinder.unbind();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.itemsListPresenter.destroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.listListener = null;
    }

    @Override
    public void showLoading() {
        this.rl_progress.setVisibility(View.VISIBLE);
        this.getActivity().setProgressBarIndeterminateVisibility(true);
    }

    @Override
    public void hideLoading() {
        this.rl_progress.setVisibility(View.GONE);
        this.getActivity().setProgressBarIndeterminateVisibility(false);
        if (this.swipeRefreshLayout.isRefreshing()) {
            swipeRefreshLayout.setRefreshing(false);
        }
    }

    @Override
    public void showRetry() {
        this.rl_retry.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideRetry() {
        this.rl_retry.setVisibility(View.GONE);
    }

    @Override
    public void viewItem() {
        if (this.listListener != null) {
            this.listListener.onItemClicked();
        }
    }

    @Override
    public void renderItemsList(List<RestaurantUIModel> itemDetailModels) {
        if (itemDetailModels != null) {
            this.itemsAdapter.setSearchResults(itemDetailModels);
        }
    }

    @Override
    public void showError(String message) {
        this.showToastMessage(message);
    }

    @Override
    public Context context() {
        return this.getActivity().getApplicationContext();
    }

    private void setupRecyclerView() {
        this.itemsAdapter.setOnItemClickListener(onItemClickListener);
        this.itemsLayoutManager = new ItemsLayoutManager(context());
        this.rv_items.setLayoutManager(itemsLayoutManager);
        this.rv_items.setAdapter(itemsAdapter);
        this.rv_items.setOnScrollListener(new EndlessRecyclerViewScrollListener(itemsLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                loadMoreItems(page, totalItemsCount, view);
            }
        });

        this.swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                itemsListPresenter.refreshItems();
            }
        });
    }

    private void loadMoreItems(int page, int totalItemsCount, RecyclerView view) {
        itemsListPresenter.loadMoreItems(page);
    }

    /**
     * Loads all Items.
     */
    private void loadItemsList() {
        this.itemsListPresenter.initialize();
    }

    @OnClick(R.id.bt_retry)
    void onButtonRetryClick() {
        ItemsListFragment.this.loadItemsList();
    }

    private ItemsAdapter.OnItemClickListener onItemClickListener =
            new ItemsAdapter.OnItemClickListener() {
                @Override
                public void onItemClicked() {
                    if (ItemsListFragment.this.itemsListPresenter != null) {
                        ItemsListFragment.this.itemsListPresenter.onItemClicked();
                    }
                }
            };
}
