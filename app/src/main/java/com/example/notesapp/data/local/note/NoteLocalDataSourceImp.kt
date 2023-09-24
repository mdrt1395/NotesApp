package com.example.notesapp.data.local.note

import androidx.lifecycle.map
import com.example.notesapp.data.local.note.dao.NoteDao
import com.example.notesapp.data.local.note.model.NoteModel
import com.example.notesapp.data.local.note.model.toNoteEntity
import com.example.notesapp.data.local.note.model.toNoteModel

class NoteLocalDataSourceImp(
    private val noteDao: NoteDao,
) : NoteLocalDataSource {
    override suspend fun insertNote(noteModel: NoteModel): Long {
        val noteEntity = noteModel.toNoteEntity()
        return noteDao.insert(noteEntity = noteEntity)
    }

    override suspend fun deleteNote(noteModel: NoteModel): Long {
        val noteEntity = noteModel.toNoteEntity()
        return noteDao.delete(noteEntity).toLong()
    }

    override suspend fun updateNote(noteModel: NoteModel): Long {
        val noteEntity = noteModel.toNoteEntity()
        return noteDao.update(noteEntity).toLong()
    }

    override suspend fun getAllNotes(): List<NoteModel> {
        val list = noteDao.getAllNotes()
        return list.map { it.toNoteModel() }
    }
}