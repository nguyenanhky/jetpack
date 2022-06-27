package com.example.navigation_demo1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_fist.*
import kotlinx.android.synthetic.main.fragment_secound.*
import kotlinx.android.synthetic.main.fragment_secound.btn_opent_fragment_three

class SecoundFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_secound, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val controller = findNavController()
        btn_opent_fragment_three.setOnClickListener {
            controller.navigate(R.id.threeFragment)
        }


    }
}