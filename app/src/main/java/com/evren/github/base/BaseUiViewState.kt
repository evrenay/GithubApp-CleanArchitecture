package com.evren.github.base

import android.view.View

open class BaseUiViewState {
    fun getViewVisibility(isVisible: Boolean) = if (isVisible) View.VISIBLE else View.GONE
}