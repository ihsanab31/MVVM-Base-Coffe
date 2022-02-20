package com.xd.ihsan.core.data.source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.xd.ihsan.core.data.model.City

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
@Database(
    entities = [
        City::class
    ],
    version = 2,
    exportSchema = false
)

abstract class ConnectDatabase : RoomDatabase(){
}