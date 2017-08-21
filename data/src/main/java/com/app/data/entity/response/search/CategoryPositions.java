
package com.app.data.entity.response.search;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CategoryPositions {

    @SerializedName("1353")
    @Expose
    private Integer _1353;
    @SerializedName("2015")
    @Expose
    private Integer _2015;
    @SerializedName("2019")
    @Expose
    private Integer _2019;

    public Integer get1353() {
        return _1353;
    }

    public void set1353(Integer _1353) {
        this._1353 = _1353;
    }

    public Integer get2015() {
        return _2015;
    }

    public void set2015(Integer _2015) {
        this._2015 = _2015;
    }

    public Integer get2019() {
        return _2019;
    }

    public void set2019(Integer _2019) {
        this._2019 = _2019;
    }

}
