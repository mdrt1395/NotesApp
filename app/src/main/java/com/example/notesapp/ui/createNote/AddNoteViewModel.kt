package com.example.notesapp.ui.createNote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesapp.data.local.dataBase.NoteDatabase
import com.example.notesapp.data.local.note.NoteLocalDataSource
import com.example.notesapp.data.local.note.NoteLocalDataSourceImp
import com.example.notesapp.data.local.note.dao.NoteDao
import com.example.notesapp.data.local.note.model.NoteModel
import com.example.notesapp.domain.InsertNewUseCase
import com.example.notesapp.domain.UpdateNoteUseCase
import com.example.notesapp.repository.note.NoteRepository
import com.example.notesapp.repository.note.NoteRepositoryImp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AddNoteViewModel : ViewModel() {
    private val noteDao: NoteDao = NoteDatabase.getDataBase().getNoteDao()
    private val repository: NoteRepository
    private val noteLocalDataSource: NoteLocalDataSource

    private val insertNewUseCase: InsertNewUseCase
    private val updateNoteUseCase: UpdateNoteUseCase

    init {
        noteLocalDataSource = NoteLocalDataSourceImp(noteDao)
        repository = NoteRepositoryImp(noteLocalDataSource)
        insertNewUseCase = InsertNewUseCase(repository)
        updateNoteUseCase = UpdateNoteUseCase(repository)
    }


    fun addNote(note: NoteModel, onSuccess: () -> Unit) {
        insertNewUseCase.invoke(note).onEach {
            withContext(Dispatchers.Main) {
                onSuccess()
            }
        }.launchIn(viewModelScope)
    }
}