package com.bks.imdumb.data.api;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH\'J,\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0003\u0010\u000b\u001a\u00020\bH\'J\"\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH\'J\"\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0003\u0010\u000b\u001a\u00020\bH\'J\"\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0003\u0010\u000b\u001a\u00020\bH\'J\"\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0003\u0010\u000b\u001a\u00020\bH\'\u00a8\u0006\u0012"}, d2 = {"Lcom/bks/imdumb/data/api/TmdbApi;", "", "getMovieCredits", "Lio/reactivex/Single;", "Lcom/bks/imdumb/data/model/CreditsResponse;", "movieId", "", "apiKey", "", "getMovieDetails", "Lcom/bks/imdumb/data/model/MovieDto;", "language", "getMovieImages", "Lcom/bks/imdumb/data/model/ImagesResponse;", "getPopularMovies", "Lcom/bks/imdumb/data/model/MovieResponse;", "getTopRatedMovies", "getUpcomingMovies", "data_qaDebug"})
public abstract interface TmdbApi {
    
    @retrofit2.http.GET(value = "movie/popular")
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<com.bks.imdumb.data.model.MovieResponse> getPopularMovies(@retrofit2.http.Query(value = "api_key")
    @org.jetbrains.annotations.NotNull()
    java.lang.String apiKey, @retrofit2.http.Query(value = "language")
    @org.jetbrains.annotations.NotNull()
    java.lang.String language);
    
    @retrofit2.http.GET(value = "movie/top_rated")
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<com.bks.imdumb.data.model.MovieResponse> getTopRatedMovies(@retrofit2.http.Query(value = "api_key")
    @org.jetbrains.annotations.NotNull()
    java.lang.String apiKey, @retrofit2.http.Query(value = "language")
    @org.jetbrains.annotations.NotNull()
    java.lang.String language);
    
    @retrofit2.http.GET(value = "movie/upcoming")
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<com.bks.imdumb.data.model.MovieResponse> getUpcomingMovies(@retrofit2.http.Query(value = "api_key")
    @org.jetbrains.annotations.NotNull()
    java.lang.String apiKey, @retrofit2.http.Query(value = "language")
    @org.jetbrains.annotations.NotNull()
    java.lang.String language);
    
    @retrofit2.http.GET(value = "movie/{movie_id}")
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<com.bks.imdumb.data.model.MovieDto> getMovieDetails(@retrofit2.http.Path(value = "movie_id")
    int movieId, @retrofit2.http.Query(value = "api_key")
    @org.jetbrains.annotations.NotNull()
    java.lang.String apiKey, @retrofit2.http.Query(value = "language")
    @org.jetbrains.annotations.NotNull()
    java.lang.String language);
    
    @retrofit2.http.GET(value = "movie/{movie_id}/credits")
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<com.bks.imdumb.data.model.CreditsResponse> getMovieCredits(@retrofit2.http.Path(value = "movie_id")
    int movieId, @retrofit2.http.Query(value = "api_key")
    @org.jetbrains.annotations.NotNull()
    java.lang.String apiKey);
    
    @retrofit2.http.GET(value = "movie/{movie_id}/images")
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<com.bks.imdumb.data.model.ImagesResponse> getMovieImages(@retrofit2.http.Path(value = "movie_id")
    int movieId, @retrofit2.http.Query(value = "api_key")
    @org.jetbrains.annotations.NotNull()
    java.lang.String apiKey);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}