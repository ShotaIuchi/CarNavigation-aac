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
import com.example.aac.databinding.YrtFragmentBinding

class YrtFragment : Fragment() {

    companion object {
        fun newInstance() = YrtFragment()
    }

    private lateinit var binding: YrtFragmentBinding
    private lateinit var viewModel: YrtViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.yrt_fragment, container, false)
        binding.yrt.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_yrtFragment_to_nrtFragment))
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(YrtViewModel::class.java)
        // TODO: Use the ViewModel
    }

}