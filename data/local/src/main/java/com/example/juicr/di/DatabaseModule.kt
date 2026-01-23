package com.example.juicr.di

import android.content.Context
import androidx.room.Room
import com.example.juicr.database.AppDatabase
import com.example.juicr.dao.IJuiceDao
import com.example.juicr.dao.IPrepHistoryDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                "juicrDB"
            ).fallbackToDestructiveMigration(false)
            .build()
    }

    @Provides
    fun providesJuiceDao(db: AppDatabase): IJuiceDao {
        return db.juiceDao()
    }

    @Provides
    fun providesPreparationHistoryDao(db: AppDatabase): IPrepHistoryDao {
        return db.preparationHistoryDao()
    }
}
