package com.nzwa.storyapp.data.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.nzwa.storyapp.data.database.StoryRepository
import com.nzwa.storyapp.data.preferences.SessionPreferences
import com.nzwa.storyapp.data.retrofit.ApiConfig

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("token")

object Injection {
    fun provideRepository(context: Context): StoryRepository {
        val preferences = SessionPreferences.getInstance(context.dataStore)
        val apiService = ApiConfig.getApiService()
        return StoryRepository.getInstance(preferences, apiService)
    }
}