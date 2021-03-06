package com.xd.ihsan.coffee.view.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.xd.ihsan.core.utils.event.EventObserver
import com.xd.ihsan.core.utils.extentions.isConnected
import com.xd.ihsan.coffee.utils.dialog.DialogUtils
import dagger.android.AndroidInjection
import dagger.android.support.DaggerFragment
import javax.inject.Inject

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
abstract class BaseFragment <VDB : ViewDataBinding, BVM : BaseViewModel> : DaggerFragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    protected lateinit var viewDataBinding: VDB

    lateinit var injectedViewModel: BVM

    abstract val bindingVariable: Int

    abstract val viewModel: Class<BVM>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        injectedViewModel =
            ViewModelProviders.of(this, viewModelFactory).get(viewModel)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        AndroidInjection.inject(activity)
        viewDataBinding = DataBindingUtil.inflate(
            inflater,
            getLayoutId(),
            container,
            false
        )

        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        AndroidInjection.inject(activity)
        viewDataBinding.setVariable(
            bindingVariable,
            injectedViewModel
        )

        viewDataBinding.executePendingBindings()
        observeLoading()
        initUserInterface(view)

    }

    private fun observeLoading() {
        injectedViewModel.showLoadingLiveData.observe(
            viewLifecycleOwner, EventObserver {
                toggleLoadingDialog(it.first)

            }
        )
    }

    protected abstract fun getLayoutId(): Int

    protected abstract fun initUserInterface(rootView: View)


    protected fun isAlive(): Boolean {
        return !(isRemoving ||
                activity == null ||
                isDetached ||
                isAdded ||
                view == null)
    }

    fun getFragmentTag(): String = javaClass.simpleName

    open fun onBackPressed() {}

    fun isConnected(): Boolean {
        return this.context!!.isConnected()
    }

    fun toggleLoadingDialog(
        show: Boolean,
    ) {
        activity?.let {
            (it as BaseActivity<*, *>).toggleLoadingDialog(show)
        }
    }


    private var onBackPressedCallback =
        object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                onBackPressed()
            }
        }


    /**
     * Enables OnBackPressedCallback event
     */
    open fun enableOnBackPressedCallback() {
        requireActivity()
            .onBackPressedDispatcher
            .addCallback(
                this,
                onBackPressedCallback
            )
        onBackPressedCallback.isEnabled = true
    }

    /**
     * Disables OnBackPressedCallback event
     */
    fun disableOnBackPressedCallback() {
        onBackPressedCallback.isEnabled = false
    }

    fun showFragmentDialog(title: String, message: String) {
        activity?.let {
            DialogUtils
                .showInfoDialog(
                    context = it as BaseActivity<*, *>,
                    title = title,
                    message = message,
                    cancelable = false,
                )
        }
    }
}