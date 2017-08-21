
package com.app.data.entity.response.search;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StockEntity {

    @SerializedName("homeDeliveryQty")
    @Expose
    private Integer homeDeliveryQty;
    @SerializedName("clickAndCollectQty")
    @Expose
    private Integer clickAndCollectQty;
    @SerializedName("maxAvailableQty")
    @Expose
    private Integer maxAvailableQty;

    public Integer getHomeDeliveryQty() {
        return homeDeliveryQty;
    }

    public void setHomeDeliveryQty(Integer homeDeliveryQty) {
        this.homeDeliveryQty = homeDeliveryQty;
    }

    public Integer getClickAndCollectQty() {
        return clickAndCollectQty;
    }

    public void setClickAndCollectQty(Integer clickAndCollectQty) {
        this.clickAndCollectQty = clickAndCollectQty;
    }

    public Integer getMaxAvailableQty() {
        return maxAvailableQty;
    }

    public void setMaxAvailableQty(Integer maxAvailableQty) {
        this.maxAvailableQty = maxAvailableQty;
    }

}
