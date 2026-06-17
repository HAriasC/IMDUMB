package com.bks.imdumb.presentation.detail

import com.bks.imdumb.domain.model.Actor
import com.bks.imdumb.domain.model.Movie
import com.bks.imdumb.presentation.common.BasePresenter
import com.bks.imdumb.presentation.common.BaseView

interface DetailContract {
    interface View : BaseView {
        fun showMovieDetails(movie: Movie)
        fun showImages(images: List<String>)
        fun showActors(actors: List<Actor>)
        fun setRecommendButtonVisibility(isVisible: Boolean)
    }

    interface Presenter : BasePresenter<View> {
        fun loadMovieDetails(movieId: Int)
        fun checkFeatures()
    }
}
