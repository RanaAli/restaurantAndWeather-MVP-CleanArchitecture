package com.app.domain.interactor;

import com.app.domain.executor.PostExecutionThread;
import com.app.domain.executor.ThreadExecutor;
import com.app.domain.model.weather.WeatherDataModel;
import com.app.domain.repository.WeatherRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * This class is an implementation of {@link UseCase} that represents a use case for
 * retrieving data related to nearby restaurants.
 */
public class GetWeatherNearMe extends UseCase<WeatherDataModel, GetWeatherNearMe.Params> {

    private final WeatherRepository weatherRepository;

    @Inject
    public GetWeatherNearMe(ThreadExecutor threadExecutor,
                            PostExecutionThread postExecutionThread,
                            WeatherRepository weatherRepository) {
        super(threadExecutor, postExecutionThread);
        this.weatherRepository = weatherRepository;
    }

    @Override
    Observable<WeatherDataModel> buildUseCaseObservable(Params params) {
        return weatherRepository.weatherNearMe(params.lat, params.lon);
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
