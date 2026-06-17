package com.bks.imdumb.data.repository;

import com.bks.imdumb.data.api.TmdbApi;
import com.bks.imdumb.data.datasource.MovieDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.Providers;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation",
    "nullness:initialization.field.uninitialized"
})
public final class MovieRepositoryImpl_Factory implements Factory<MovieRepositoryImpl> {
  private final Provider<TmdbApi> apiProvider;

  private final Provider<MovieDao> daoProvider;

  public MovieRepositoryImpl_Factory(Provider<TmdbApi> apiProvider,
      Provider<MovieDao> daoProvider) {
    this.apiProvider = apiProvider;
    this.daoProvider = daoProvider;
  }

  @Override
  public MovieRepositoryImpl get() {
    return newInstance(apiProvider.get(), daoProvider.get());
  }

  public static MovieRepositoryImpl_Factory create(javax.inject.Provider<TmdbApi> apiProvider,
      javax.inject.Provider<MovieDao> daoProvider) {
    return new MovieRepositoryImpl_Factory(Providers.asDaggerProvider(apiProvider), Providers.asDaggerProvider(daoProvider));
  }

  public static MovieRepositoryImpl_Factory create(Provider<TmdbApi> apiProvider,
      Provider<MovieDao> daoProvider) {
    return new MovieRepositoryImpl_Factory(apiProvider, daoProvider);
  }

  public static MovieRepositoryImpl newInstance(TmdbApi api, MovieDao dao) {
    return new MovieRepositoryImpl(api, dao);
  }
}
