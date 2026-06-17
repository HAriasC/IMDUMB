package com.bks.imdumb.presentation.detail

import com.bks.imdumb.data.datasource.ConfigManager
import com.bks.imdumb.domain.repository.MovieRepository
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class DetailPresenter @Inject constructor(
    private val repository: MovieRepository,
    private val configManager: ConfigManager
) : DetailContract.Presenter {

    private var view: DetailContract.View? = null
    private val disposables = CompositeDisposable()

    override fun attachView(view: DetailContract.View) {
        this.view = view
    }

    override fun detachView() {
        disposables.clear()
        this.view = null
    }

    override fun loadMovieDetails(movieId: Int) {
        view?.showLoading()
        
        Single.zip(
            repository.getMovieDetails(movieId),
            repository.getMovieImages(movieId),
            repository.getMovieCredits(movieId)
        ) { movie, images, actors -> Triple(movie, images, actors) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onSuccess = { data ->
                    view?.hideLoading()
                    view?.showMovieDetails(data.first)
                    view?.showImages(data.second)
                    view?.showActors(data.third)
                },
                onError = { error ->
                    view?.hideLoading()
                    view?.showError(error.message ?: "Error al cargar detalles")
                }
            ).addTo(disposables)
    }

    override fun checkFeatures() {
        val isVisible = configManager.getBoolean("show_recommendation_button", true)
        view?.setRecommendButtonVisibility(isVisible)
    }
}
