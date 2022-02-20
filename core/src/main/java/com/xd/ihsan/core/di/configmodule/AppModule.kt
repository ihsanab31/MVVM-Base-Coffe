package com.xd.ihsan.core.di.configmodule

import android.app.Application
import android.content.SharedPreferences
import android.preference.PreferenceManager
import androidx.room.Room
import com.xd.ihsan.core.data.source.ConnectDatabase
import com.xd.ihsan.core.utils.Token
import com.xd.ihsan.core.utils.preference.PrefManager
import com.xd.ihsan.core.utils.preference.SessionManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by
 * Name     : Ihsan Abdurahman
 * Email    : ihsanab31@gmail.com
 * WA       : 085749729115
 * Date     : 11/26/2021
 * ------------------------------
 * This class for
 */
// Copyright (c) 2021 Ihsan Abdurahman. All rights reserved.
@Module
class AppModule (private val app: Application) {

    companion object {
        private const val MY_CONNECT_DB_NAME = "my-connect"
    }

    @Provides
    @Singleton
    fun provideApplication(): Application = app

    @Provides
    @Singleton
    fun provideSharedPreferences(): SharedPreferences =
        PreferenceManager.getDefaultSharedPreferences(app)

    @Provides
    @Singleton
    fun provideKabobsDatabase(app: Application): ConnectDatabase =
        Room.databaseBuilder(
            app,
            ConnectDatabase::class.java,
            MY_CONNECT_DB_NAME
        ).fallbackToDestructiveMigration()
            .build()

    @Provides
    fun provideSessionManager(): SessionManager {
        return SessionManager(Token(), PrefManager())
    }



//    @Provides
//    @Singleton
//    fun provideRegion(database: KabobsDatabase): RegionDao = database.regionDao()
}