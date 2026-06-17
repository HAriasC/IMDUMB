package com.bks.imdumb.presentation.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bks.imdumb.databinding.FragmentSplashBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SplashFragment : Fragment(), SplashContract.View {

    @Inject
    lateinit var presenter: SplashPresenter

    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attachView(this)
        presenter.initConfig()
    }

    override fun showWelcomeMessage(message: String) {
        binding.tvWelcomeMessage.text = message
    }

    override fun navigateToMain() {
        findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToHomeFragment())
    }

    override fun showLoading() {
        binding.pbSplash.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        binding.pbSplash.visibility = View.GONE
    }

    override fun showError(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    override fun onDestroyView() {
        presenter.detachView()
        super.onDestroyView()
        _binding = null
    }
}
