package com.example.notesapp.data.local.note.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_table")
data class NoteEntity(
    @PrimaryKey(autoGenerate = true) val id : Int?,
    @ColumnInfo(name = "title") val title : String?,
    @ColumnInfo(name = "note") val note : String?,
    @ColumnInfo(name = "date") val date : String?
) : java.io.Serializable

fun NoteModel.toNoteEntity(): NoteEntity {
    return NoteEntity(
        id = if (id == -1) null else id,
        title = title,
        note = note,
        date = date,
    )
}