package tn.esprit.examenandroidfahd.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import tn.esprit.examenandroidfahd.adapters.MovieAdapter
import tn.esprit.examenandroidfahd.R
import tn.esprit.examenandroidfahd.databinding.FragmentMovieBinding
import tn.esprit.examenandroidfahd.models.Movie

class MovieFragment : Fragment() {

    private lateinit var binding: FragmentMovieBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentMovieBinding.inflate(layoutInflater)

        binding.rvNews.adapter = MovieAdapter(getListNews(requireContext()))
        binding.rvNews.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        return binding.root
    }
    private fun getListNews(context: Context) : MutableList<Movie> {
        return mutableListOf(
            Movie(1, R.drawable.ic_movie1, context.getString(R.string.movie1) , context.getString(R.string.movieDesc1)),
            Movie(2, R.drawable.ic_movie1, context.getString(R.string.movie1) , context.getString(R.string.movieDesc1)),
            Movie(3, R.drawable.ic_movie1, context.getString(R.string.movie1) , context.getString(R.string.movieDesc1))
        )
    }
}