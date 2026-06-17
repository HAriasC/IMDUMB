package com.bks.imdumb.presentation.splash

import com.bks.imdumb.presentation.common.BasePresenter
import com.bks.imdumb.presentation.common.BaseView

interface SplashContract {
    interface View : BaseView {
        fun showWelcomeMessage(message: String)
        fun navigateToMain()
    }

    interface Presenter : BasePresenter<View> {
        fun initConfig()
    }
}
