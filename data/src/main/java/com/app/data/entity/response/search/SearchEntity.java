
package com.app.data.entity.response.search;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SearchEntity {

    @SerializedName("facets")
    @Expose
    private Facets facets;
    @SerializedName("hits")
    @Expose
    private List<ItemDetailsEntity> hits = null;
    @SerializedName("pagination")
    @Expose
    private Pagination pagination;

    public Facets getFacets() {
        return facets;
    }

    public void setFacets(Facets facets) {
        this.facets = facets;
    }

    public List<ItemDetailsEntity> getHits() {
        return hits;
    }

    public void setHits(List<ItemDetailsEntity> hits) {
        this.hits = hits;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

}
