package com.example.notesapp.repository.note

import com.example.notesapp.data.local.note.NoteLocalDataSource
import com.example.notesapp.data.local.note.model.NoteModel


/**
 * A Repository has the responsability to choose which data source will get the correct information,
 * **/
class NoteRepositoryImp(
    private val noteLocalDataSource: NoteLocalDataSource,
    // private val noteRemoteDataSource: NoteRemoteDataSource, -> A remote server[Google Cloud, AWS, or SelfHosted]
) : NoteRepository {
    override suspend fun insertNote(noteModel: NoteModel): Long =
        noteLocalDataSource.insertNote(noteModel)

    override suspend fun deleteNote(noteModel: NoteModel): Long =
        noteLocalDataSource.deleteNote(noteModel)

    override suspend fun updateNote(noteModel: NoteModel): Long =
        noteLocalDataSource.updateNote(noteModel)

    override suspend fun getAllNotes(): List<NoteModel> =
        noteLocalDataSource.getAllNotes()
}