package com.bks.imdumb.data.datasource

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bks.imdumb.data.model.MovieEntity

@Database(entities = [MovieEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}
