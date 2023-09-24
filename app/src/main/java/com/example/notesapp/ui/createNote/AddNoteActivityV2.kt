package com.example.notesapp.ui.createNote

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.notesapp.R
import com.example.notesapp.data.local.note.model.NoteModel
import com.example.notesapp.databinding.ActivityAddNoteBinding
import java.util.Calendar

class AddNoteActivityV2 : AppCompatActivity() {
    private var _binding: ActivityAddNoteBinding? = null
    private val binding get() = _binding!!

    private val viewModel: AddNoteViewModel by viewModels()
    private val calendar: Calendar = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() = binding.run {
        imgBackArrow.setOnClickListener {
            finish()
        }
        imgCheck.setOnClickListener {
            saveNote()
        }
    }

    private fun saveNote() = binding.run {
        val titleNote = txtTitle.text.toString()
        val contentNote = txtNote.text.toString()

        if (titleNote.isEmpty()) {
            Toast.makeText(
                this@AddNoteActivityV2,
                resources.getString(R.string.note_title_empty),
                Toast.LENGTH_LONG
            ).show()
            return@run
        }

        if (contentNote.isEmpty()) {
            Toast.makeText(
                this@AddNoteActivityV2,
                resources.getString(R.string.note_content_empty),
                Toast.LENGTH_LONG
            ).show()
            return@run
        }

        val note = NoteModel(
            id = -1,
            title = titleNote,
            note = contentNote,
            date = calendar.timeInMillis.toString(),
        )

        viewModel.addNote(note = note, onSuccess = {
            Toast.makeText(
                this@AddNoteActivityV2,
                resources.getString(R.string.note_saved),
                Toast.LENGTH_LONG
            ).show()
            finish()
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}