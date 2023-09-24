/*
package com.example.notesapp.ui.createNote

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.notesapp.data.local.note.model.NoteEntity
import com.example.notesapp.databinding.ActivityAddNoteBinding
import java.text.SimpleDateFormat
import java.util.Date


class AddNoteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddNoteBinding

    private lateinit var noteEntity: NoteEntity
    private lateinit var old_NoteEntity: NoteEntity // You should create your model when is needed
    var isUpdate = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        try {
            old_NoteEntity = intent.getSerializableExtra("current_note") as NoteEntity
            binding.etTitle.setText(old_NoteEntity.title)
            binding.etNote.setText(old_NoteEntity.note)
            isUpdate = true

        } catch (e: Exception){
            e.printStackTrace()
        }

        binding.imgCheck.setOnClickListener{
            val title = binding.etTitle.text.toString()
            val noteDesc = binding.etNote.text.toString()

            if (title.isNotEmpty() || noteDesc.isNotEmpty()){
                val formatter = SimpleDateFormat("yyyy:HH:dd")

                if (!isUpdate){
                    noteEntity = NoteEntity(
                        old_NoteEntity.id,title,noteDesc,formatter.format(Date())
                    )
                } else{
                    noteEntity = NoteEntity(
                        null,title,noteDesc,formatter.format(Date())
                    )


                }

                val intent = Intent()
                intent.putExtra("note", noteEntity)
                setResult(RESULT_OK,intent)
                finish()

            } else {
                Toast.makeText(this@AddNoteActivity,"Please enter some data", Toast.LENGTH_SHORT)

            }

        }

        binding.imgBackArrow.setOnClickListener{
            onBackPressed()
        }

    }
}
 */
