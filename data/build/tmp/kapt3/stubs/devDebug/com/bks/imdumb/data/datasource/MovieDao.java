package com.bks.imdumb.data.datasource;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u001c\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0016\u0010\n\u001a\u00020\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\bH\'\u00a8\u0006\f"}, d2 = {"Lcom/bks/imdumb/data/datasource/MovieDao;", "", "deleteMoviesByCategory", "", "category", "", "getMoviesByCategory", "Lio/reactivex/Single;", "", "Lcom/bks/imdumb/data/model/MovieEntity;", "insertMovies", "movies", "data_devDebug"})
@androidx.room.Dao()
public abstract interface MovieDao {
    
    @androidx.room.Query(value = "SELECT * FROM movies WHERE category = :category")
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<java.util.List<com.bks.imdumb.data.model.MovieEntity>> getMoviesByCategory(@org.jetbrains.annotations.NotNull()
    java.lang.String category);
    
    @androidx.room.Insert(onConflict = 1)
    public abstract void insertMovies(@org.jetbrains.annotations.NotNull()
    java.util.List<com.bks.imdumb.data.model.MovieEntity> movies);
    
    @androidx.room.Query(value = "DELETE FROM movies WHERE category = :category")
    public abstract void deleteMoviesByCategory(@org.jetbrains.annotations.NotNull()
    java.lang.String category);
}