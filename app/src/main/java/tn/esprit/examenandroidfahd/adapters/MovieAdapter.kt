package tn.esprit.examenandroidfahd.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import tn.esprit.examenandroidfahd.databinding.SingleItemMovieBinding
import tn.esprit.examenandroidfahd.models.Movie

class MovieAdapter (val movieList: MutableList<Movie>): RecyclerView.Adapter<MovieAdapter.MovieHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val binding = SingleItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        with(holder){

            with(movieList[position]){
                binding.newsTitle.text = title
                binding.newsDescription.text = description
                binding.newsImage.setImageResource(imageRes)

            }
        }
    }



    override fun getItemCount() = movieList.size



    inner class MovieHolder(val binding: SingleItemMovieBinding) : RecyclerView.ViewHolder(binding.root)
}
