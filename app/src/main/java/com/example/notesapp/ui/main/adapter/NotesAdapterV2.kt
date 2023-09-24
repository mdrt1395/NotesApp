package com.example.notesapp.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp.data.local.note.model.NoteModel
import com.example.notesapp.databinding.ListItemBinding

/**
 * A better approach would be with ListAdapter instead of RecyclerView.Adapter
 * */
class NotesAdapterV2 : RecyclerView.Adapter<NoteViewHolderV2>() {
    private val dataList: MutableList<NoteModel> = mutableListOf()
    private var onEditListener: (() -> Unit)? = null
    private var onDeleteListener: (() -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolderV2 {
        return NoteViewHolderV2(
            binding = ListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            ),
            onClick = { noteToEdit ->
                // TO BE DEFINED
            }
        )
    }

    override fun getItemCount(): Int = dataList.size

    fun updateList(list: List<NoteModel>) {
        dataList.clear()
        dataList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: NoteViewHolderV2, position: Int) {
        holder.bind(dataList[position])
    }

    /**
     * OnEditListenerCallBack
     */
    fun onEditListener(onEdit: () -> Unit) {
        onEditListener = onEdit
    }

    /**
     * onDeleteListener
     */
    fun onDeleteListener(onDelete: () -> Unit) {
        onDeleteListener = onDelete
    }
}