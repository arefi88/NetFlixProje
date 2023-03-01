package com.example.maktabnetflixproje.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.maktabnetflixproje.data.Movie
import com.example.maktabnetflixproje.databinding.ItemHomeFragmentBinding

class HomeFragmentAdapter(private val list:List<Movie>) :RecyclerView.Adapter<HomeFragmentAdapter.MovieViewHolder>() {
   inner class MovieViewHolder(private val itemBinding:ItemHomeFragmentBinding) : RecyclerView.ViewHolder(itemBinding.root){
         fun bindItem(movie: Movie){
             itemBinding.txtName.text=movie.name

         }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding=ItemHomeFragmentBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MovieViewHolder(binding)
    }

    override fun getItemCount() = list.size



    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
      val movie=list[position]
        holder.bindItem(movie)
    }
}