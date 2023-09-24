package com.example.notesapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.notesapp.Models.Note
import com.example.notesapp.databinding.ActivityAddNoteBinding
import java.text.SimpleDateFormat
import java.util.Date

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
            old_Note = intent.getSerializableExtra("current_note") as Note
            binding.etTitle.setText(old_Note.title)
            binding.etNote.setText(old_Note.note)
            isUpdate = true

        } catch (e: Exception){
            e.printStackTrace()
        }

        binding.imgCheck.setOnClickListener{
            val title = binding.etTitle.text.toString()
            val noteDesc = binding.etNote.text.toString()

            if (title.isNotEmpty() || noteDesc.isNotEmpty()){
                val formatter = SimpleDateFormat("EEE, d MMM yyyy HH:nn a")

                if (!isUpdate){
                    note = Note(
                        old_Note.id,title,noteDesc,formatter.format(Date())
                    )
                } else{
                    note = Note(
                        null,title,noteDesc,formatter.format(Date())
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