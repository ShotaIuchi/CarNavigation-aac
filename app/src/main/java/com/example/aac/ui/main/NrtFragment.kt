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
import com.example.aac.databinding.NrtFragmentBinding
import com.example.aac.databinding.SuperRtFragmentBinding

class NrtFragment : Fragment() {

    companion object {
        fun newInstance() = NrtFragment()
    }

    private lateinit var binding: NrtFragmentBinding
    private lateinit var viewModel: NrtViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.nrt_fragment, container, false)
        binding.nrt.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_nrtFragment_to_yrtFragment))
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(NrtViewModel::class.java)
        // TODO: Use the ViewModel
    }

}