package gst.trainingcourse.gst_lesson5_ex1_tampm4.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.shingetsu.gst_lesson5_ex1_tampm4.R
import gst.trainingcourse.gst_lesson5_ex1_tampm4.Models.Songs
import gst.trainingcourse.gst_lesson5_ex1_tampm4.Utils.Utils
import kotlinx.android.synthetic.main.item_song.view.*

class ListSongsAdapter : RecyclerView.Adapter<ListSongsAdapter.ViewHolder>() {
    private val mListSong = mutableListOf<Songs>()
    var selectedPosition = -1


    fun getListData() = mListSong

    fun setData(list: MutableList<Songs>) {
        mListSong.clear()
        mListSong.addAll(list)
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        fun bind(obj: Songs, position: Int) {
            Glide
                .with(itemView)
                .load(obj.image)
                .into(itemView.img_item_song)

            itemView.tv_title.text = obj.name
            itemView.tv_singer.text = obj.singer

            if (Utils.isTablet(itemView.context) && selectedPosition == position) {
                itemView.setBackgroundColor(Color.parseColor("#9559FF"))
            } else{
                itemView.setBackgroundColor(Color.TRANSPARENT)
            }

            itemView.setOnClickListener {
                val listener = itemView.context as OnItemClickListener
                listener.onItemClicked(obj)
                selectedPosition = position
                notifyDataSetChanged()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_song, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mListSong[position], position)
    }

    override fun getItemCount(): Int {
        return mListSong.size
    }

}