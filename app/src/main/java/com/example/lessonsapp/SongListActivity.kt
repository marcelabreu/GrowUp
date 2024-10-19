package com.example.lessonsapp

import android.content.Intent
import android.os.Bundle
import android.util.LayoutDirection
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler

class SongListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_song_list)

        val recyclerView: RecyclerView = findViewById(R.id.rvSongList)


        val songList = listOf(
            SongModel("Numb", "Linkin Park", "Meteora","I'm tired of being what you want me to be\n" +
                    "Feeling so faithless, lost under the surface\n" +
                    "I don't know what you're expecting of me\n" +
                    "Put under the pressure of walking in your shoes\n" +
                    "Every step that I take is another mistake to you\n" +
                    "(Caught in the undertow, just caught in the undertow)", R.drawable.linkin_park),
            SongModel("The Nights", "Avicii", "Stories","Once upon a younger year\n" +
                    "When all our shadows disappeared\n" +
                    "The animals inside came out to play\n" +
                    "Went face to face with all our fears\n" +
                    "Learned our lessons through the tears\n" +
                    "Made memories we knew would never fade", R.drawable.the_nights),
            SongModel("Blinding Lights", "The Weekend", "Blinding Lights", "Yeah\n" +
                    "I've been tryna call\n" +
                    "I've been on my own for long enough\n" +
                    "Maybe you can show me how to love, maybe\n" +
                    "I'm going through withdrawals\n" +
                    "You don't even have to do too much\n" +
                    "You can turn me on with just a touch, baby",  R.drawable.the_weeknd),
        )
        // Adapter de ListView
        val adapter = SongRecyclerAdapter(this, songList) {selectedSong ->

            val intent = Intent(this, SongDetailsActivity::class.java).apply {
                putExtra("songTitle", selectedSong.title)
                putExtra("songArtist", selectedSong.artist)
                putExtra("songAlbum", selectedSong.album)
                putExtra("songImage", selectedSong.image)
                putExtra("songLyrics", selectedSong.letter)
            }
            startActivity(intent)
        }

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        recyclerView.apply {
            this.adapter = adapter
            this.layoutManager = layoutManager
        }

        adapter.setOnItemClickListener { song ->
            val intent = Intent(this, SongDetailsActivity::class.java).apply {
                putExtra("songTitle", song.title)
                putExtra("songArtist", song.artist)
                putExtra("songAlbum", song.album)
                putExtra("songImage", song.image)
                putExtra("songLyrics", song.letter)
            }
            startActivity(intent)
        }
    }
}