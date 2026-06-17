package com.bks.imdumb.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J*\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\n2\u0006\u0010\u000f\u001a\u00020\bH\u0002J\u001c\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u000b0\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u001c\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000b0\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0014\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nH\u0016J\u0014\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nH\u0016J\u0014\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/bks/imdumb/data/repository/MovieRepositoryImpl;", "Lcom/bks/imdumb/domain/repository/MovieRepository;", "api", "Lcom/bks/imdumb/data/api/TmdbApi;", "dao", "Lcom/bks/imdumb/data/datasource/MovieDao;", "(Lcom/bks/imdumb/data/api/TmdbApi;Lcom/bks/imdumb/data/datasource/MovieDao;)V", "apiKey", "", "fetchMovies", "Lio/reactivex/Single;", "", "Lcom/bks/imdumb/domain/model/Movie;", "apiCall", "Lcom/bks/imdumb/data/model/MovieResponse;", "category", "getMovieCredits", "Lcom/bks/imdumb/domain/model/Actor;", "movieId", "", "getMovieDetails", "getMovieImages", "getPopularMovies", "getTopRatedMovies", "getUpcomingMovies", "data_qaDebug"})
public final class MovieRepositoryImpl implements com.bks.imdumb.domain.repository.MovieRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.bks.imdumb.data.api.TmdbApi api = null;
    @org.jetbrains.annotations.NotNull()
    private final com.bks.imdumb.data.datasource.MovieDao dao = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String apiKey = "2a79d18f5dec1cdc073a2882137d3a3b";
    
    @javax.inject.Inject()
    public MovieRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.bks.imdumb.data.api.TmdbApi api, @org.jetbrains.annotations.NotNull()
    com.bks.imdumb.data.datasource.MovieDao dao) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public io.reactivex.Single<java.util.List<com.bks.imdumb.domain.model.Movie>> getPopularMovies() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public io.reactivex.Single<java.util.List<com.bks.imdumb.domain.model.Movie>> getTopRatedMovies() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public io.reactivex.Single<java.util.List<com.bks.imdumb.domain.model.Movie>> getUpcomingMovies() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public io.reactivex.Single<com.bks.imdumb.domain.model.Movie> getMovieDetails(int movieId) {
        return null;
    }
    
    private final io.reactivex.Single<java.util.List<com.bks.imdumb.domain.model.Movie>> fetchMovies(io.reactivex.Single<com.bks.imdumb.data.model.MovieResponse> apiCall, java.lang.String category) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public io.reactivex.Single<java.util.List<com.bks.imdumb.domain.model.Actor>> getMovieCredits(int movieId) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public io.reactivex.Single<java.util.List<java.lang.String>> getMovieImages(int movieId) {
        return null;
    }
}