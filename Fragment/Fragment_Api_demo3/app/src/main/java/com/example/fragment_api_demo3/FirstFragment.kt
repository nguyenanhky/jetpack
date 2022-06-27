package com.example.fragment_api_demo3

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.example.fragment_api_demo3.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    private lateinit var bindding:FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bindding = FragmentFirstBinding.inflate(inflater, container, false)
        navigateToSecoundScreen()
        setFragmnetListener()
        return bindding.root

    }

    private fun setFragmnetListener() {
        setFragmentResultListener(AppConstants.REQUEST_KEY){requestKey, bundle ->  
            val result = bundle.getString(AppConstants.BUNDLE_KEY)
            bindding.txtResult.text = result
        }
    }

    private fun navigateToSecoundScreen() {
        bindding.btnResult.setOnClickListener {
            findNavController().navigate(FirstFragmentDirections.actionFirstFragmentToSecoundFragment())
        }
    }
}