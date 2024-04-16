package com.example.mifirstapp.utils

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class AdapterGeneric<T>(private val list: List<T>): RecyclerView.Adapter<ViewHolderGeneric<T>>() {
    abstract override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderGeneric<T>

    abstract override fun onBindViewHolder(holder: ViewHolderGeneric<T>, position: Int)

    abstract override fun getItemCount(): Int

    abstract fun setList(list: List<T>)

    abstract fun getList(): List<T>
}