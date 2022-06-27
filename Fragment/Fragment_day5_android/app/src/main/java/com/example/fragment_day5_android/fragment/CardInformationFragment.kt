package com.example.fragment_day5_android.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.example.fragment_day5_android.CardObj
import com.example.fragment_day5_android.R
import com.example.fragment_day5_android.model.Card
import kotlinx.android.synthetic.main.fragment_card_information.*
import kotlinx.android.synthetic.main.fragment_card_information.view.*
import kotlinx.android.synthetic.main.fragment_update_infomation.view.*
import kotlinx.android.synthetic.main.item.*
import kotlinx.android.synthetic.main.item.view.*
import kotlin.math.log

class CardInformationFragment : Fragment() {

    private var card: Card?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view:View = inflater.inflate(R.layout.fragment_card_information, container, false)

        val controller = findNavController()
        val bundle = arguments
        val card = bundle?.getSerializable("card") as Card
        view.txt_cardname.text = card.carname
        view.txt_cardnumber.text = card.carnumber
        view.txt_cardexp.text = card.carexp

        // update
        view.btn_update.setOnClickListener {
            val bundle = bundleOf(
                "card" to card
            )
           findNavController().navigate(R.id.updateInfomationFragment, bundle)

        }
        setFragmnetListener(view)

        view.btn_close.setOnClickListener {
            val card_update:Card = Card(view.txt_cardnumber.text.toString(),view.txt_cardname.text.toString(), view.txt_cardexp.text.toString())
            setFragmentResult(
                CardObj.REQUEST_KEY,
                bundleOf(CardObj.BUNDLE_KEY to card_update)
            )
            findNavController().navigateUp()
        }
        return view
    }

    private fun setFragmnetListener(view: View) {
        setFragmentResultListener(CardObj.REQUEST_KEY){resultKey, bundle ->  
            val result = bundle.getSerializable(CardObj.BUNDLE_KEY) as Card
            view.txt_cardname.text = result.carname
            view.txt_cardnumber.text = result.carnumber
            view.txt_cardexp.text = result.carexp
        }
    }
}