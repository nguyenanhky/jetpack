package com.example.fragment_day5_android.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.fragment_day5_android.R
import com.example.fragment_day5_android.model.Card
import kotlinx.android.synthetic.main.item.view.*

class CardAdapter(private val mutableList_card: MutableList<Card>):RecyclerView.Adapter<CardAdapter.CardViewholder>() {

    inner class CardViewholder(view: View):RecyclerView.ViewHolder(view){
        val txt_name:TextView = view.txt_name
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewholder {
        val view:View =LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return CardViewholder(view)
    }

    override fun onBindViewHolder(holder: CardViewholder, position: Int) {
        val card = mutableList_card[position]
        holder.txt_name.text = card.carname

        holder.itemView.setOnClickListener {
            val bundle = bundleOf(
                "card" to card
            )
            Navigation.findNavController(holder.itemView)
                .navigate(R.id.cardInformationFragment2, bundle)

        }
    }

    override fun getItemCount(): Int {
        return mutableList_card.size
    }
}