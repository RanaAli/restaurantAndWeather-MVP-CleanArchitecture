
package com.app.data.entity.response.search;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OptionEntity {

    @SerializedName("optionId")
    @Expose
    private Integer optionId;
    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("simpleProductSkus")
    @Expose
    private List<String> simpleProductSkus = null;
    @SerializedName("isInStock")
    @Expose
    private Boolean isInStock;

    public Integer getOptionId() {
        return optionId;
    }

    public void setOptionId(Integer optionId) {
        this.optionId = optionId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<String> getSimpleProductSkus() {
        return simpleProductSkus;
    }

    public void setSimpleProductSkus(List<String> simpleProductSkus) {
        this.simpleProductSkus = simpleProductSkus;
    }

    public Boolean getIsInStock() {
        return isInStock;
    }

    public void setIsInStock(Boolean isInStock) {
        this.isInStock = isInStock;
    }

}
