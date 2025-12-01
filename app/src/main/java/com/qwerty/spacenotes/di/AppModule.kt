package com.qwerty.spacenotes.di

import android.content.Context
import com.qwerty.spacenotes.data.repository.NotesRepository
import com.qwerty.spacenotes.data.source.FileNoteDataSource
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
    fun provideNotesRepository(@ApplicationContext context: Context): NotesRepository {
        return FileNoteDataSource(context)
    }
}