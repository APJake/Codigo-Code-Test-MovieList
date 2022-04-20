package com.apjake.codetestmovielist.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.apjake.codetestmovielist.adapter.PopularMovieListAdapter
import com.apjake.codetestmovielist.adapter.UpcomingMovieListAdapter
import com.apjake.codetestmovielist.common.base.BaseFragment
import com.apjake.codetestmovielist.databinding.FragmentHomeBinding
import com.apjake.codetestmovielist.mvvm.state.MovieListState
import com.apjake.codetestmovielist.mvvm.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment: BaseFragment<HomeViewModel>(){
    private val viewModelHome: HomeViewModel by viewModels()
    private lateinit var binding: FragmentHomeBinding
    private lateinit var popularMovieAdapter: PopularMovieListAdapter
    private lateinit var upcomingMovieAdapter: UpcomingMovieListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getMovies()
        setUpPopularSession()
        setUpUpcomingSession()
        init()
    }

    private fun init() {
        upcomingMovieAdapter.onItemClick = {item ->
            val action = HomeFragmentDirections.actionHomeFragmentToMovieDetailFragment(item)
            findNavController().navigate(action)
        }
        upcomingMovieAdapter.onItemCheck = {item, isCheck ->
            viewModelHome.toggleFavouriteMovie(item.id, isCheck)
        }
        popularMovieAdapter.onItemCheck = {item, isCheck ->
            viewModelHome.toggleFavouriteMovie(item.id, isCheck)
        }
        popularMovieAdapter.onItemClick = {item ->
            val action = HomeFragmentDirections.actionHomeFragmentToMovieDetailFragment(item)
            findNavController().navigate(action)
        }
    }

    private fun getMovies(){
        viewModelHome.getPopularMovieList()
        viewModelHome.getUpcomingMovieList()
    }

    private fun setUpPopularSession(){
        popularMovieAdapter = PopularMovieListAdapter(requireContext())
        binding.rcyPopularMovies.adapter = popularMovieAdapter
        viewModelHome.popularMovieListState.observe(viewLifecycleOwner){
            if(it is MovieListState.Loading){
                togglePopularMovies(true)
            }else{
                togglePopularMovies(false)
                when (it) {
                    is MovieListState.Loaded -> {
                        popularMovieAdapter.setNewDataList(it.movieList)
                    }
                    is MovieListState.Error -> {
                        // error
                    }
                    else -> {
                        // nth
                    }
                }
            }
        }
    }

    private fun setUpUpcomingSession(){
        upcomingMovieAdapter = UpcomingMovieListAdapter(requireContext())
        binding.rcyUpcomingMovies.adapter = upcomingMovieAdapter
        viewModelHome.upcomingMovieListState.observe(viewLifecycleOwner){
            if(it is MovieListState.Loading){
                toggleUpcomingMovies(true)
            }else{
                toggleUpcomingMovies(false)
                when (it) {
                    is MovieListState.Loaded -> {
                        upcomingMovieAdapter.setNewDataList(it.movieList)
                    }
                    is MovieListState.Error -> {
                        // error
                    }
                    else -> {
                        // nth
                    }
                }
            }
        }
    }

    private fun togglePopularMovies(isLoading: Boolean){
        var moviesVisibility = View.INVISIBLE
        var loadingVisibility = View.VISIBLE
        if(!isLoading){
            moviesVisibility = View.VISIBLE
            loadingVisibility = View.INVISIBLE
        }
        binding.pbPopularMoviesLoading.visibility = loadingVisibility
        binding.rcyPopularMovies.visibility = moviesVisibility
    }

    private fun toggleUpcomingMovies(isLoading: Boolean){
        var moviesVisibility = View.INVISIBLE
        var loadingVisibility = View.VISIBLE
        if(!isLoading){
            moviesVisibility = View.VISIBLE
            loadingVisibility = View.INVISIBLE
        }
        binding.pbUpcomingMoviesLoading.visibility = loadingVisibility
        binding.rcyUpcomingMovies.visibility = moviesVisibility
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun injectViewModel(): HomeViewModel = viewModelHome


}