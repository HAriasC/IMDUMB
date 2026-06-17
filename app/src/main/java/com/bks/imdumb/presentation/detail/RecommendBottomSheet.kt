package com.bks.imdumb.presentation.detail

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bks.imdumb.R
import com.bks.imdumb.databinding.BottomSheetRecommendBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.snackbar.Snackbar

class RecommendBottomSheet : BottomSheetDialogFragment() {

    private var movieTitle: String? = null
    private var overview: String? = null
    private var _binding: BottomSheetRecommendBinding? = null
    private val binding get() = _binding!!

    companion object {
        private const val ARG_TITLE = "movie_title"
        private const val ARG_OVERVIEW = "overview"

        fun newInstance(title: String, overview: String): RecommendBottomSheet {
            val fragment = RecommendBottomSheet()
            val args = Bundle().apply {
                putString(ARG_TITLE, title)
                putString(ARG_OVERVIEW, overview)
            }
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        movieTitle = arguments?.getString(ARG_TITLE)
        overview = arguments?.getString(ARG_OVERVIEW)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BottomSheetRecommendBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvSheetTitle.text = movieTitle
        binding.tvSheetOverview.text = overview

        binding.btnConfirm.setOnClickListener {
            val comment = binding.etComment.text.toString()
            if (comment.isNotBlank()) {
                showSuccessMessage()
                dismiss()
            } else {
                Toast.makeText(context, getString(R.string.recommend_error_empty), Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnShare.setOnClickListener {
            val comment = binding.etComment.text.toString()
            shareRecommendation(comment)
        }
    }

    private fun showSuccessMessage() {
        parentFragment?.view?.let {
            Snackbar.make(it, getString(R.string.recommend_success), Snackbar.LENGTH_LONG).show()
        }
    }

    private fun shareRecommendation(comment: String) {
        val shareText = buildString {
            append(getString(R.string.share_subject))
            append("\n\n")
            append("Película: $movieTitle")
            append("\n\n")
            if (comment.isNotBlank()) {
                append("Mi comentario: $comment")
                append("\n\n")
            }
            append("Sinopsis: $overview")
        }

        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, shareText)
        }
        startActivity(Intent.createChooser(intent, getString(R.string.recommend_share)))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
