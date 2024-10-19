package com.example.lessonsapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SongRecyclerAdapter(
    private val context: Context,
    private val list: List<SongModel>,
    private val onClickListener: (SongModel) -> Unit
) : RecyclerView.Adapter<SongRecyclerAdapter.SongViewHolder>() {

    private var onItemClickListener: ((SongModel) -> Unit)? = null

    fun setOnItemClickListener(listener: (SongModel) -> Unit) {
        onItemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.it_song_list, parent, false)
        return SongViewHolder(view)
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        val song = list[position]
        holder.bind(song, onClickListener)
    }

    override fun getItemCount(): Int = list.size

    class SongViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val songCover: ImageView = view.findViewById(R.id.ivSongCover)
        private val songTitle: TextView = view.findViewById(R.id.tvSongTitle)
        private val songArtist: TextView = view.findViewById(R.id.tvSongArtist)

        fun bind(song: SongModel, onClickListener: (SongModel) -> Unit) {
            songCover.setImageResource(song.image)
            songTitle.text = song.title
            songArtist.text = song.artist

            itemView.setOnClickListener {
                onClickListener(song)
            }
        }
    }
}
