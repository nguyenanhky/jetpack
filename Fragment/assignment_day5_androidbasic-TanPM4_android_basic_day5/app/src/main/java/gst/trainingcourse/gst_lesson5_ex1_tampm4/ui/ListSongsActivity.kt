package gst.trainingcourse.gst_lesson5_ex1_tampm4.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.GravityCompat
import com.shingetsu.gst_lesson5_ex1_tampm4.R
import gst.trainingcourse.gst_lesson5_ex1_tampm4.Models.Songs
import gst.trainingcourse.gst_lesson5_ex1_tampm4.Utils.Utils
import kotlinx.android.synthetic.main.activity_main.*

class ListSongsActivity : AppCompatActivity(), OnItemClickListener {
    private var listSongs = arrayListOf<Songs>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        img_menu_left.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }
        img_menu_right.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.END)
        }
        navLeft.setNavigationItemSelectedListener {
            val fragmentListSongs = supportFragmentManager.findFragmentById(R.id.list_songs_fragment) as ListSongsFragment
            listSongs = when (it.itemId) {
                R.id.singger_1 -> Utils.getSongBySinger("Đặng Tử Kỳ")
                R.id.singger_2 -> Utils.getSongBySinger("One Republic")
                R.id.singger_3 -> Utils.getSongBySinger("Only C")
                R.id.singger_4 -> Utils.getSongBySinger("Bùi Anh Tuấn")
                R.id.singger_5 -> Utils.getSongBySinger("Sheeran")
                else -> Utils.getDataExample()
            }
            fragmentListSongs.setAdapter(listSongs)
            drawerLayout.closeDrawers()
            true
        }
        navRight.setNavigationItemSelectedListener {
            val fragmentListSongs = supportFragmentManager.findFragmentById(R.id.list_songs_fragment) as ListSongsFragment
            listSongs = when (it.itemId) {
                R.id.album_1 -> Utils.getSongByAlbum("November")
                R.id.album_2 -> Utils.getSongByAlbum("Believer")
                R.id.album_3 -> Utils.getSongByAlbum("year")
                R.id.album_4 -> Utils.getSongByAlbum("Sunsight")
                R.id.album_5 -> Utils.getSongByAlbum("Nhạc của năm")
                else -> Utils.getDataExample()
            }
            fragmentListSongs.setAdapter(listSongs)
            drawerLayout.closeDrawers()
            true
        }
    }

    override fun onItemClicked(song: Songs) {
        if (Utils.isTablet(this)) {
            val fragmentB =
                supportFragmentManager.findFragmentById(R.id.song_detail_fragment) as SongDetailFragment?
            fragmentB?.showDetail(song)
        } else {
            val intent = Intent(this, SongDetailActivity::class.java)
            intent.putExtra("data", song)
            startActivity(intent)
        }
    }


}