package com.app.unit.unitsa.di

import android.app.Application
import com.app.unit.unitsa.managers.PreferencesManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun providesAppPreferences(application: Application): PreferencesManager {
        return PreferencesManager(application.applicationContext)
    }
}