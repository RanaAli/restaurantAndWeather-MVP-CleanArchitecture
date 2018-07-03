package com.app.domain.interactor;

import com.app.domain.executor.PostExecutionThread;
import com.app.domain.executor.ThreadExecutor;
import com.app.domain.model.weather.WeatherDTO;
import com.app.domain.repository.WeatherRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * This class is an implementation of {@link UseCase} that represents a use case for
 * retrieving data related to nearby restaurants.
 */
public class GetWeatherNearMe extends UseCase<WeatherDTO, GetWeatherNearMe.Params> {

    private final WeatherRepository weatherRepository;

    @Inject
    public GetWeatherNearMe(ThreadExecutor threadExecutor,
                            PostExecutionThread postExecutionThread,
                            WeatherRepository weatherRepository) {
        super(threadExecutor, postExecutionThread);
        this.weatherRepository = weatherRepository;
    }

    @Override
    Observable<WeatherDTO> buildUseCaseObservable(Params params) {
        return weatherRepository.weatherNearMe();
    }

    public static final class Params {
    }
}
