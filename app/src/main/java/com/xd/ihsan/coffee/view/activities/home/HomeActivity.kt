package com.xd.ihsan.coffee.view.activities.home

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.xd.ihsan.coffee.BR
import com.xd.ihsan.coffee.R
import com.xd.ihsan.coffee.databinding.ActivityHomeBinding
import com.xd.ihsan.coffee.utils.dialog.DialogUtils.showInfoDialog
import com.xd.ihsan.coffee.view.activities.home.adapter.CoffeeAdapter
import com.xd.ihsan.coffee.view.base.BaseActivity
import com.xd.ihsan.core.data.model.Coffee
import com.xd.ihsan.core.utils.extentions.AppLogger
import com.xd.ihsan.core.utils.extentions.TAG
import kotlinx.android.synthetic.main.activity_home.*
import org.json.JSONArray

import org.json.JSONObject
import java.util.*
import kotlin.Comparator
import kotlin.collections.ArrayList


@SuppressLint("NotifyDataSetChanged")
class HomeActivity : BaseActivity<ActivityHomeBinding, HomeViewModel>() {
    private val coffeeViewModel by lazy {
        ViewModelProvider(this, viewModelProviderFactory)[HomeViewModel::class.java]
    }
    private val coffee = mutableListOf<Coffee>()
    private var coffeeAdapter: CoffeeAdapter? = null
    override val viewModel: Class<HomeViewModel> = HomeViewModel::class.java

    override fun getBindingVariable() = BR.viewModel

    override val layoutId = R.layout.activity_home

    override fun initUserInterface() {
        populateAdapterWithInfo()
        initSwipe()
        initView()
    }

    private fun populateAdapterWithInfo() {
        coffeeAdapter = CoffeeAdapter(coffee, this)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_coffee.layoutManager = layoutManager
        rv_coffee.adapter = coffeeAdapter
    }

    private fun observerCoffee() {
        coffeeViewModel.coffeeResp()
            .observe(this) {
                coffee.clear()
                coffee.addAll(it.sortedByDescending { it.id })
                coffeeAdapter!!.notifyDataSetChanged()
                toggleLoadingDialog(false)
            }
        coffeeViewModel.coffeeError().observe(
            this
        ) {
            AppLogger.e(TAG, it)
        }
    }

    private fun initSwipe() {

        swipe.setOnRefreshListener {
            if (isConnected()) {
                toggleLoadingDialog(true)
                coffeeViewModel.fetchCoffee()
                initView()
            } else {
                showInfoDialog(
                    this,
                    resources.getString(R.string.internet),
                    resources.getString(R.string.connection)
                )
            }
            swipe.isRefreshing = false
        }
    }

    private fun initView() {
        if (isConnected()) {
            toggleLoadingDialog(true)
            observerCoffee()
        } else {
            showInfoDialog(
                this,
                resources.getString(R.string.internet),
                resources.getString(R.string.connection)
            )
        }
    }
}