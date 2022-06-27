package com.example.fragment_api

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_a.*
import kotlinx.android.synthetic.main.fragment_b.*
import kotlinx.android.synthetic.main.fragment_a.edt_address as edt_address1


class Fragment_b : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_send. setOnClickListener {
            try {
                val number = edt_address.text.toString().toInt()
                setFragmentResult (Fragment_a.REQUEST_KEY, bundleOf(ParentFragment.KEY_NUMBER to number))
            } catch (exception: NumberFormatException) {
                Toast.makeText(
                    requireContext(),
                    R.string.invalid_number_error,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        val controller = findNavController()
//
//        btn_send.setOnClickListener {
//            val result = "result"
//            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
//            Log.d("str", "onViewCreated: ")
//            controller.navigate(R.id.fragment_a)
//        }
//    }

//    class ParentFragment : Fragment(R.layout.fragment_parent) {
//        override fun onCreate(savedInstanceState: Bundle?) {
//            super.onCreate(savedInstanceState) childFragmentManager . setFragmentResultListener (REQUEST_KEY, this, FragmentResultListener { requestKey, result ->
//                val number =
//                    result.getInt(KEY_NUMBER) textParentNumber . text = getString (R.string.result_listener_number_message, number)
//            }) childFragmentManager.beginTransaction() .add(R.id.childFragment, ChildFragment::class.java, null) .commit()
//        }
//
//        companion object {
//            const val REQUEST_KEY = "parent-request-key" const
//                    val KEY_NUMBER = "key-number"
//        }
//    }

    class ChildFragment : Fragment(R.layout.fragment_child) {
        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(
                view,
                savedInstanceState
            ) buttonChildDone . setOnClickListener {
                try {
                    val number = editTextChildNumber.text.toString()
                        .toInt() setFragmentResult (ParentFragment.REQUEST_KEY, bundleOf(ParentFragment.KEY_NUMBER to number))
                } catch (exception: NumberFormatException) {
                    Toast.makeText(
                        requireContext(),
                        R.string.invalid_number_error,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

}