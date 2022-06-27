package com.example.fragment_api_demo3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.example.fragment_api_demo3.databinding.FragmentSecoundBinding

class SecoundFragment : Fragment() {

    private lateinit var binding: FragmentSecoundBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSecoundBinding.inflate(inflater, container, false)
        gotoPreviousScreen()
        return binding.root
    }

    private fun gotoPreviousScreen() {
        binding.btnSend.setOnClickListener {
            val userinput = binding.edtName.text.toString()
            setFragmentResult(
                AppConstants.REQUEST_KEY,
                bundleOf(AppConstants.BUNDLE_KEY to userinput)
            )
            findNavController().navigateUp()

        }
    }

}