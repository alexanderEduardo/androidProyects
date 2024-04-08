package com.example.mifirstapp.todoapp

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class AdapterGeneric<T>(private val categories: List<T>): RecyclerView.Adapter<ViewHolderGeneric<T>>() {
    abstract override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderGeneric<T>

    abstract override fun onBindViewHolder(holder: ViewHolderGeneric<T>, position: Int)

    override fun getItemCount(): Int = categories.size
}