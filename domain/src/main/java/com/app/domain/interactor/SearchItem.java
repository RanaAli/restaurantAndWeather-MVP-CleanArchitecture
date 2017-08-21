package com.app.domain.interactor;

import com.app.domain.executor.ThreadExecutor;
import com.app.domain.repository.ItemsRepository;
import com.app.domain.model.SearchResult;
import com.app.domain.executor.PostExecutionThread;
import io.reactivex.Observable;
import javax.inject.Inject;

/**
 * This class is an implementation of {@link UseCase} that represents a use case for
 * retrieving search results.
 */
public class SearchItem extends UseCase<SearchResult, SearchItem.Params> {

  private final ItemsRepository itemsRepository;

  @Inject SearchItem(ItemsRepository itemsRepository, ThreadExecutor threadExecutor,
      PostExecutionThread postExecutionThread) {
    super(threadExecutor, postExecutionThread);
    this.itemsRepository = itemsRepository;
  }

  @Override Observable<SearchResult> buildUseCaseObservable(Params params) {
    return this.itemsRepository.searchItem(params.searchString, params.page, params.hits);
  }

  public static final class Params {

    final String searchString;
    final String page;
    final String hits;

    private Params(String searchString, String page, String hits) {
      this.searchString = searchString;
      this.page = page;
      this.hits = hits;
    }

    public static SearchItem.Params forQuery(String searchString, String page, String hits) {
      return new SearchItem.Params(searchString, page, hits);
    }
  }
}
