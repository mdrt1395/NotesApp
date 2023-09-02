package com.example.notesapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.notesapp.Models.Note
import com.example.notesapp.databinding.ActivityAddNoteBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.logging.SimpleFormatter

class AddNote : AppCompatActivity() {

    private lateinit var binding: ActivityAddNoteBinding

    private lateinit var note: Note
    private lateinit var old_Note: Note
    var isUpdate = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        try {
            old_Note = intent.getSerializableExtra("current_note")
            binding.etTitle.setText(old_Note.title)
            binding.etNote.setText(old_Note.note)
            isUpdate = true

        } catch (e: Exception){
            e.printStackTrace()
        }

        binding.imgCheck.setOnClickListener{
            val title = binding.etTitle.text.toString()
            val note_desc = binding.etNote.text.toString()

            if (title.isNotBlank() || note.isNotEmpty()){
                val formatter = SimpleDateFormat("EEE, d MMM yyyy HH:nn a")

                if (!isUpdate){
                    note = Note(
                        old_Note.id,title,note,formatter.format(Date())
                    )
                } else{
                    note = Note(
                        null,title,note_desc,formatter.format(Date())
                    )


                }

                val intent = Intent()
                intent.putExtra("note", note)
                setResult(RESULT_OK,intent)
                finish()

            } else {
                Toast.makeText(this@AddNote,"Please enter some data", Toast.LENGTH_SHORT)

            }

        }

        binding.imgBackArrow.setOnClickListener{
            onBackPressed()
        }

    }
}