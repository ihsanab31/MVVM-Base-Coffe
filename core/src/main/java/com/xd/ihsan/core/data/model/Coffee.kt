package com.xd.ihsan.core.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Suppress("DEPRECATED_ANNOTATION")
@Parcelize
data class Coffee(

	@Json(name="description")
	@ColumnInfo(name = "description")
	val description: String? = null,

	@Json(name="ingredients")
	@ColumnInfo(name = "ingredients")
	val ingredients: List<String>?= null,

	@PrimaryKey(autoGenerate = true)
	@Json(name="id")
	val id: Int? = null,

	@Json(name="title")
	@ColumnInfo(name = "title")
	val title: String? = null
) : Parcelable
