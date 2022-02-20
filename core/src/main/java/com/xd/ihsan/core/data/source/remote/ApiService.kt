package com.xd.ihsan.core.data.source.remote

import com.xd.ihsan.core.data.model.Coffee
import io.reactivex.Observable
import retrofit2.http.GET

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
interface ApiService {
    @GET("hot")
    fun getCity(): Observable<List<Coffee>>
}