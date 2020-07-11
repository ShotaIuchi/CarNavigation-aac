package com.example.aac.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.observe
import androidx.lifecycle.ViewModelProvider
import com.example.aac.R
import com.example.aac.databinding.BackgroundFragmentBinding
import com.example.aac.lib.AacMxpHandle
import com.example.aac.lib.AacMxpViewModel

class BackgroundFragment : Fragment() {

    private lateinit var binding: BackgroundFragmentBinding

    private var viewModel = activityViewModels<BackgroundViewModel>()

    private val fragmentViewModel = activityViewModels<FragmentViewModel>()
    private val toastModel = activityViewModels<ToastViewModel>()

    private val aacMxpViewModel : AacMxpViewModel by activityViewModels()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.background_fragment, container, false)
        binding.aacMxpViewModel = aacMxpViewModel
        //binding.toast.setOnClickListener{fragmentViewModel.value.toast.postValue(true)}
        binding.toast.setOnClickListener{toastModel.value.doShow(ToastViewModel.Data("MMM", 10000))}

//        aacMxpViewModel.mxpHandle.observe(viewLifecycleOwner, Observer {
//            it?.let {
//                // わんたいむ通知に帰る必要あり？
//                Toast.makeText(context, it.xxx.toString(), Toast.LENGTH_SHORT).show()
//            }
//        })
        aacMxpViewModel.mxpHandle.observe(viewLifecycleOwner) { it : AacMxpHandle? ->
            it?.let {
                Toast.makeText(context, it.xxx.toString(), Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

}
