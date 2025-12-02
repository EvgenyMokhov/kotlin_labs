package com.qwerty.spacenotes.di

import android.content.Context
import com.qwerty.spacenotes.data.repository.NotesRepository
import com.qwerty.spacenotes.data.repository.NotesRepositoryImpl
import com.qwerty.spacenotes.data.source.local.LocalNoteDataSource
import com.qwerty.spacenotes.data.source.remote.RemoteNoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    @Singleton
    fun provideLocalDataSource(@ApplicationContext context: Context): LocalNoteDataSource {
        return LocalNoteDataSource(context)
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