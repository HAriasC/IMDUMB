package com.bks.imdumb.presentation.main

import com.bks.imdumb.domain.model.Movie
import com.bks.imdumb.domain.model.MovieCategory
import com.bks.imdumb.presentation.common.BasePresenter
import com.bks.imdumb.presentation.common.BaseView

/**
 * SOLID: Interface Segregation Principle (ISP)
 * Se definen interfaces específicas para la Vista y el Presenter,
 * asegurando que cada componente solo conozca los métodos que realmente necesita.
 */
interface HomeContract {
    interface View : BaseView {
        fun showCategories(categories: List<MovieCategory>)
        fun navigateToDetail(movie: Movie)
        fun showErrorState(message: String)
        fun hideErrorState()
    }

    interface Presenter : BasePresenter<View> {
        fun loadHomeData()
        fun onMovieClicked(movie: Movie)
    }
}
