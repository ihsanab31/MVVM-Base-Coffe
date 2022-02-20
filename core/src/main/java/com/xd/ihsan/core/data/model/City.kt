package com.xd.ihsan.core.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Suppress("DEPRECATED_ANNOTATION")
@Parcelize
@Entity(tableName = "city")
data class City(

    @PrimaryKey
    @Json(name = "cities_id")
    val citiesId: String,

    @Json(name = "cities_name")
    @ColumnInfo(name = "cities_name")
    val citiesName: String? = null
) : Parcelable
