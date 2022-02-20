package com.xd.ihsan.coffee.utils.dialog

import android.content.Context
import android.content.DialogInterface
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import com.xd.ihsan.core.utils.extentions.AppLogger
import com.xd.ihsan.core.utils.extentions.empty
import com.xd.ihsan.core.utils.listener.AlertDialogListListener
import com.xd.ihsan.core.utils.listener.AlertDialogListener
import com.xd.ihsan.coffee.R

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
object DialogUtils {
    private const val OK = "OK"
    private const val CANCEL = "Cancel"

    // TODO | THIS SHOULDN'T BE IN STATIC/OBJECT SCOPE, SUGGEST A BETTER SOLUTION
    private var alertDialog: AlertDialog? = null

    fun twoButtonDialog(
        context: Context?,
        title: String = String.empty,
        message: String,
        alertDialogListener: AlertDialogListener,
        positiveButtonText: String = context?.getString(R.string.dialog_ok)
            ?: OK,
        negativeButtonText: String = context?.getString(R.string.dialog_cancel)
            ?: CANCEL,
        cancelable: Boolean
    ) {
        dismiss()

        context?.let {
            alertDialog = AlertDialog
                .Builder(it)
                .setTitle(title.trim())
                .setMessage(message)
                .setCancelable(cancelable)
                .setPositiveButton(positiveButtonText) { _, _ ->
                    alertDialogListener.onPositive()
                }

                .setNegativeButton(negativeButtonText) { _, _ ->
                    alertDialogListener.onNegative()
                }
                .create()
                .apply {
                    show()
                    getButton(DialogInterface.BUTTON_POSITIVE).isAllCaps = false
                    getButton(DialogInterface.BUTTON_NEGATIVE).isAllCaps = false
                }
        }
    }

    fun showInfoDialog(
        context: Context?,
        title: String = String.empty,
        message: String = String.empty,
        cancelable: Boolean = true,
        alertDialogListener: AlertDialogListener = object :
            AlertDialogListener {
            override fun onNegative() {}
            override fun onPositive() {}
        },
        buttonName: String = context?.getString(android.R.string.ok) ?: OK
    ) {
        dismiss()

        context?.let {
            alertDialog = AlertDialog
                .Builder(it)
                .setTitle(title.trim())
                .setMessage(message)
                .setCancelable(cancelable)
                .setPositiveButton(buttonName) { _, _ ->
                    alertDialogListener.onPositive()
                }
                .show()
        }
    }

    fun showListDialog(
        context: Context?,
        optionsList: MutableList<String>,
        title: String ,
        message: String,
        alertDialogListListener: AlertDialogListListener = object :
            AlertDialogListListener {
            override fun onOptionSelected(selectedOption: Int) {}
        },


    ) {
        dismiss()
        context?.let {
            val arrayAdapter = ArrayAdapter<String>(
                context,
                R.layout.select_item_dialog_material_row
            )
            arrayAdapter.addAll(optionsList)

            alertDialog = AlertDialog
                .Builder(context)
                .setTitle(title.trim())
                .setMessage(message)
                .setOnCancelListener {
                    alertDialogListListener.onCancelled()
                }
                .setAdapter(arrayAdapter) { _, which ->
                    alertDialogListListener.onOptionSelected(selectedOption = which)
                }.show()
        }
    }

    fun dismiss() {
        try {
            alertDialog?.dismiss()
        } catch (e: Exception) {
            AppLogger.e(
                "Exception",
                "Ignore the dialog dismiss when there is no window"
            )
        }
    }
}