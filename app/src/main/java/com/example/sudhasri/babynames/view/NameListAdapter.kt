package com.example.sudhasri.babynames.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.sudhasri.babynames.model.NameDTO

class NameListAdapter internal constructor(private val sources: List<NameDTO>)
    : RecyclerView.Adapter<NameListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(android.R.layout.simple_list_item_1, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nameText.text = sources[position].name
    }

    override fun getItemCount(): Int {
        return sources.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameText: TextView = view.findViewById<TextView>(android.R.id.text1)
    }
}