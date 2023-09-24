package com.example.notesapp.data.local.note

import com.example.notesapp.data.local.note.model.NoteModel

interface NoteLocalDataSource {
    suspend fun insertNote(noteModel: NoteModel) : Long
    suspend fun deleteNote(noteModel: NoteModel) : Long
    suspend fun updateNote(noteModel: NoteModel) : Long

    suspend fun getAllNotes() : List<NoteModel>
}