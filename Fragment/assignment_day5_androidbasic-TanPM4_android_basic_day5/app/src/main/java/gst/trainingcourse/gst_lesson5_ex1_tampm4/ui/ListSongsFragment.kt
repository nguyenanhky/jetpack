package gst.trainingcourse.gst_lesson5_ex1_tampm4.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.shingetsu.gst_lesson5_ex1_tampm4.R
import gst.trainingcourse.gst_lesson5_ex1_tampm4.Models.Songs
import gst.trainingcourse.gst_lesson5_ex1_tampm4.Utils.Utils

class ListSongsFragment : Fragment() {
    private var listSongAdapter = ListSongsAdapter()
    private lateinit var rcvListSong: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_list_songs, container, false)
        rcvListSong = view.findViewById(R.id.rcv_list_songs)
        initRecyclerView()
        return view
    }

    private fun initRecyclerView() {
        Utils.getDataExample()
        rcvListSong.layoutManager = LinearLayoutManager(requireContext())
        rcvListSong.setHasFixedSize(true)
        rcvListSong.adapter = listSongAdapter
        setAdapter(Utils.getDataExample())
    }

     fun setAdapter(listSongs: ArrayList<Songs>) {
        listSongAdapter.setData(listSongs)
    }


}