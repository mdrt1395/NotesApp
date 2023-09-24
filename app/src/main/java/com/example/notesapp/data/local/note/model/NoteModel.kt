package com.example.notesapp.data.local.note.model

// We should use two different models for the flows,
// Once is for DB and other with the rest of app interaction

data class NoteModel(
    var id: Int = -1,
    var title: String = String(),
    var note: String = String(),
    var date: String = String(),
)

// Your NoteEntity fields can store nulls, that means that we need to ensure that our app note model
// should not have them ?: "elvis operator" helps us to check if the field is null, if it is, it put
// a default value for the field
fun NoteEntity.toNoteModel(): NoteModel {
    return NoteModel(
        id = id ?: -1,
        title = title ?: String(),
        note = note ?: String(),
        date = date ?: String(),
    )
}
