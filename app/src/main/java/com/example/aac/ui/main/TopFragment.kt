package com.example.aac.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
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

    private lateinit var viewModel: TopViewModel

    private var toastModel = activityViewModels<ToastViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.top_fragment, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(TopViewModel::class.java)

        toastModel.value.data!!.observe(viewLifecycleOwner, Observer {
            Navigation.findNavController(binding.fragmentContainerToast).navigate(R.id.action_blankFragment_to_toastFragment)
        })

        GlobalScope.launch {
            delay(5000)
            toastModel.value.show(ToastViewModel.Data("TOAST-MSG", 2000))
        }
    }

}