package com.example.aac.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aac.R
import com.example.aac.adapter.SearchListAdapter
import com.example.aac.databinding.SearchFragmentBinding


class SearchFragment : Fragment() {

    private lateinit var binding: SearchFragmentBinding

    private val viewModel: SearchViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.search_fragment, container, false)
        val adapter = SearchListAdapter()
        binding.searchList.adapter = adapter
        binding.searchList.addItemDecoration(DividerItemDecoration(context, LinearLayoutManager(context).orientation)) // divider
        viewModel.pointInfo.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
        viewModel.search()
        return binding.root
    }
}