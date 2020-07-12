package com.example.aac.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.navArgs
import com.example.aac.R
import com.example.aac.databinding.SearchDetailFragmentBinding

class SearchDetailFragment : Fragment() {

    private val args: SearchDetailFragmentArgs by navArgs()

    private lateinit var viewModel: SearchDetailViewModel
    private val searchViewModel: SearchViewModel by activityViewModels()

    private lateinit var binding: SearchDetailFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.search_detail_fragment, container, false)
        searchViewModel.pointInfo.value?.let {
            binding.point = it[args.pointId.toInt()]
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SearchDetailViewModel::class.java)
    }

}