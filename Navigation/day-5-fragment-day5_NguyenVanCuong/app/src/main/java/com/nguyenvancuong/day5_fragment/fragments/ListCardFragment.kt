package com.nguyenvancuong.day5_fragment.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.nguyenvancuong.day5_fragment.R
import com.nguyenvancuong.day5_fragment.adapters.CardAdapter
import com.nguyenvancuong.day5_fragment.models.Card
import kotlinx.android.synthetic.main.fragment_list_card.*
import kotlinx.android.synthetic.main.fragment_list_card.view.*

class ListCardFragment : Fragment() {

    private var rcvAdapter: CardAdapter? = null;
    private var listCard: MutableList<Card> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDataAdater()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list_card, container, false)
        rcvAdapter = CardAdapter(listCard, { card, position ->
           infoOnclick(card, view, position)
        })
        view.rcv_card.layoutManager =
            LinearLayoutManager(container?.context, LinearLayoutManager.VERTICAL, false)
        view.rcv_card.adapter = rcvAdapter;
        return view;
    }

    private fun infoOnclick(card: Card, view: View, position: Int) {
        val cardBundle: Bundle = Bundle()
        cardBundle.putSerializable("card", card)
        setFragmentResultListener(CardInfoFragment.REQUEST_KEY) { resultKey, bundle ->
            listCard[position] = bundle.getSerializable("card") as Card
            rcvAdapter?.notifyDataSetChanged()
        }
        Navigation.findNavController(view).navigate(R.id.action_list_to_info,cardBundle)
    }

    private fun initDataAdater() {
//        for (i in 10..30) {
//            listCard.add(Card("123456$i", "Nguyen Van " + ('A' + (i - 10)), "08/$i"))
//        }
        listCard.add(Card("12345","nguyen anh ky","08"))
        listCard.add(Card("123456", "Tran Ngoc Anh","09"))
    }
}