package com.example.notesapp.ui.main.adapter
/*

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp.ui.main.MainActivity
import com.example.notesapp.data.local.note.model.NoteEntity
import com.example.notesapp.R
import kotlin.random.Random

/**
 * We must not pass context as a param, it could generates memory leaks,
 * we can get context from any view in this case [parent: ViewGroup] in onCreateViewHolder
 * * ViewHolder and Adapter should be in different files for better practices.
 * * Each file must have only one responsibility
 * * * Filter should be in ViewModel it could cause a crash or ANR
 */


class NotesAdapter(private val context: Context, val listener: MainActivity) :
    RecyclerView.Adapter<NotesAdapter.NoteViewHolder>() {

    private val notesList = ArrayList<NoteEntity>()
    private val fullList = ArrayList<NoteEntity>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            LayoutInflater.from(context).inflate((R.layout.list_item), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return notesList.size
    }

    fun updateList(newList: List<NoteEntity>) {

        fullList.clear()
        fullList.addAll(newList)

        notesList.clear()
        notesList.addAll(fullList)
        notifyDataSetChanged()

    }

    fun filterList(search: String) {

        notesList.clear()

        for (item in fullList) {

            if (item.title?.lowercase()?.contains(search.lowercase()) == true ||
                item.note?.lowercase()?.contains(search.lowercase()) == true
            ) {

                notesList.add(item)
            }


        }

        notifyDataSetChanged()

    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote = notesList[position]
        holder.title.text = currentNote.title
        holder.title.isSelected = true

        holder.Note_tv.text = currentNote.note
        holder.date.text = currentNote.date
        holder.date.isSelected = true

        holder.notes_layout.setCardBackgroundColor(
            holder.itemView.resources.getColor(
                RandomColor(),
                null
            )
        )

        holder.notes_layout.setOnClickListener {
            listener.onItemClicked(notesList[holder.adapterPosition])
        }

        holder.notes_layout.setOnLongClickListener {
            listener.onLongItemClicked(notesList[holder.adapterPosition], holder.notes_layout)
            true
        }


    }

    fun RandomColor(): Int {

        val list = ArrayList<Int>()
        list.add(R.color.NoteColor1)
        list.add(R.color.NoteColor2)
        list.add(R.color.NoteColor3)
        list.add(R.color.NoteColor4)
        list.add(R.color.NoteColor5)
        list.add(R.color.NoteColor6)

        val seed = System.currentTimeMillis().toInt()
        val randomIndex = Random(seed).nextInt(list.size)
        return list[randomIndex]

    }

    inner class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val notes_layout = itemView.findViewById<CardView>(R.id.card_layout)
        val title = itemView.findViewById<TextView>(R.id.tv_title)
        val Note_tv = itemView.findViewById<TextView>(R.id.tv_note)
        val date = itemView.findViewById<TextView>(R.id.tv_date)

    }

    interface NotesClickListener {
        fun onItemClicked(noteEntity: NoteEntity)
        fun onLongItemClicked(noteEntity: NoteEntity, cardView: CardView)
    }
}

 */