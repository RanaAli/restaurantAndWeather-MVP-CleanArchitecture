
package com.app.data.entity.response.search;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Stats {

    @SerializedName("itemRevenue")
    @Expose
    private Integer itemRevenue;
    @SerializedName("listViews")
    @Expose
    private Integer listViews;
    @SerializedName("detailViews")
    @Expose
    private Integer detailViews;
    @SerializedName("addsToCart")
    @Expose
    private Integer addsToCart;
    @SerializedName("checkouts")
    @Expose
    private Integer checkouts;
    @SerializedName("uniquePurchases")
    @Expose
    private Integer uniquePurchases;
    @SerializedName("listToDetail")
    @Expose
    private Double listToDetail;

    public Integer getItemRevenue() {
        return itemRevenue;
    }

    public void setItemRevenue(Integer itemRevenue) {
        this.itemRevenue = itemRevenue;
    }

    public Integer getListViews() {
        return listViews;
    }

    public void setListViews(Integer listViews) {
        this.listViews = listViews;
    }

    public Integer getDetailViews() {
        return detailViews;
    }

    public void setDetailViews(Integer detailViews) {
        this.detailViews = detailViews;
    }

    public Integer getAddsToCart() {
        return addsToCart;
    }

    public void setAddsToCart(Integer addsToCart) {
        this.addsToCart = addsToCart;
    }

    public Integer getCheckouts() {
        return checkouts;
    }

    public void setCheckouts(Integer checkouts) {
        this.checkouts = checkouts;
    }

    public Integer getUniquePurchases() {
        return uniquePurchases;
    }

    public void setUniquePurchases(Integer uniquePurchases) {
        this.uniquePurchases = uniquePurchases;
    }

    public Double getListToDetail() {
        return listToDetail;
    }

    public void setListToDetail(Double listToDetail) {
        this.listToDetail = listToDetail;
    }

}
