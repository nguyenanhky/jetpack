package com.example.navigaio_demo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_fist.*

class FistFramgment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fist, container, false)
    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//
//        val controller = findNavController()
//
//        btn_opent_fragment_two.setOnClickListener {
//            //controller.navigate(R.id.secoundFragment)// chuyen doi giua cac video
//            // truyen simple data
//            val bundle = bundleOf(
//                "username"  to edt_name.text.toString()
//            )
//            controller.navigate(R.id.secoundFragment,bundle)
//
//            // truyen data onject
//            val user = User(edt_name.text.toString(),edt_age.text.toString().toInt())
//
//            val bundle = bundleOf(
//                "user" to user
//            )
//            controller.navigate(R.id.secoundFragment,bundle)
//        }
//
//        btn_opent_fragment_three.setOnClickListener {
//            controller.navigate(R.id.threeFragment)
//        }
//    }
}