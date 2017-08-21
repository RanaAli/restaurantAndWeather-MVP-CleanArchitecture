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

  @POST(URL_SEARCH_FULL) Observable<SearchEntity> searchItem(
      @Query("searchString") String searchString, @Query("page") String page,
      @Query("hits") String hits);

  @GET("product/findbyslug/") Observable<ItemDetailsEntity> getItemDetails(@Query("slug") String slug);
}
