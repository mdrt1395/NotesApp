package com.example.notesapp.data.local.dataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.notesapp.utilities.DATABASE_NAME
import com.example.notesapp.data.local.note.dao.NoteDao
import com.example.notesapp.data.local.note.model.NoteEntity

//ask about all these things
//what is a synchronized lock

@Database(entities = arrayOf(NoteEntity::class), version = 1, exportSchema = false)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun getNoteDao(): NoteDao

    companion object {

        @Volatile
        private lateinit var INSTANCE: NoteDatabase

        /**
         *  This should be called once, we create the DB when the app starts in the NoteApplication class,
         *  and then we only need to call getDataBase function without passing context
         * **/
        fun initializeDB(context: Context) {
            val instance = Room.databaseBuilder(
                context,
                NoteDatabase::class.java,
                DATABASE_NAME
            ).build()

            INSTANCE = instance
        }

        /**
         * Call this function only if have called [initializeDB] before
         * **/
        fun getDataBase(): NoteDatabase {
            return INSTANCE
        }

    }

}