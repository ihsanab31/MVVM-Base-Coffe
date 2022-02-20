package com.xd.ihsan.coffee.view.base

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProviders
import com.xd.ihsan.core.ViewModelProviderFactory
import com.xd.ihsan.core.utils.RECORD_REQUEST_CODE
import com.xd.ihsan.core.utils.extentions.*
import com.xd.ihsan.core.utils.listener.AlertDialogListener
import com.xd.ihsan.coffee.R
import com.xd.ihsan.coffee.utils.dialog.DialogUtils
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.disposables.Disposable
import permissions.dispatcher.RuntimePermissions
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
@RuntimePermissions
abstract class BaseActivity<VDB : ViewDataBinding, BVM : BaseViewModel> :
    DaggerAppCompatActivity() {
//    protected lateinit var firebaseAnalytics: FirebaseAnalytics
//    private lateinit var trace: Trace
    private val permissions =
        arrayOf(
            Manifest.permission.CAMERA,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        )

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory
    private lateinit var injectedViewModel: BVM
    private lateinit var viewDataBinding: VDB
    private var sessionDisposable: Disposable? = null
    abstract val viewModel: Class<BVM>
    abstract fun getBindingVariable(): Int

    @get:LayoutRes
    abstract val layoutId: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        performDataBinding()
        initUserInterface()
//        firebaseAnalytics = Firebase.analytics
//        trace = Firebase.performance.newTrace(STARTUP_TRACE_NAME)
//        trace.start()
        setupPermissions()
    }

    override fun onBackPressed() {
        currentFocus?.let {
            KeyBoardUtils.hideKeyboard(it)
        }
        super.onBackPressed()
    }

    protected abstract fun initUserInterface()


    private fun performDataBinding() {

        viewDataBinding = DataBindingUtil.setContentView(this, layoutId)

        (viewDataBinding.root as ViewGroup).addView(
            layoutInflater.inflate(
                R.layout.activity_base,
                null
            )
        )

        injectedViewModel =
            ViewModelProviders.of(this, viewModelProviderFactory).get(viewModel)
        viewDataBinding.setVariable(getBindingVariable(), injectedViewModel)

        viewDataBinding.executePendingBindings()

    }


    fun toggleLoadingDialog(show: Boolean) {
        if (show) {
            showLoading()
        } else {
            hideLoading()
        }
    }

    private fun showLoading() {
        viewDataBinding.root.findViewById<ConstraintLayout>(R.id.progress).showView(true)
    }


    private fun hideLoading() {
        viewDataBinding.root.findViewById<ConstraintLayout>(R.id.progress).showView(false)
    }

    fun isConnected() = this.applicationContext.isConnected()

    private fun subscribeSession() {
        AppLogger.d(TAG, "subscribeSession()")
        sessionDisposable =
            injectedViewModel.subscribeSessionObserver { onSessionExpired() }

    }

    /**
     * Unsubscribe session manager observers from callbacks
     */
    private fun unsubscribeSession() {
        AppLogger.d(TAG, "unsubscribeSession()")
        sessionDisposable?.dispose()
        sessionDisposable = null
    }

    /**
     * Show session expired dialog with masked background..
     * its a good practice to mask a UI with splash screen
     */
    private fun onSessionExpired() {
        if (isFinishing.not()) {
            AppLogger.d(TAG, "onSessionExpired()")
            maskAppUi()
            hideLoading()
            showSessionTimeoutDialog()
        }
    }


    /**
     * Mask/unmask app UI with the overlay
     */
    private fun maskAppUi(mask: Boolean = true) {
        if (mask) {
            hideKeyboard()
        }
        viewDataBinding.root.bringToFront()
        viewDataBinding.root.findViewById<ConstraintLayout>(R.id.layoutMask).showView(mask)
    }

    private fun hideKeyboard() {
        this.currentFocus?.let {
            KeyBoardUtils.hideKeyboard(it)
        }
    }


    /**
     * Show session timeout dialog with an option to show custom dialog button text
     */
    private fun showSessionTimeoutDialog(
        dialogButtonText: String = getString(
            R.string.login
        ),
        title: String = getString(
            R.string.error_session_title

        ),
        message: String = getString(
            R.string.error_session_timeout_message

        )
    ) {
        DialogUtils
            .showInfoDialog(
                context = this,
                title = title,
                message = message,
                buttonName = dialogButtonText,
                cancelable = false,
                alertDialogListener = object : AlertDialogListener {
                    override fun onPositive() {
                        AppLogger.d(TAG, "onSessionExpired().onPositive()")
                    }

                    override fun onNegative() {
                        TODO("Not yet implemented")
                    }
                }
            )
    }

    override fun onStart() {
        super.onStart()
        subscribeSession()
    }

    override fun onStop() {
        unsubscribeSession()
        super.onStop()

    }

    override fun onDestroy() {
        super.onDestroy()

    }

    private fun setupPermissions() {

        val permission = ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.CAMERA
        )

        if (permission != PackageManager.PERMISSION_GRANTED) {
            AppLogger.i(TAG, "Permission to record denied")
            makeRequest()
        }
    }

    private fun makeRequest() {
        ActivityCompat.requestPermissions(this, permissions, RECORD_REQUEST_CODE)
    }
}