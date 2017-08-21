package com.app.domain.interactor;

/**
 * Created by RanaAli on 8/20/17.
 */

import com.app.domain.model.ItemDetails;
import com.app.domain.executor.PostExecutionThread;
import com.app.domain.executor.ThreadExecutor;
import com.app.domain.repository.ItemsRepository;
import io.reactivex.Observable;
import javax.inject.Inject;

/**
 * This class is an implementation of {@link UseCase} that represents a use case for
 * retrieving data related to an Item.
 */
public class GetItemDetails extends UseCase<ItemDetails, GetItemDetails.Params> {

  private final ItemsRepository itemsRepository;

  @Inject
  public GetItemDetails(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread,
      ItemsRepository itemsRepository) {
    super(threadExecutor, postExecutionThread);
    this.itemsRepository = itemsRepository;
  }

  @Override Observable<ItemDetails> buildUseCaseObservable(Params params) {
    return itemsRepository.getItemDetails(params.slug);
  }

  public static final class Params {

    private final String slug;

    private Params(String slug) {
      this.slug = slug;
    }

    public static GetItemDetails.Params forItem(String slug) {
      return new GetItemDetails.Params(slug);
    }
  }
}
