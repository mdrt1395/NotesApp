package com.example.notesapp.ui.app

import android.app.Application
import com.example.notesapp.data.local.dataBase.NoteDatabase

class NoteApplication : Application() {

    override fun onCreate() {
        NoteDatabase.initializeDB(this)
        super.onCreate()
    }
}