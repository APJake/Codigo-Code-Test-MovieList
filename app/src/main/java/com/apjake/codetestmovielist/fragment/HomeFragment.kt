package com.apjake.codetestmovielist.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.apjake.codetestmovielist.common.base.BaseFragment
import com.apjake.codetestmovielist.databinding.FragmentHomeBinding
import com.apjake.codetestmovielist.mvvm.viewmodel.HomeViewModel

class HomeFragment: BaseFragment<HomeViewModel>(){
    private val viewModel: HomeViewModel by viewModels()
    private lateinit var binding: FragmentHomeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.flPopularMovies
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun injectViewModel(): HomeViewModel = viewModel


}