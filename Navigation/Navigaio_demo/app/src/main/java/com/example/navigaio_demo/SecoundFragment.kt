package com.example.navigaio_demo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_secound.*

class SecoundFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_secound, container, false)
    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//
//        val controller = findNavController()
//
//        val bundle = arguments
//        val username = bundle?.getString("username")
//        txt_name.text = username
//        val user = bundle?.getSerializable("user") as User
//        txt_name.text = user.toString()
//        btn_opent_fragment_three.setOnClickListener {
//            controller.navigate(R.id.action_secoundFragment_to_threeFragment)
//        }
//    }

}