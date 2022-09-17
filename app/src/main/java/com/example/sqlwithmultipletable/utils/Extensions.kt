package com.example.sqlwithmultipletable.utils

import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar

fun Fragment.snack(message: String) {
    Snackbar.make(this.requireView(), message, Snackbar.LENGTH_LONG).show()
}