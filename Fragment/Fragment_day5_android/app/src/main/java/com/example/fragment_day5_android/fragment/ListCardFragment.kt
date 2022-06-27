package com.example.fragment_day5_android.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fragment_day5_android.CardObj
import com.example.fragment_day5_android.R
import com.example.fragment_day5_android.adapter.CardAdapter
import com.example.fragment_day5_android.model.Card
import kotlinx.android.synthetic.main.fragment_list_card.view.*


class ListCardFragment : Fragment() {
    private var rcvAdapter: CardAdapter? = null
    private val listcard: MutableList<Card> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Dataadapter()
    }

    private fun Dataadapter() {
        listcard.add(Card("12345","nguyen anh ky","08"))
        listcard.add(Card("123456", "fsdkfdsfkdf","09"))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list_card, container, false)

        rcvAdapter = CardAdapter(listcard)
        view.rcv_card.layoutManager =LinearLayoutManager(container?.context,LinearLayoutManager.VERTICAL,false)
        view.rcv_card.adapter =rcvAdapter

        setFragmentResultListener(CardObj.REQUEST_KEY){ resultKey, bundle ->
            val result = bundle.getSerializable(CardObj.BUNDLE_KEY) as Card
        }
        return view
    }




}