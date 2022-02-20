package com.xd.ihsan.core.data.repository

import com.xd.ihsan.core.data.model.Coffee
import com.xd.ihsan.core.data.source.remote.ApiService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by
 * Name     : Ihsan Abdurahman
 * Email    : ihsanab31@gmail.com
 * WA       : 085749729115
 * Date     : 2/20/2022
 * ------------------------------
 * This class for
 */
// Copyright (c) 2022 Ihsan Abdurahman. All rights reserved.
class CoffeeRepository @Inject constructor(
    private val apiService: ApiService,
) {

    fun getCoffee(): Observable<List<Coffee>> =
        getCoffeeFromApi()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    private fun getCoffeeFromApi(): Observable<List<Coffee>> =
        apiService.getCity()
            .doOnNext {}


}