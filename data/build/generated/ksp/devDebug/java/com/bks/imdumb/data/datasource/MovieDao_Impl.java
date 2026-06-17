package com.bks.imdumb.data.datasource;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.EmptyResultSetException;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.RxRoom;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bks.imdumb.data.model.MovieEntity;
import io.reactivex.Single;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class MovieDao_Impl implements MovieDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<MovieEntity> __insertionAdapterOfMovieEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeleteMoviesByCategory;

  public MovieDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfMovieEntity = new EntityInsertionAdapter<MovieEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `movies` (`id`,`title`,`overview`,`posterUrl`,`backdropUrl`,`rating`,`isAdult`,`genres`,`category`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final MovieEntity entity) {
        statement.bindLong(1, entity.getId());
        statement.bindString(2, entity.getTitle());
        statement.bindString(3, entity.getOverview());
        statement.bindString(4, entity.getPosterUrl());
        statement.bindString(5, entity.getBackdropUrl());
        statement.bindDouble(6, entity.getRating());
        final int _tmp = entity.isAdult() ? 1 : 0;
        statement.bindLong(7, _tmp);
        statement.bindString(8, entity.getGenres());
        statement.bindString(9, entity.getCategory());
      }
    };
    this.__preparedStmtOfDeleteMoviesByCategory = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM movies WHERE category = ?";
        return _query;
      }
    };
  }

  @Override
  public void insertMovies(final List<MovieEntity> movies) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfMovieEntity.insert(movies);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteMoviesByCategory(final String category) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteMoviesByCategory.acquire();
    int _argIndex = 1;
    _stmt.bindString(_argIndex, category);
    try {
      __db.beginTransaction();
      try {
        _stmt.executeUpdateDelete();
        __db.setTransactionSuccessful();
      } finally {
        __db.endTransaction();
      }
    } finally {
      __preparedStmtOfDeleteMoviesByCategory.release(_stmt);
    }
  }

  @Override
  public Single<List<MovieEntity>> getMoviesByCategory(final String category) {
    final String _sql = "SELECT * FROM movies WHERE category = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, category);
    return RxRoom.createSingle(new Callable<List<MovieEntity>>() {
      @Override
      @Nullable
      public List<MovieEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfOverview = CursorUtil.getColumnIndexOrThrow(_cursor, "overview");
          final int _cursorIndexOfPosterUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "posterUrl");
          final int _cursorIndexOfBackdropUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "backdropUrl");
          final int _cursorIndexOfRating = CursorUtil.getColumnIndexOrThrow(_cursor, "rating");
          final int _cursorIndexOfIsAdult = CursorUtil.getColumnIndexOrThrow(_cursor, "isAdult");
          final int _cursorIndexOfGenres = CursorUtil.getColumnIndexOrThrow(_cursor, "genres");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final List<MovieEntity> _result = new ArrayList<MovieEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final MovieEntity _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpTitle;
            _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            final String _tmpOverview;
            _tmpOverview = _cursor.getString(_cursorIndexOfOverview);
            final String _tmpPosterUrl;
            _tmpPosterUrl = _cursor.getString(_cursorIndexOfPosterUrl);
            final String _tmpBackdropUrl;
            _tmpBackdropUrl = _cursor.getString(_cursorIndexOfBackdropUrl);
            final double _tmpRating;
            _tmpRating = _cursor.getDouble(_cursorIndexOfRating);
            final boolean _tmpIsAdult;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsAdult);
            _tmpIsAdult = _tmp != 0;
            final String _tmpGenres;
            _tmpGenres = _cursor.getString(_cursorIndexOfGenres);
            final String _tmpCategory;
            _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            _item = new MovieEntity(_tmpId,_tmpTitle,_tmpOverview,_tmpPosterUrl,_tmpBackdropUrl,_tmpRating,_tmpIsAdult,_tmpGenres,_tmpCategory);
            _result.add(_item);
          }
          if (_result == null) {
            throw new EmptyResultSetException("Query returned empty result set: " + _statement.getSql());
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
