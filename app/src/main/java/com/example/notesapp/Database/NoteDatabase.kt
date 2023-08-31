package com.example.notesapp.Database

import androidx.room.Database
import com.example.notesapp.Models.Note

//ask about all these things

@Database(entities = arrayOf(Note::class), version = 1, exportSchema = false)
class NoteDatabase {

    abstract fun

}