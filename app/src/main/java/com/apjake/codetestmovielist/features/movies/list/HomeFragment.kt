package com.apjake.codetestmovielist.features.movies.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.apjake.codetestmovielist.common.base.BaseFragment
import com.apjake.codetestmovielist.databinding.FragmentHomeBinding
import com.apjake.codetestmovielist.features.movies.list.HomeUiEvent.ShowErrorSnackBar
import com.apjake.codetestmovielist.features.movies.list.HomeUiEvent.ShowErrorToast
import com.apjake.codetestmovielist.features.movies.list.adapter.DashboardAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class HomeFragment: BaseFragment<FragmentHomeBinding,HomeViewModel>(){
    private lateinit var dashboardAdapter: DashboardAdapter

    override val mainViewModel: HomeViewModel by viewModels()
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding
        get() = { inflater, container, isAttach ->
            FragmentHomeBinding.inflate(inflater, container, isAttach)
        }

    override fun setUp() {
        setUpSwipeRefresh()
        setUpDashboardAdapter()
    }

    override fun observeState() {
        lifecycleScope.launchWhenResumed {
            mainViewModel.state.collectLatest { state ->
                dashboardAdapter.submitList(state.dashboardItems)
                binding.swipeDashboard.isRefreshing = state.isLoading
            }
        }
    }

    override fun observeEvent() {
        lifecycleScope.launchWhenStarted {
            mainViewModel.event.collectLatest { event ->
                when(event){
                    is ShowErrorSnackBar -> showErrorSnackBar(event.message){
                        mainViewModel.fetchMovieList()
                    }
                    is ShowErrorToast -> showToastMessage(event.message)
                }
            }
        }
    }

    private fun setUpDashboardAdapter(){
        dashboardAdapter = DashboardAdapter(
            context = requireContext(),
            onFavouriteChanged = { item, isCheck ->
                mainViewModel.toggleFavouriteMovie(item.id, isCheck)
            },
            onMovieClick = { item ->
                val action = HomeFragmentDirections.actionHomeFragmentToMovieDetailFragment(item)
                findNavController().navigate(action)
            }
        )
        binding.rcyDashboard.adapter = dashboardAdapter
    }

    private fun setUpSwipeRefresh(){
        binding.swipeDashboard.setOnRefreshListener {
            mainViewModel.fetchMovieList()
        }
    }

}