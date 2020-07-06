package com.example.aac.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.aac.R
import com.example.aac.databinding.SuperRtFragmentBinding

class SuperRtFragment : Fragment() {

    companion object {
        fun newInstance() = SuperRtFragment()
    }

    private lateinit var binding: SuperRtFragmentBinding

    private lateinit var viewModel: SuperRtViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.super_rt_fragment, container, false)
        binding.yrt.setOnClickListener{Navigation.findNavController(binding.fragmentSuperRt).navigate(R.id.action_nrtFragment_to_yrtFragment)}
        binding.nrt.setOnClickListener{Navigation.findNavController(binding.fragmentSuperRt).navigate(R.id.action_yrtFragment_to_nrtFragment)}
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SuperRtViewModel::class.java)
        // TODO: Use the ViewModel
    }

}