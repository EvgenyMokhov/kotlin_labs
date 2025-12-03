package com.qwerty.spacenotes.di

import android.content.Context
import com.qwerty.spacenotes.data.repository.NotesRepository
import com.qwerty.spacenotes.data.repository.NotesRepositoryImpl
import com.qwerty.spacenotes.data.source.local.LocalNoteDataSource
import com.qwerty.spacenotes.data.source.local.room.AppDatabase
import com.qwerty.spacenotes.data.source.local.room.NoteDao
import com.qwerty.spacenotes.data.source.local.room.RoomNoteDataSource
import com.qwerty.spacenotes.data.source.remote.RemoteNoteDataSource
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
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getInstance(context)
    }

    @Provides
    @Singleton
    fun provideNoteDao(database: AppDatabase): NoteDao {
        return database.noteDao()
    }

    @Provides
    @Singleton
    fun provideLocalNoteDataSource(dao: NoteDao): LocalNoteDataSource {
        return RoomNoteDataSource(dao)
    }

    @Provides
    @Singleton
    fun provideNotesRepository(
        localDataSource: LocalNoteDataSource,
        remoteDataSource: RemoteNoteDataSource
    ): NotesRepository {
        return NotesRepositoryImpl(localDataSource, remoteDataSource)
    }
}