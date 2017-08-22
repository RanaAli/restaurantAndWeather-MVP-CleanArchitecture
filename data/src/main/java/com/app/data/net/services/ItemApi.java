package com.app.data.net.services;

import com.app.data.entity.response.search.ItemDetailsEntity;
import com.app.data.entity.response.search.SearchEntity;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by RanaAli on 8/20/17.
 */

public interface ItemApi {

  String URL_SEARCH_FULL = "search/full";
  String PRODUCT_FIND_BY_SLUG = "product/findbyslug/";

  @POST(URL_SEARCH_FULL) Observable<SearchEntity> searchItem(
      @Query("searchString") String searchString, @Query("page") String page,
      @Query("hits") String hits);

  @GET(PRODUCT_FIND_BY_SLUG) Observable<ItemDetailsEntity> getItemDetails(@Query("slug") String slug);
}
