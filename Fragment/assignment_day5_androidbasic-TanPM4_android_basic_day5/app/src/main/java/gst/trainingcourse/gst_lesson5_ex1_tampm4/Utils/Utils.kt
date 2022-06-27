package gst.trainingcourse.gst_lesson5_ex1_tampm4.Utils

import android.content.Context
import android.content.res.Configuration
import gst.trainingcourse.gst_lesson5_ex1_tampm4.Models.Songs

object Utils {
    fun isTablet(context: Context): Boolean {
        return ((context.resources.configuration.screenLayout
                and Configuration.SCREENLAYOUT_SIZE_MASK)
                >= Configuration.SCREENLAYOUT_SIZE_LARGE)
    }

    fun getDataExample() : ArrayList<Songs>{
        val listSongs = arrayListOf<Songs>()
        listSongs.add(Songs("https://shingetsu.000webhostapp.com/Image/ImageMusic/ac-ma-den-tu-thien-duong.jpg", "Ác ma đến từ thiên đường", "Đặng Tử Kỳ", "nhạc Trung, hiện đại", "best of November", 2020))
        listSongs.add(Songs("https://shingetsu.000webhostapp.com/Image/ImageMusic/believer.jpg", "Believer", "One Republic", "US/UK, rock", "believer", 2016))
        listSongs.add(Songs("https://shingetsu.000webhostapp.com/Image/ImageMusic/cung-anh.jpg", "Cùng anh", "Ngọc Doli", "nhạc Việt, hiện đại", "nhạc của năm", 2012))
        listSongs.add(Songs("https://shingetsu.000webhostapp.com/Image/ImageMusic/Kenshi_Yonezu_-_Lemon.png", "Lemon", "Kenshi Yoneru", "nhạc Nhật", "fall", 2018))
        listSongs.add(Songs("https://shingetsu.000webhostapp.com/Image/ImageMusic/OneRepublic_Counting_Stars_cover.png", "Counting star", "One Republic", "US/UK, rock", "new sky", 2020))
        listSongs.add(Songs("https://shingetsu.000webhostapp.com/Image/ImageMusic/save-me.jpg", "Save me", "DEAMN", "US/UK, nhạc điện tử", "best of November", 2019))
        listSongs.add(Songs("https://shingetsu.000webhostapp.com/Image/ImageMusic/take-me-hands.jpg", "Take me hand", "Dance Daishi", "nhạc Nhật", "fall", 2018))
        listSongs.add(Songs("https://shingetsu.000webhostapp.com/Image/ImageMusic/shape-of-you.jpg", "Shape of you", "Ed Sheeran", "US/UK", "my album", 2020))
        listSongs.add(Songs("https://shingetsu.000webhostapp.com/Image/ImageMusic/nao-ca-vang.jpg", "Não cá vàng", "Only C, Lou Hoàng", "nhạc Việt", "new sky", 2015))
        listSongs.add(Songs("https://shingetsu.000webhostapp.com/Image/ImageMusic/noi-tinh-yeu-bat-dau.jpg", "Nơi tình yêu bắt đầu", "Bùi Anh Tuấn", "nhạc Việt, chia tay", "best of November", 2017))
        listSongs.add(Songs("https://shingetsu.000webhostapp.com/Image/ImageMusic/pretty-girl.jpg", "Pretty girl", "Đặng Tử Kỳ", "US/UK, hiện đại", "sunsight", 2017))
        listSongs.add(Songs("https://shingetsu.000webhostapp.com/Image/ImageMusic/mo.jpg", "Mơ", "Vũ Cát Tường", "nhạc Việt, nhạc buồn", "nhạc của năm", 2020))
        listSongs.add(Songs("https://shingetsu.000webhostapp.com/Image/ImageMusic/nguoi-la-oi.jpg", "Người lạ ơi", "Orange, Karik", "nhạc Việt, tha thiết", "best of November", 2019))
        return listSongs
    }

    fun getSongBySinger(singer: String): ArrayList<Songs>{
        val listSongsBySinger = getDataExample().filter { it.singer.uppercase().contains(singer.uppercase())}
        return listSongsBySinger as ArrayList<Songs>
    }

    fun getSongByAlbum(album: String): ArrayList<Songs>{
        val listSongsByAlbum = getDataExample().filter { it.album.uppercase().contains(album.uppercase())}
        return listSongsByAlbum as ArrayList<Songs>
    }

}