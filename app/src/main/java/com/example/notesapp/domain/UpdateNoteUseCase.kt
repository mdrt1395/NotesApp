package com.example.notesapp.domain

import android.util.Log
import com.example.notesapp.data.local.note.model.NoteModel
import com.example.notesapp.repository.note.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

/**
 * Use cases will represent a unique function call,
 * and they are responsible of emitting states like [Success, Loading, Error]
 * In this case we're gonna keep this use case as simple as possible
 */
class UpdateNoteUseCase(
    private val noteRepository: NoteRepository,
) {
    operator fun invoke(noteModel: NoteModel) = flow {
        try {
            emit(noteRepository.updateNote(noteModel))
        } catch (e: Exception) {
            Log.e("USE CASE ERROR", e.message.orEmpty())
            emit(-1)
        }
    }.flowOn(Dispatchers.IO)
}