package com.example.notesapp.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.notesapp.databinding.ActivityMainBinding
import com.example.notesapp.ui.createNote.AddNoteActivityV2
import com.example.notesapp.ui.main.adapter.NotesAdapterV2
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class MainActivity2 : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainViewModel by viewModels()
    private val adapter: NotesAdapterV2 = NotesAdapterV2()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    override fun onResume() {
        super.onResume()
        viewModel.getAllNotes()
    }

    private fun initViews() = binding.run {
        rvNotes.adapter = adapter
        fbAddNote.setOnClickListener {
            val i = Intent(this@MainActivity2, AddNoteActivityV2::class.java)
            startActivity(i)
        }
        notesObserver()
    }

    private fun notesObserver() {
        viewModel.noteStateFlow.onEach { response ->
            adapter.updateList(response.toList())
        }.launchIn(lifecycleScope)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}