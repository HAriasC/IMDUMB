package com.bks.imdumb.presentation.main

import com.bks.imdumb.domain.model.Movie
import com.bks.imdumb.domain.usecase.GetHomeCategoriesUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * SOLID: Single Responsibility Principle (SRP)
 * Este Presenter solo se encarga de la lógica de presentación de la pantalla principal,
 * delegando la obtención de datos al Caso de Uso y la renderización a la Vista.
 */
class HomePresenter @Inject constructor(
    private val getHomeCategoriesUseCase: GetHomeCategoriesUseCase
) : HomeContract.Presenter {

    private var view: HomeContract.View? = null
    private val disposables = CompositeDisposable()

    override fun attachView(view: HomeContract.View) {
        this.view = view
    }

    override fun detachView() {
        disposables.clear()
        this.view = null
    }

    override fun loadHomeData() {
        view?.hideErrorState()
        view?.showLoading()
        getHomeCategoriesUseCase.execute()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onSuccess = { categories ->
                    view?.hideLoading()
                    view?.showCategories(categories)
                },
                onError = { error ->
                    view?.hideLoading()
                    view?.showErrorState(error.message ?: "Error desconocido")
                }
            ).addTo(disposables)
    }

    override fun onMovieClicked(movie: Movie) {
        view?.navigateToDetail(movie)
    }
}
