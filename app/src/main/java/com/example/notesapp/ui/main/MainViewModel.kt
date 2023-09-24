package com.example.notesapp.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesapp.data.local.dataBase.NoteDatabase
import com.example.notesapp.data.local.note.NoteLocalDataSource
import com.example.notesapp.data.local.note.NoteLocalDataSourceImp
import com.example.notesapp.data.local.note.dao.NoteDao
import com.example.notesapp.data.local.note.model.NoteModel
import com.example.notesapp.domain.DeleteNoteUseCase
import com.example.notesapp.domain.GetAllNotesUseCase
import com.example.notesapp.repository.note.NoteRepository
import com.example.notesapp.repository.note.NoteRepositoryImp
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val noteDao: NoteDao = NoteDatabase.getDataBase().getNoteDao()
    private val repository: NoteRepository
    private val noteLocalDataSource: NoteLocalDataSource

    private val getAllNotesUseCase: GetAllNotesUseCase
    private val deleteNoteUseCase: DeleteNoteUseCase


    private var _noteStateFlow: MutableStateFlow<List<NoteModel>> = MutableStateFlow(emptyList())
    val noteStateFlow = _noteStateFlow.asStateFlow()

    init {
        noteLocalDataSource = NoteLocalDataSourceImp(noteDao)
        repository = NoteRepositoryImp(noteLocalDataSource)

        getAllNotesUseCase = GetAllNotesUseCase(repository)
        deleteNoteUseCase = DeleteNoteUseCase(repository)
    }

    fun deleteNote(noteEntity: NoteModel) = viewModelScope.launch {
        deleteNoteUseCase(noteEntity)
    }

    fun getAllNotes() = viewModelScope.launch {
        getAllNotesUseCase().collect {
            _noteStateFlow.emit(it)
        }
    }

    fun filterNotes(searchString: String, onSuccessFiltered: (data: List<NoteModel>) -> Unit) = viewModelScope.launch(IO) {
        // CODE TO FILTER
        // TO DO
        // WHEN CODE IS FINISH
        // withContext(Main) {
        // onSuccessFiltered(listFiltered)
        // }
    }
}


// We have changed from AndroidViewModel in the line 13 to ViewModel because we need to avoid pass Android Context to the viewModel, this could deliver a MemoryLeak
// Normally ViewModel name should match activity/fragment name