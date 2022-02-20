package com.xd.ihsan.coffee.view.activities.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.xd.ihsan.coffee.view.base.BaseViewModel
import com.xd.ihsan.core.data.model.Coffee
import com.xd.ihsan.core.data.repository.CoffeeRepository
import io.reactivex.Observer
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
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
class HomeViewModel @Inject constructor(
    private val coffeeRepository: CoffeeRepository
) : BaseViewModel()  {
    private val coffeeResp: MutableLiveData<List<Coffee>> = MutableLiveData()
    private val coffeeError: MutableLiveData<String> = MutableLiveData()
    private val compositeDisposable = CompositeDisposable()

    fun coffeeResp(): LiveData<List<Coffee>> = coffeeResp
    fun coffeeError(): LiveData<String> = coffeeError

    init {
        fetchCoffee()
    }

      fun fetchCoffee() {
        coffeeRepository.getCoffee().subscribe(object : Observer<List<Coffee>> {
            override fun onSubscribe(d: Disposable) {
                compositeDisposable.add(d)
            }

            override fun onNext(t: List<Coffee>) {
               coffeeResp.postValue(t)
            }

            override fun onError(e: Throwable) {
               coffeeError.postValue(e.message)
            }

            override fun onComplete() {}

        })
    }
}