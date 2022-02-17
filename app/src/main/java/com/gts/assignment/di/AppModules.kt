package com.gts.assignment.di

import android.app.Application
import com.gts.assignment.utils.StringUtils
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * The Dagger Module for providing instances.
 * We can add other modules here as well like repository module if we are using usecases
 */

@Module
@InstallIn(SingletonComponent::class)
class AppModules {
    @Singleton
    @Provides
    fun provideStringUtils(app: Application): StringUtils {
        return StringUtils(app)
    }
}