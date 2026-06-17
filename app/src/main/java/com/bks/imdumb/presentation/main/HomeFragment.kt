package com.bks.imdumb.presentation.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updateLayoutParams
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bks.imdumb.databinding.FragmentHomeBinding
import com.bks.imdumb.domain.model.Movie
import com.bks.imdumb.domain.model.MovieCategory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment(), HomeContract.View {

    @Inject
    lateinit var presenter: HomePresenter

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewPool = RecyclerView.RecycledViewPool()
    
    private lateinit var categoryAdapter: CategoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        setupRecyclerView()
        
        // Handle Insets for the custom header
        ViewCompat.setOnApplyWindowInsetsListener(binding.headerContainer) { v, insets ->
            val statusBarHeight = insets.getInsets(WindowInsetsCompat.Type.statusBars()).top
            v.updateLayoutParams<ViewGroup.MarginLayoutParams> {
                topMargin = statusBarHeight
            }
            insets
        }

        binding.btnRetry.setOnClickListener {
            presenter.loadHomeData()
        }

        presenter.attachView(this)
        presenter.loadHomeData()
    }

    private fun setupRecyclerView() {
        categoryAdapter = CategoryAdapter(viewPool) { movie ->
            presenter.onMovieClicked(movie)
        }
        binding.rvCategories.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = categoryAdapter
        }
    }

    override fun showCategories(categories: List<MovieCategory>) {
        categoryAdapter.submitList(categories)
        binding.rvCategories.visibility = View.VISIBLE
    }

    override fun navigateToDetail(movie: Movie) {
        val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(
            movieId = movie.id,
            title = movie.title,
            rating = movie.rating.toFloat(),
            overview = movie.overview
        )
        findNavController().navigate(action)
    }

    override fun showErrorState(message: String) {
        binding.rvCategories.visibility = View.GONE
        binding.errorLayout.visibility = View.VISIBLE
        binding.tvErrorMessage.text = message
    }

    override fun hideErrorState() {
        binding.errorLayout.visibility = View.GONE
    }

    override fun showLoading() {
        binding.progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        binding.progressBar.visibility = View.GONE
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
