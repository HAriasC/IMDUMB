package com.bks.imdumb.presentation.splash

import com.bks.imdumb.data.datasource.ConfigManager
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class SplashPresenter @Inject constructor(
    private val remoteConfig: FirebaseRemoteConfig,
    private val configManager: ConfigManager
) : SplashContract.Presenter {

    private var view: SplashContract.View? = null
    private val disposables = CompositeDisposable()

    override fun attachView(view: SplashContract.View) {
        this.view = view
    }

    override fun detachView() {
        disposables.clear()
        this.view = null
    }

    override fun initConfig() {
        view?.showLoading()
        
        // Muestra el mensaje guardado de sesiones anteriores para carga inmediata
        val currentMsg = configManager.getString("welcome_message")
        if (currentMsg.isNotEmpty()) {
            view?.showWelcomeMessage(currentMsg)
        }

        remoteConfig.fetchAndActivate()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val welcomeMsg = remoteConfig.getString("welcome_message")
                    val showRecommend = remoteConfig.getBoolean("show_recommendation_button")
                    
                    configManager.saveString("welcome_message", welcomeMsg)
                    configManager.saveBoolean("show_recommendation_button", showRecommend)
                    
                    // Actualiza la UI con el nuevo mensaje desde Firebase
                    view?.showWelcomeMessage(welcomeMsg)
                }
                
                // Asegura que el splash dure al menos 2 segundos para presencia de marca
                Completable.timer(2, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
                    .subscribe {
                        view?.hideLoading()
                        view?.navigateToMain()
                    }.addTo(disposables)
            }
    }
}
