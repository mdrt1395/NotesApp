package com.example.notesapp.ui.main.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp.data.local.note.model.NoteModel
import com.example.notesapp.databinding.ListItemBinding
import com.example.notesapp.utilities.getDate

class NoteViewHolderV2(
    private val binding: ListItemBinding,
    private val onClick: (NoteModel) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: NoteModel) = binding.run {
        tvTitle.text = item.title
        tvNote.text = item.note
        tvDate.text = item.date.toLong().getDate()

        cardLayout.setOnClickListener {
            onClick(item)
        }
    }
}