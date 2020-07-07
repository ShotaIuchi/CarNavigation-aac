package com.example.aac.ui.main

import android.Manifest
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.*
import androidx.navigation.Navigation
import com.example.aac.R
import com.example.aac.databinding.TopFragmentBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import permissions.dispatcher.*


@RuntimePermissions
class TopFragment : Fragment() {

    companion object {
        fun newInstance() = TopFragment()
    }

    private lateinit var binding: TopFragmentBinding

    private val viewModel = activityViewModels<TopViewModel>()

    private val toastModel = activityViewModels<ToastViewModel>()

    private val fragmentViewModel = activityViewModels<FragmentViewModel>()



    // permission
    @OnShowRationale(Manifest.permission.CAMERA)
    fun cameraRequest(request: PermissionRequest) {
        showRationaleDialog(
            requireContext(),
            request,
            "カメラを利用してもよかですか？"
        )
    }
    @NeedsPermission(Manifest.permission.CAMERA)
    fun cameraOk() {
        Toast.makeText(context, "にっこり", Toast.LENGTH_SHORT).show()
    }
    @OnPermissionDenied(Manifest.permission.CAMERA)
    fun cameraNg() {
        Toast.makeText(context, "なんで？", Toast.LENGTH_SHORT).show()
    }
    @OnNeverAskAgain(Manifest.permission.CAMERA)
    fun cameraNgNever() {
        Toast.makeText(context, "なんで？どうして？", Toast.LENGTH_SHORT).show()
    }
    @OnShowRationale(Manifest.permission.READ_CONTACTS, Manifest.permission.WRITE_CONTACTS)
    fun contactsRequest(request: PermissionRequest) {
        showRationaleDialog(
            requireContext(),
            request,
            "連絡先でちょこっとあれしたいです"
        )
    }
    @NeedsPermission(Manifest.permission.READ_CONTACTS, Manifest.permission.WRITE_CONTACTS)
    fun contactsOk() {
        Toast.makeText(context, "にっこり", Toast.LENGTH_SHORT).show()
    }
    @OnPermissionDenied(Manifest.permission.READ_CONTACTS, Manifest.permission.WRITE_CONTACTS)
    fun contactsNg() {
        Toast.makeText(context, "なんで？", Toast.LENGTH_SHORT).show()
    }
    @OnNeverAskAgain(Manifest.permission.READ_CONTACTS, Manifest.permission.WRITE_CONTACTS)
    fun contactsNgNever() {
        Toast.makeText(context, "なんで？どうして？", Toast.LENGTH_SHORT).show()
    }
    // permission


    class TopObserver : LifecycleObserver {
        @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
        fun connect() {

        }

        @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
        fun disconnect() {

        }
    }

    // permission
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        onRequestPermissionsResult(requestCode, grantResults)
    }
    // permission

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.top_fragment, container, false)
        // permission
        binding.button1.setOnClickListener { cameraOkWithPermissionCheck() }
        binding.button2.setOnClickListener { contactsOkWithPermissionCheck() }
        // permission
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