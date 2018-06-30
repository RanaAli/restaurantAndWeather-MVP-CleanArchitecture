package com.app.domain.interactor;

import com.app.domain.executor.PostExecutionThread;
import com.app.domain.executor.ThreadExecutor;
import com.app.domain.model.restaurants.RestaurantsDataModel;
import com.app.domain.repository.RestaurantsRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * This class is an implementation of {@link UseCase} that represents a use case for
 * retrieving data related to nearby restaurants.
 */
public class GetRestaurantsNearMe extends UseCase<RestaurantsDataModel, GetRestaurantsNearMe.Params> {

    private final RestaurantsRepository restaurantsRepository;

    @Inject
    public GetRestaurantsNearMe(ThreadExecutor threadExecutor,
                                PostExecutionThread postExecutionThread,
                                RestaurantsRepository restaurantsRepository) {
        super(threadExecutor, postExecutionThread);
        this.restaurantsRepository = restaurantsRepository;
    }

    @Override
    Observable<RestaurantsDataModel> buildUseCaseObservable(Params params) {
        return restaurantsRepository.restaurantsNearMe(params.lat, params.lon);
    }

    public static final class Params {

        private final String lat;
        private final String lon;

        public Params(String lat, String lon) {
            this.lat = lat;
            this.lon = lon;
        }

        public static GetRestaurantsNearMe.Params forLocation(String lat, String lon) {
            return new GetRestaurantsNearMe.Params(lat, lon);
        }
    }
}
