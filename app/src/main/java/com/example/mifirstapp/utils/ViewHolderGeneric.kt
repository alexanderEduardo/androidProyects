package com.example.mifirstapp.utils

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class ViewHolderGeneric<T>(view: View): RecyclerView.ViewHolder(view) {

    abstract fun render(dataRv: T)
}