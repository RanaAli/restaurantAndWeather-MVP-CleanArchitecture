
package com.app.data.entity.response.search;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Badges {

    @SerializedName("discount")
    @Expose
    private String discount;

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

}
