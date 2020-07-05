package com.example.aac.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.aac.R
import com.example.aac.databinding.ToastFragmentBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ToastFragment : Fragment() {

    private lateinit var binding: ToastFragmentBinding

    private val viewModel by activityViewModels<ToastViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.toast_fragment, container, false)
        viewModel.data.value?.let {
            binding.myself = it.data
            viewModel.showed()
        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        GlobalScope.launch {
            //viewModel.data?.let { delay(it.value!!.time) }

            delay(3000)
            lifecycle.addObserver(object : LifecycleObserver {
                @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
                fun connect() {
                    viewModel.reset()
                    lifecycle.removeObserver(this)
                    Log.d("TEST", "[10]")
                    findNavController().navigate(R.id.action_toastFragment_pop)
                }
            })
        }
    }

}