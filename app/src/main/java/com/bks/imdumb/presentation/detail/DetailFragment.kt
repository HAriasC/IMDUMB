package com.bks.imdumb.presentation.detail

import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updateLayoutParams
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.bks.imdumb.R
import com.bks.imdumb.databinding.FragmentDetailBinding
import com.bks.imdumb.domain.model.Actor
import com.bks.imdumb.domain.model.Movie
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DetailFragment : Fragment(), DetailContract.View {

    @Inject
    lateinit var presenter: DetailPresenter

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Configuración inicial rápida con argumentos (mejora la percepción de velocidad)
        binding.tvMovieTitle.text = args.title
        binding.tvMovieRating.text = String.format("%.1f", args.rating)
        binding.tvMovieOverview.text = Html.fromHtml(args.overview, Html.FROM_HTML_MODE_LEGACY)

        // Ajusta el botón de atrás para respetar los insets de la barra de estado
        ViewCompat.setOnApplyWindowInsetsListener(binding.btnBack) { v, insets ->
            val statusBarHeight = insets.getInsets(WindowInsetsCompat.Type.statusBars()).top
            v.updateLayoutParams<ViewGroup.MarginLayoutParams> {
                topMargin = statusBarHeight + (16 * resources.displayMetrics.density).toInt()
            }
            insets
        }

        binding.rvActors.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        presenter.attachView(this)
        presenter.loadMovieDetails(args.movieId)
        presenter.checkFeatures()

        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.btnRecommend.setOnClickListener {
            showRecommendBottomSheet(args.title, args.overview)
        }
    }

    override fun showMovieDetails(movie: Movie) {
        binding.tvAgeClassification.text = if (movie.isAdult) "18+" else "G"
        binding.tvGenres.text = movie.genres.joinToString(", ")
    }

    private fun showRecommendBottomSheet(title: String, overview: String) {
        val bottomSheet = RecommendBottomSheet.newInstance(title, overview)
        bottomSheet.show(childFragmentManager, "RecommendBottomSheet")
    }

    override fun showImages(images: List<String>) {
        // Limita a 10 imágenes para optimizar el indicador de puntos y la memoria
        val limitedImages = images.take(10)
        binding.vpImages.adapter = ImageAdapter(limitedImages)
        
        // Vincula el TabLayout con ViewPager2 para los puntos de paginación
        TabLayoutMediator(binding.tlIndicator, binding.vpImages) { _, _ -> }.attach()
    }

    override fun showActors(actors: List<Actor>) {
        binding.rvActors.adapter = ActorAdapter(actors)
    }

    override fun setRecommendButtonVisibility(isVisible: Boolean) {
        binding.btnRecommend.visibility = if (isVisible) View.VISIBLE else View.GONE
    }

    override fun showLoading() {}

    override fun hideLoading() {}

    override fun showError(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    override fun onDestroyView() {
        presenter.detachView()
        super.onDestroyView()
        _binding = null
    }
}
