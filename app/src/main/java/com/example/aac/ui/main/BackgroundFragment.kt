package com.example.aac.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.aac.R
import com.example.aac.databinding.BackgroundFragmentBinding

class BackgroundFragment : Fragment() {

    private lateinit var binding: BackgroundFragmentBinding

    private var viewModel = activityViewModels<BackgroundViewModel>()

    private val fragmentViewModel = activityViewModels<FragmentViewModel>()
    private val toastModel = activityViewModels<ToastViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.background_fragment, container, false)
        //binding.toast.setOnClickListener{fragmentViewModel.value.toast.postValue(true)}
        binding.toast.setOnClickListener{toastModel.value.doShow(ToastViewModel.Data("MMM", 10000))}
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

}