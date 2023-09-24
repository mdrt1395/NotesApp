package com.example.notesapp.data.local.note.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.notesapp.data.local.note.model.NoteEntity

//watch corroutines and roomdb vid after this

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(noteEntity: NoteEntity): Long

    @Delete
    fun delete(noteEntity: NoteEntity): Int

    @Query("Select * from notes_table order by id ASC")
    fun getAllNotes(): List<NoteEntity>

    @Query("UPDATE notes_table Set title = :title, note = :note WHERE id= :id")
    fun update(id: Int?, title: String?, note: String?): Int

    @Update
    fun update(noteEntity: NoteEntity): Int
}