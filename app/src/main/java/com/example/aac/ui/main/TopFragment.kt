package com.example.aac.ui.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.*
import androidx.navigation.Navigation
import com.example.aac.R
import com.example.aac.databinding.TopFragmentBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class TopFragment : Fragment() {

    companion object {
        fun newInstance() = TopFragment()
    }

    private lateinit var binding: TopFragmentBinding

    private val viewModel = activityViewModels<TopViewModel>()

    private val toastModel = activityViewModels<ToastViewModel>()

    private val fragmentViewModel = activityViewModels<FragmentViewModel>()


    class TopObserver : LifecycleObserver {
        @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
        fun connect() {

        }

        @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
        fun disconnect() {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.top_fragment, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        toastModel.value.data.observe(viewLifecycleOwner, Observer {
            if (it.isShow == ToastViewModel.Show.CAN_SHOW) {
                Navigation.findNavController(binding.fragmentContainerToast).navigate(R.id.action_blankFragment_to_toastFragment)
            }
        })


        fragmentViewModel.value.toast.observe(viewLifecycleOwner, Observer {
            if (it) {
                fragmentViewModel.value.toast.postValue(false)
                Navigation.findNavController(binding.fragmentContainerToast).navigate(R.id.action_blankFragment_to_toastFragment)
            }
        })

        fragmentViewModel.value.dialog.observe(viewLifecycleOwner, Observer {
            if (it) {
                fragmentViewModel.value.dialog.postValue(false)
                //Navigation.findNavController(binding.fragmentContainerDialog).navigate(R.id.)
            }
        })



        //viewModel = ViewModelProviders.of(this).get(TopViewModel::class.java)

        //toastModel.value.data!!.observe(viewLifecycleOwner, Observer {
            //Navigation.findNavController(binding.fragmentContainerToast).navigate(R.id.action_blankFragment_to_toastFragment)
        //})

        GlobalScope.launch {
            delay(2000)

            /*
            lifecycle.addObserver(object : LifecycleObserver {
                @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
                fun connect() {
                    Log.d("TEST", "[1]")
                    toastModel.value.show(ToastViewModel.Data("aaa", 2000))

                    Navigation.findNavController(binding.fragmentContainerToast).navigate(R.id.action_blankFragment_to_toastFragment)
                }
            })*/


            //toastModel.value.show(ToastViewModel.Data("TOAST-MSG", 2000))
        }
    }

}