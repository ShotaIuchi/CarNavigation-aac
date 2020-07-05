package com.example.aac.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.example.aac.R
import com.example.aac.databinding.DialogFragmentBinding
import com.example.aac.databinding.ToastFragmentBinding

class DialogFragment : Fragment() {

    private lateinit var binding: DialogFragmentBinding

    private val viewModel by activityViewModels<DialogViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.dialog_fragment, container, false)
        binding.myself = viewModel
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

}