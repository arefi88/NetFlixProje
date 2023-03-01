package com.example.maktabnetflixproje

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.maktabnetflixproje.data.MovieList
import com.example.maktabnetflixproje.databinding.FragmentHomeBinding
import com.example.maktabnetflixproje.home.HomeFragmentAdapter

class HomeFragment : Fragment(R.layout.fragment_home) {
    private var _binding:FragmentHomeBinding?=null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding=FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val movieAdapter=HomeFragmentAdapter(MovieList.movieList)
        binding.rvHome.apply {
            setHasFixedSize(true)
            layoutManager=GridLayoutManager(activity,3)
            adapter=movieAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}