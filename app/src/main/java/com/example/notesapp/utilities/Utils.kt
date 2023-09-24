package com.example.notesapp.utilities

import java.text.SimpleDateFormat

/**
 * This function will return date in string format of dd/MM/YYYY
 */
fun Long.getDate() : String {
    return try {
        val formatter = SimpleDateFormat("dd/MM/yyyy")
        formatter.format(this)
    } catch (e: Exception) {
        "Invalid Long Date Value"
    }
}