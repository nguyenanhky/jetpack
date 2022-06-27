package gst.trainingcourse.gst_lesson5_ex1_tampm4.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.shingetsu.gst_lesson5_ex1_tampm4.R
import gst.trainingcourse.gst_lesson5_ex1_tampm4.Models.Songs

class SongDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_song_detail)

        val song = intent.getSerializableExtra("data") as Songs
        val detailFragment = supportFragmentManager.findFragmentById(R.id.song_detail_fragment) as SongDetailFragment?
        detailFragment?.showDetail(song)
    }
}