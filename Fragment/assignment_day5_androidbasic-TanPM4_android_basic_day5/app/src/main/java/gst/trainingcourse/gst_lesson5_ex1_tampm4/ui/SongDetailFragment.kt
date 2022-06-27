package gst.trainingcourse.gst_lesson5_ex1_tampm4.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.shingetsu.gst_lesson5_ex1_tampm4.R
import gst.trainingcourse.gst_lesson5_ex1_tampm4.Models.Songs


class SongDetailFragment : Fragment() {
    private lateinit var imgSong: ImageView
    private lateinit var txtTitle: TextView
    private lateinit var txtSinger: TextView
    private lateinit var txtCategory: TextView
    private lateinit var txtAlbum: TextView
    private lateinit var txtYear: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_song_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imgSong = view.findViewById(R.id.img_song)
        txtTitle = view.findViewById(R.id.tv_song_title)
        txtSinger = view.findViewById(R.id.tv_song_singer)
        txtCategory = view.findViewById(R.id.tv_category)
        txtAlbum = view.findViewById(R.id.tv_album)
        txtYear = view.findViewById(R.id.tv_year)
    }


    fun showDetail(song : Songs) {
        Glide.with(requireContext())
            .load(song.image)
            .into(imgSong)
        txtTitle.text = song.name
        txtSinger.text =song.singer
        txtCategory.text = song.categogy
        txtAlbum.text = song.album
        txtYear.text = song.year.toString()

    }
}