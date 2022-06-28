package com.evren.github.base

import android.content.Context
import com.evren.github.R
import com.evren.github.common.Status

class StatusViewState(
    val status: Status
) : BaseUiViewState() {

    fun getProgressBarVisibility() = getViewVisibility(status is Status.Loading)

    fun getErrorMessage(context: Context) = if (status is Status.Error) status.exception.message else context.getString(
        R.string.something_went_wrong)

    fun getErrorVisibility() = getViewVisibility(status is Status.Error)

    fun shouldShowContent() = getViewVisibility(status is Status.Content)
}