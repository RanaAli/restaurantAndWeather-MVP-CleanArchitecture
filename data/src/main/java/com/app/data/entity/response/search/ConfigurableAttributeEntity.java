
package com.app.data.entity.response.search;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ConfigurableAttributeEntity {

    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("options")
    @Expose
    private List<OptionEntity> options = null;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<OptionEntity> getOptions() {
        return options;
    }

    public void setOptions(List<OptionEntity> options) {
        this.options = options;
    }

}
