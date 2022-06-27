package com.example.fragment_day5_android.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.example.fragment_day5_android.CardObj
import com.example.fragment_day5_android.R
import com.example.fragment_day5_android.model.Card
import kotlinx.android.synthetic.main.fragment_card_information.view.*
import kotlinx.android.synthetic.main.fragment_update_infomation.*
import kotlinx.android.synthetic.main.fragment_update_infomation.view.*


class UpdateInfomationFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View = inflater.inflate(R.layout.fragment_update_infomation,container,false)

        val controller = findNavController()
        val bundle = arguments
        val card = bundle?.getSerializable("card") as Card
        view.edt_cardname.setText(card.carname)
        view.edt_cardnumber.setText(card.carnumber)
        view.edt_cardexp.setText(card.carexp)

        Log.d("anhky", "onCreateView:${view.edt_cardname.text.toString()} ")


        view.btn_save.setOnClickListener {
            val card_update:Card = Card(view.edt_cardnumber.text.toString(),view.edt_cardname.text.toString(),view.edt_cardexp.text.toString())
            setFragmentResult(
                CardObj.REQUEST_KEY,
                bundleOf(CardObj.BUNDLE_KEY to card_update)
            )
            findNavController().navigateUp()
        }


       return view
    }
}