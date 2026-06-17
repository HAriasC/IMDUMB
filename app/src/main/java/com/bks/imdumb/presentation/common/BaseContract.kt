package com.bks.imdumb.presentation.common

interface BaseView {
    fun showLoading()
    fun hideLoading()
    fun showError(message: String)
}

interface BasePresenter<V : BaseView> {
    fun attachView(view: V)
    fun detachView()
}
