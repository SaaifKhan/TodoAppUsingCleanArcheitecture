package com.example.data.di

import android.content.Context
import androidx.room.Room
import com.example.data.Constants
import com.example.data.db.dao.TodoDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object RoomModule {

    @Provides
    fun providesDatabase(@ApplicationContext context: Context): TodoDb =
        Room.databaseBuilder(
            context,
            TodoDb::class.java,
            Constants.DB_NAME
        ).allowMainThreadQueries().fallbackToDestructiveMigration().build()
}